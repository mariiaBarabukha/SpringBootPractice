package sb.com.project.BL.Users;

import org.springframework.beans.factory.annotation.Autowired;

public class Account {

    IUser user;

    @Autowired
    public  Account(IUser user){
        this.user = user;
    }

    public IUser getUser() {
        return user;
    }
}
