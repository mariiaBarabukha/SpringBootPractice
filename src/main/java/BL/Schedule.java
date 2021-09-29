package BL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Component
public class Schedule {

    public List<Lecture> lectures;
    public Schedule(){
        lectures = new ArrayList<>();
    }

    public boolean addLecture(Lecture entity){
        try {
            lectures.add(entity);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return false;

    }

    public String showAll(){
        String res = "";
        for (Lecture lec:
                lectures) {
            try {
                String text = String.format("%s | %s | %s | %d | %s | %d\n", lec.getLecturer().getFullName(),
                        lec.getGroup().getName(), lec.getSubject().getName(), lec.getAudienceNum(),
                        lec.getWeekDay().toString(), lec.getLectureNum());
                res += text;
            }catch (Exception e){
                res += (e.toString()+'\n');
            }
        }
        return res;
    }

}


