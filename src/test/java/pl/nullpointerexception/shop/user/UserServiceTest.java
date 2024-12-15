package pl.nullpointerexception.shop.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testFailSaveUser() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.saveUser(new UserDTO());
        });
    }

    @Test
    void saveUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Adam");
        userDTO.setSurname("Nowak");
        userDTO.setEmail("adsfma@gmail.com");
        userDTO.setPhone("898989");
        userDTO.setType(User.UserType.USER);
        userDTO.setPassword("<PASSWORD>");

        User user = userService.saveUser(userDTO);
        assertNotNull(user);
        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getSurname(), user.getSurname());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getPhone(), user.getPhone());
        assertEquals(userDTO.getType(), user.getType());
        assertNotEquals(userDTO.getPassword(), user.getPassword());
    }

    @Test
    void updateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Adam");
        userDTO.setSurname("Nowak");
        userDTO.setEmail("adsfma@gmail.com");
        userDTO.setPhone("898989");
        userDTO.setType(User.UserType.USER);
        userDTO.setPassword("<PASSWORD>");
        User user = userService.saveUser(userDTO);


        UserDTO userDTO = new UserDTO();
        userDTO.setName("Adam");
        userDTO.setSurname("Nowak");
        userDTO.setEmail("adsfma@gmail.com");
        userDTO.setPhone("898989");
        userDTO.setType(User.UserType.USER);

        userService.updateUser(user.getId(),
    }

}