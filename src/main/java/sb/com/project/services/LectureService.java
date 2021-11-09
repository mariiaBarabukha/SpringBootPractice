package sb.com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.com.project.BL.Lecture;
import sb.com.project.repositories.ILectureRepository;

import java.util.List;

@Service
public class LectureService {
    @Autowired
    ILectureRepository lectureRepository;

    @Transactional
    public String updateLecture(int id, Lecture lecture){
        try {
            List<Lecture> lectures = lectureRepository.findById(id);
            if (lectures == null){
                throw new NullPointerException();
            }
            lectures.stream().forEach(currStudentObj -> {
                if(lecture.getAudienceNum() != 0){
                    currStudentObj.setAudienceNum(lecture.getAudienceNum());
                }
                if(lecture.getGroup() != null){
                    currStudentObj.setGroup(lecture.getGroup());
                }
                if(lecture.getLectureNum() != 0){
                    currStudentObj.setLectureNum(lecture.getLectureNum());
                }
                if(lecture.getLecturer() != null){
                    currStudentObj.setLecturer(lecture.getLecturer());
                }
                if(lecture.getSubject() != null){
                    currStudentObj.setSubject(lecture.getSubject());
                }
                if(lecture.getWeekDay() != 0){
                    currStudentObj.setWeekDay(lecture.getWeekDay());
                }

                lectureRepository.save(currStudentObj);
            });
            return "Lecture updated";
        }catch (Exception e){
            return "Something went wrong! Try again";
        }
    }

    @Transactional
    public String deleteLecture(int id){

        try {
            List<Lecture> lectures = lectureRepository.findById(id);

           // List<Lecture> students = lectureRepository.findById(id);
            if (lectures == null){
                throw new NullPointerException();
            }
            lectures.stream().forEach(g -> {
                lectureRepository.delete(g);
            });
            return "Lecture removed";
        }catch (Exception e){
            return e.toString();
        }
    }
}
