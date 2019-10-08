package spittr.pojo;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Spitter {

    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "姓氏必须在2和30之间")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message = "名称必须在2和30之间")
    private String lastName;

    @NotNull
    @Size(min = 5, max = 16, message = "用户名必须在5和16之间")
    private String userName;

    @NotNull
    @Size(min = 5, max = 25, message = "密码必须在2和30之间")
    private String passWord;

    private String email;

    private String imageUrl;

    public Spitter(String firstName, String lastName, String userName, String passWord, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }
}
