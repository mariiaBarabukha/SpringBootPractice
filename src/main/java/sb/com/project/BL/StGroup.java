package sb.com.project.BL;
import org.springframework.stereotype.Component;
import sb.com.project.BL.Users.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Component
@Entity
public class StGroup implements IEntity {

    @Id
    @GeneratedValue
    private int id;
    private int amountOfStudents;
    private int yearOfStudying;
    private String faculty;
    private String name_group;

//    @OneToMany
//    private List<Student> students = new LinkedList<>();
//
//    public void addStudent(Student student){
//        students.add(student);
//    }
//

    public static int COUNTER = 1;


    public int getId() {
        return id;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public int getYearOfStudying() {
        return yearOfStudying;
    }

    public void setYearOfStudying(int yearOfStudying) {
        this.yearOfStudying = yearOfStudying;
        if(id == 0){
//            idGroup = COUNTER;
        }
        if(name_group == null){
            name_group = "faculty_"+yearOfStudying+"_"+COUNTER;
            COUNTER++;
        }else{
            String[] ns = name_group.split("_");
            ns[1] = yearOfStudying+"";
            name_group = String.join("_", ns[0], ns[1], ns[2]);
        }
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
        if(id == 0){
//            idGroup = COUNTER;
        }
        if(name_group == null){
            name_group = faculty+"_year"+COUNTER;
            COUNTER++;
        }else{
            String[] ns = name_group.split("_");
            ns[0] = faculty;
            name_group = String.join("_", ns[0], ns[1], ns[2]);
        }

    }

    public String getName_group(){
        return name_group;
    }

    public StGroup(int year, String faculty){
        yearOfStudying = year;
        this.faculty = faculty;
        amountOfStudents = 0;
//        idGroup = COUNTER;
        name_group = faculty+"_"+year+"_"+COUNTER;
        COUNTER++;

    }

    public StGroup(){

    }
}
