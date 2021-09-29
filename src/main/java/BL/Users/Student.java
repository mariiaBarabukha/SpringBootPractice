package BL.Users;

import BL.Group;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Qualifier("Student")
public class Student extends User implements IUser{

    private Group group;

    public Student(String fn, String ln, Date bd, String phone, String email, Group group){
        super(fn, ln, bd, phone, email);
        this.group = group;
    }

    @Override
    public String getAllInfo() {
        return group.getName();
    }
}
