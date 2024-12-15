package pl.nullpointerexception.shop.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserUpdateDTO {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private User.UserType type;
}
