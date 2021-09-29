package BL.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Qualifier("Lecturer")
public class Lecturer extends User implements IUser{
    public Lecturer(String fn, String ln, Date bd, String phone, String email){
        super(fn, ln, bd, phone, email);
    }

    @Override
    public String getAllInfo() {
        return String.format("%s %s %s", firstName, lastName, email);
    }
}
