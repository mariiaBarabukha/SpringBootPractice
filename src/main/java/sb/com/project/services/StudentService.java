package sb.com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.com.project.BL.StGroup;
import sb.com.project.BL.Users.Student;
import sb.com.project.repositories.IStudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepository studentRepository;

    @Transactional
    public String addStudent(Student student){
        try {
//            student.setGroup(new StGroup());
            System.out.println(student);
            studentRepository.save(student);
            return "Student added!";
        }catch (Exception e){
            return  "Something went wrong! Try again";
        }
    }

    public List<Student> readStudents(){
        return studentRepository.findAll();
    }

    @Transactional
    public String updateStudent(int id, Student student){
        try {
            List<Student> currentStudent = studentRepository.findById(id);
            if (currentStudent == null){
                throw new NullPointerException();
            }
            currentStudent.stream().forEach(currStudentObj -> {
                if(student.getFirstName() != null){
                    currStudentObj.setFirstName(student.getFirstName());
                }
                if(student.getLastName() != null){
                    currStudentObj.setLastName(student.getLastName());
                }
                if(student.getPhoneNumber() != null){
                    currStudentObj.setPhoneNumber(student.getPhoneNumber());
                }
                if(student.getEmail() != null){
                    currStudentObj.setEmail(student.getEmail());
                }
                if(student.getBirthday() != null){
                    currStudentObj.setBirthday(student.getBirthday());
                }
                studentRepository.save(currStudentObj);
            });
            return "Student updated";
        }catch (Exception e){
            return "Something went wrong! Try again";
        }
    }

    @Transactional
    public String deleteStudent(int id){

        try {
            List<Student> currentStudent = studentRepository.findById(id);
            if (currentStudent == null){
                throw new NullPointerException("student is null");
            }
            List<Student> students = studentRepository.findById(id);
            if (students == null){
                throw new NullPointerException();
            }
            students.stream().forEach(g -> {
                studentRepository.delete(g);
            });
            return "Student removed";
        }catch (Exception e){
            return e.toString();
        }
    }

    public Student getStudent(Integer id) {
        List<Student> students = studentRepository.findAll();
        return students.stream().filter(elem -> elem.getId() == (id)).findFirst().get();
    }
}
