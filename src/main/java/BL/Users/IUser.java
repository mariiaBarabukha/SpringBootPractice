package BL.Users;

import java.util.Date;

public interface IUser {
    public String getFirstName();


    public String getFullName();


    public void setFirstName(String firstName);

    public String getLastName();


    public void setLastName(String lastName);


    public Date getBirthday();


    public void setBirthday(Date birthday);


    public String getPhoneNumber();


    public void setPhoneNumber(String phoneNumber);


    public String getEmail();


    public void setEmail(String email);

    public String getAllInfo();
}
