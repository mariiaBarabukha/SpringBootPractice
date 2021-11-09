package sb.com.project.BL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import sb.com.project.BL.Users.Lecturer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Lecture implements IEntity {

    @Id
    @GeneratedValue
    private int id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Lecturer lecturer;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private StGroup group;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Subject subject;
    private int audienceNum;

    @Min(value = 1)
    @Max(value = 7)
    private Integer weekDay;
    private int lectureNum;


    public Lecture(){}

    public Lecture(Lecturer lecturer, StGroup group, Subject subject,
                   int aNum, int weekDay, int lNum){
        this.lectureNum = lNum;
        this.lecturer = lecturer;
        this.group = group;
        this.subject = subject;
        audienceNum = aNum;
        this.weekDay = weekDay;
        //idLecture = 1;
        System.out.println(lecturer.getClass());
    }


    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public StGroup getGroup() {
        return group;
    }

    public void setGroup(StGroup group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getAudienceNum() {
        return audienceNum;
    }

    public void setAudienceNum(int audienceNum) {
        this.audienceNum = audienceNum;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getLectureNum() {
        return lectureNum;
    }

    public void setLectureNum(int lectureNum) {
        this.lectureNum = lectureNum;
    }

    public int getId(){
        return  id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
