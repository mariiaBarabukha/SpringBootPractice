package BL.Users;

import BL.IEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public abstract class User implements IEntity {
    protected UUID idStudent;
    protected String firstName;
    protected String lastName;
    protected Date birthday;
    protected String phoneNumber;
    protected String email;

    public User(String fn, String ln, Date bd, String phone, String email){
        firstName = fn;
        lastName = ln;
        birthday = bd;
        phoneNumber = phone;
        this.email = email;
        idStudent = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }


    public String getFullName() {
        return firstName+lastName;
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

    @Override
    public UUID getId(){
        return getId();
    }

}
