package sb.com.project.BL;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Entity
public class Subject implements IEntity {

    @Id
    @GeneratedValue
    private int id;
    private String sbName;
    private int amountOfCredits;

    public Subject(){}

    public int getId() {
        return id;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public int getAmountOfCredits() {
        return amountOfCredits;
    }

    public void setAmountOfCredits(int amountOfCredits) {
        this.amountOfCredits = amountOfCredits;
    }

    public Subject(String name, int amountOfCredits){
        this.sbName = name;
        this.amountOfCredits = amountOfCredits;
    }
}
