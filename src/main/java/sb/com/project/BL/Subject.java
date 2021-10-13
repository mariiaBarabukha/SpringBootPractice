package sb.com.project.BL;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Component
@Entity
public class Subject implements IEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int amountOfCredits;

    public Subject(){}

    public int getId() {
        return id;
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
    }
}
