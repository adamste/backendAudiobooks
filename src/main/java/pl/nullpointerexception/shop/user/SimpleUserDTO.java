package pl.nullpointerexception.shop.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SimpleUserDTO {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private User.UserType type;
}
