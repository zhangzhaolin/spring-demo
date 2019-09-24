package spittr.pojo;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Spitter {

    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @Size(min = 5, max = 16)
    private String userName;

    @NotNull
    @Size(min = 5, max = 25)
    private String passWord;

    private String email;

    public Spitter(String firstName, String lastName, String userName, String passWord, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }
}
