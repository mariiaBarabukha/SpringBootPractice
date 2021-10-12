package sb.com.project.BL;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Component
public class Subject implements IEntity {

    private int idSub;
    private String name;
    private int amountOfCredits;

    public Subject(){}

    public int getId() {
        return idSub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfCredits() {
        return amountOfCredits;
    }

    public void setAmountOfCredits(int amountOfCredits) {
        this.amountOfCredits = amountOfCredits;
    }

    public Subject(String name, int amountOfCredits){
        this.name = name;
        this.amountOfCredits = amountOfCredits;
        idSub = 2222;
    }
}
