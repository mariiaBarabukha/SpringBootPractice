package sb.com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.com.project.BL.Lecture;
import sb.com.project.BL.Users.Lecturer;
import sb.com.project.repositories.ILecturerRepository;

import java.util.List;

@Service
public class LecturerService {
    @Autowired
    ILecturerRepository lecturerRepository;

    @Transactional
    public String updateLecturer(int id, Lecturer lecturer){
        try {
            List<Lecturer> currentStudent = lecturerRepository.findById(id);
            if (currentStudent == null){
                throw new NullPointerException();
            }
            currentStudent.stream().forEach(currStudentObj -> {
                if(lecturer.getFirstName() != null){
                    currStudentObj.setFirstName(lecturer.getFirstName());
                }
                if(lecturer.getLastName() != null){
                    currStudentObj.setLastName(lecturer.getLastName());
                }
                if(lecturer.getPhoneNumber() != null){
                    currStudentObj.setPhoneNumber(lecturer.getPhoneNumber());
                }
                if(lecturer.getEmail() != null){
                    currStudentObj.setEmail(lecturer.getEmail());
                }
                if(lecturer.getBirthday() != null){
                    currStudentObj.setBirthday(lecturer.getBirthday());
                }
                lecturerRepository.save(currStudentObj);
            });
            return "Student updated";
        }catch (Exception e){
            return "Something went wrong! Try again";
        }
    }

    @Transactional
    public String deleteLecturer(int id){

        try {

            List<Lecturer> lecturers = lecturerRepository.findById(id);
            if (lecturers == null){
                throw new NullPointerException();
            }
            lecturers.stream().forEach(g -> {
                lecturerRepository.delete(g);
            });
            return "Student removed";
        }catch (Exception e){
            return e.toString();
        }
    }

    public Lecturer getStudent(Integer id) {
        List<Lecturer> students = lecturerRepository.findAll();
        return students.stream().filter(elem -> elem.getId() == (id)).findFirst().get();
    }
}
