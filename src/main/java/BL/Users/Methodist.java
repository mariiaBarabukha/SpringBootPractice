package BL.Users;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Qualifier("Methodist")
public class Methodist extends User implements IUser{
    public Methodist(String fn, String ln, Date bd, String phone, String email) {
        super(fn, ln, bd, phone, email);
    }


    @Override
    public String getAllInfo() {
        return firstName;
    }
}
