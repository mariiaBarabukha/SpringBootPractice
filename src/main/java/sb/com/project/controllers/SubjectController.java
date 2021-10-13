package sb.com.project.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import sb.com.project.BL.Subject;
import sb.com.project.services.SubjectService;

import java.util.List;

@RequestMapping("/subjects")
@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping
    List<Subject> getAllSubjects() {
        return subjectService.readSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable int id){
        return subjectService.getSubject(id);
    }

    @PostMapping
    String createSubject(@RequestBody Subject newSubject) {
        return subjectService.addSubject(newSubject);
    }

    @PatchMapping("/{id}")
    public String putSubject(@PathVariable int id , @RequestBody Subject subject){
        return subjectService.updateSubject(id , subject);
    }

    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable int id){
        return subjectService.deleteSubject(id);
    }

}
