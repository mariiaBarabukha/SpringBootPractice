package sb.com.project.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.WebRequest;
import sb.com.project.BL.StGroup;
import sb.com.project.BL.Users.Student;
import sb.com.project.exeptions.ErrorResponse;
import sb.com.project.exeptions.ResourceNotFoundException;
import sb.com.project.repositories.IGroupRepository;
import sb.com.project.repositories.IStudentRepository;
import sb.com.project.services.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    IGroupRepository groupRepository;
    @PostMapping("/{group_id}")
    Stream<Student> createStudent(@RequestBody Student newStudent,
                                  @PathVariable int group_id) {

        if(groupRepository.findById(group_id) == null){
            throw new ResourceNotFoundException("no group with such index");
        }
         return groupRepository.findById(group_id).stream().map(g -> {

            newStudent.setGroup(g);
            g.increaseAmountOfStudents();
            return studentRepository.save(newStudent);
        });
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ErrorResponse>
      handleUserNotFoundException(ResourceNotFoundException ex,  WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("ResourceNotFoundException", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public String putStudent(@PathVariable int id , @RequestBody Student student){
        return studentService.updateStudent(id , student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        getStudent(id).getGroup().decreaseAmountOfStudents();
        return studentService.deleteStudent(id);
    }



}
