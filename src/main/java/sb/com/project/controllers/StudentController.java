package sb.com.project.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import sb.com.project.BL.Users.Student;
import sb.com.project.services.StudentService;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    List<Student> getAllStudents() {
        return studentService.readStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @PostMapping
    String createStudent(@RequestBody Student newStudent) {
        return studentService.addStudent(newStudent);
    }

    @PatchMapping("/{id}")
    public String putStudent(@PathVariable int id , @RequestBody Student student){
        return studentService.updateStudent(id , student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

}
