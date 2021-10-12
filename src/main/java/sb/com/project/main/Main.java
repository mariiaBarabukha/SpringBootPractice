package sb.com.project.main;

import sb.com.project.BL.Managers.GroupManager;
import sb.com.project.BL.Managers.LecturersManager;
import sb.com.project.BL.Managers.SubjectsManager;
import sb.com.project.BL.Users.Account;
import sb.com.project.BL.Users.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sb.com.project.BL.StGroup;
import sb.com.project.BL.Subject;

import java.util.Date;


@RestController
@EnableAutoConfiguration
@ComponentScan
public class Main {

    static GroupManager groupManager;
    static LecturersManager lecturersManager;
    static SubjectsManager subjectsManager;
    static Account account;
    public static void main(String[] args) {
//        SpringApplication.run(Main.class, args);
//        groupManager = new GroupManager();
//        lecturersManager = new LecturersManager();
//        subjectsManager = new SubjectsManager();
//
//        subjectsManager.add(new Subject("s0", 3));
//        subjectsManager.add(new Subject("s1", 3));
//        subjectsManager.add(new Subject("s2", 3));
//
//        groupManager.add(new StGroup(1, "FI"));
//        groupManager.add(new StGroup(1, "FGN"));

        account = new Account(new Student("a", "b",
                new Date(1999, 8,9),
                "3809999999", "w@w.w", (StGroup)groupManager.groupList.get(0)));


//        lecturersManager.add(new Lecturer("a", "b", new Date(1990, 1,1),
//                "111111", "a@a.a"));
    }

    @RequestMapping("/")
    String home() {
      // Schedule schedule = new Schedule();

//       Lecture l = new Lecture(lecturersManager.find(0), groupManager.find(1),
//               subjectsManager.find(1),
//               100, WeekDay.Friday, 1);
//       Model m = Model.getModel();
//       schedule.addLecture(new Lecture(lecturersManager.get(0), m.groupList.get(1), m.subjectList.get(1),
//               100, WeekDay.Friday, 1));
       return account.getUser().getAllInfo();
    }


}