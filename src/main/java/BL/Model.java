package BL;


import BL.Users.IUser;
import BL.Users.User;
import org.springframework.beans.factory.annotation.Autowired;

public class Model {
    private Model(){};

    private static Model model;
    public static Model getModel(){
        if (model == null)
        {
            model = new Model();

        }
        return model;
    }

    @Autowired
    public IUser currentUser;

}
