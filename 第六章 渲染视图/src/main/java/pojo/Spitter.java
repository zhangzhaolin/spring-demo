package pojo;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;

public class Spitter {

    private Long id;

    @NotNull
    @Size(min = 2 , max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2 , max = 30)
    private String lastName;

    @NotNull
    @Size(min = 5 , max = 16)
    private String userName;

    @NotNull
    @Size(min = 5 , max = 25)
    private String passWord;

    private String email;

    public Spitter(String firstName , String lastName , String userName , String passWord , String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
