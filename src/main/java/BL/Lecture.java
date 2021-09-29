package BL;

import BL.Users.Lecturer;
import BL.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Qualifier("Lecture")
public class Lecture implements IEntity {
    private UUID idLecture;
    private Lecturer lecturer;
    private Group group;
    private Subject subject;
    private int audienceNum;
    private WeekDay weekDay;
    private int lectureNum;
    
    public Lecture(Lecturer lecturer, Group group, Subject subject,
                   int aNum, WeekDay weekDay, int lNum){
        this.lectureNum = lNum;
        this.lecturer = lecturer;
        this.group = group;
        this.subject = subject;
        audienceNum = aNum;
        this.weekDay = weekDay;
        idLecture = UUID.randomUUID();
        System.out.println(lecturer.getClass());
    }


    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
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

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getLectureNum() {
        return lectureNum;
    }

    public void setLectureNum(int lectureNum) {
        this.lectureNum = lectureNum;
    }

    public UUID getId(){
        return  idLecture;
    }
}
