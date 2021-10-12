package sb.com.project.BL;


import sb.com.project.BL.Users.IUser;
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
