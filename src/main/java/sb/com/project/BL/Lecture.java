package sb.com.project.BL;

import sb.com.project.BL.Users.Lecturer;
import org.springframework.stereotype.Component;

@Component
public class Lecture implements IEntity {

    private int idLecture;
    private Lecturer lecturer;
    private StGroup group;
    private Subject subject;
    private int audienceNum;
    private WeekDay weekDay;
    private int lectureNum;

    public Lecture(){}

    public Lecture(Lecturer lecturer, StGroup group, Subject subject,
                   int aNum, WeekDay weekDay, int lNum){
        this.lectureNum = lNum;
        this.lecturer = lecturer;
        this.group = group;
        this.subject = subject;
        audienceNum = aNum;
        this.weekDay = weekDay;
        idLecture = 1;
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

    public int getId(){
        return  idLecture;
    }
}
