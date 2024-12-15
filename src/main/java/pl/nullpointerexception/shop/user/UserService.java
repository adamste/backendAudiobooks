package pl.nullpointerexception.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public SimpleUserDTO getUser(Long id) {
        return userRepo.findById(id)
                .map(entity -> new SimpleUserDTO(
                        entity.getName(),
                        entity.getSurname(),
                        entity.getEmail(),
                        entity.getPhone(),
                        entity.getType()))
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setType(userDTO.getType());
        return userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public UserUpdateDTO updateUser(Long id, User updatedUser) {
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        user.setType(updatedUser.getType());
        User save = userRepo.save(user);
        return new UserUpdateDTO(save.getName(), save.getSurname(), save.getEmail(), save.getPhone(), save.getType());
    }
}
