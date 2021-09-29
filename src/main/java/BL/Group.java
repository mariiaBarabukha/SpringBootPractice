package BL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Qualifier("Group")
public class Group implements IEntity {
    private UUID idGroup;
    private int amountOfStudents;
    private int yearOfStudying;
    private String faculty;
    private String name;

    public static int COUNTER = 0;


    public UUID getId() {
        return idGroup;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public int getYearOfStudying() {
        return yearOfStudying;
    }

    public void setYearOfStudying(int yearOfStudying) {
        this.yearOfStudying = yearOfStudying;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getName(){
        return name;
    }

    public Group(int year, String faculty){
        yearOfStudying = year;
        this.faculty = faculty;
        amountOfStudents = 0;
        idGroup = UUID.randomUUID();
        COUNTER++;
        name = faculty+"_"+year+"_"+COUNTER;
    }
}
