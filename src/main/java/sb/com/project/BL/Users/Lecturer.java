package sb.com.project.BL.Users;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Lecturer extends User implements IUser{
    public Lecturer(String fn, String ln, Date bd, String phone, String email){
        super(fn, ln, bd, phone, email);
    }

    public Lecturer(){}

    @Override
    public String getAllInfo() {
        return String.format("%s %s %s", firstName, lastName, email);
    }
}
