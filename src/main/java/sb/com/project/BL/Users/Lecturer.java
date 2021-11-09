package sb.com.project.BL.Users;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Past;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Lecturer {
    @Id
    @GeneratedValue
    private int id;

    protected String firstName;
    protected String lastName;

    @Past
    protected Date birthday;

    @NotBlank(message = "phone should be not blank")
    protected String phoneNumber;

    protected String email;

    public Lecturer(String fn, String ln, Date bd,
                    String phone, String email) {
        firstName = fn;
        lastName = ln;
        birthday = bd;
        phoneNumber = phone;
        this.email = email;
    }

    public Lecturer() {
    }

    public String getFirstName() {
        return firstName;
    }


    public String getFullName() {
        return firstName + lastName;
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


    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
