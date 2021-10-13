package sb.com.project.BL.Users;

import sb.com.project.BL.StGroup;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Component

public class Student extends User implements IUser{

    @Id
    @GeneratedValue
    private int id;
    private StGroup group;

    public Student(){}

    public Student(String fn, String ln, Date bd, String phone, String email, StGroup group){
        super(fn, ln, bd, phone, email);
        this.group = group;
    }

    @Override
    public String getAllInfo() {
        return group.getName_group();
    }
}
