package BL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Qualifier("Subject")
public class Subject implements IEntity {
    private UUID idSub;
    private String name;
    private int amountOfCredits;

    public UUID getId() {
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
        idSub = UUID.randomUUID();
    }
}
