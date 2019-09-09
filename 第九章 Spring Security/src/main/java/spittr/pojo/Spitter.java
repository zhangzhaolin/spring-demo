package spittr.pojo;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;
import java.util.Objects;

public class Spitter {

    private Long id;

    @NotNull
    @Size(min = 2 , max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2 , max = 30)
    private String lastName;

    @NotNull
    @Size(min = 2 , max = 16)
    private String userName;

    @NotNull
    @Size(min = 2 , max = 25)
    private String passWord;

    private String email;

    private String imgLogo;

    public Spitter(Long id,String firstName , String lastName , String userName , String passWord , String email , String imgLogo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.imgLogo = imgLogo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spitter spitter = (Spitter) o;
        return Objects.equals(id , spitter.id) &&
                Objects.equals(firstName , spitter.firstName) &&
                Objects.equals(lastName , spitter.lastName) &&
                Objects.equals(userName , spitter.userName) &&
                Objects.equals(passWord , spitter.passWord) &&
                Objects.equals(email , spitter.email) &&
                Objects.equals(imgLogo , spitter.imgLogo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id , firstName , lastName , userName , passWord , email , imgLogo);
    }
}
