package sb.com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sb.com.project.BL.Users.Lecturer;
import sb.com.project.repositories.ILecturerRepository;
import sb.com.project.services.LecturerService;


import javax.validation.Valid;
import java.util.List;


//@Validated
@RequestMapping("/lecturers")
@RestController
public class LecturerController {
    @Autowired
    LecturerService lecturerService;

    @Autowired
    ILecturerRepository lecturerRepository;
    @GetMapping
    List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Lecturer getLecturer(@PathVariable int id){
        return lecturerService.getStudent(id);
    }

    @PostMapping()
    Lecturer createLecturer(@Valid @RequestBody Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @PatchMapping("/{id}")
    public String putLecturer(@PathVariable int id ,
                              @RequestBody Lecturer lecturer){
        return lecturerService.updateLecturer(id , lecturer);
    }

    @DeleteMapping("/{id}")
    public String deleteLecturer(@PathVariable int id){
        return lecturerService.deleteLecturer(id);
    }

}
