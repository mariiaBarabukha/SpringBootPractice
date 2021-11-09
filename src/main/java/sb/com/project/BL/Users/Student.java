package sb.com.project.BL.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import sb.com.project.BL.StGroup;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student{

    @Id
    @GeneratedValue
    private int id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private StGroup group;

    public StGroup getGroup() {
        return group;
    }

    public void setGroup(StGroup group) {
        this.group = group;
    }

    public Student(){}

    public Student(String fn, String ln, Date bd, String phone, String email, StGroup group){
        firstName = fn;
        lastName = ln;
        birthday = bd;
        phoneNumber = phone;
        this.email = email;
        this.group = group;
    }


    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String firstName;
    protected String lastName;
    protected Date birthday;
    protected String phoneNumber;
    protected String email;

//    public User(String fn, String ln, Date bd, String phone, String email){
//        firstName = fn;
//        lastName = ln;
//        birthday = bd;
//        phoneNumber = phone;
//        this.email = email;
//    }
//
//    public User(){}

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


}
