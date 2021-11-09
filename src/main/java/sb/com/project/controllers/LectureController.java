package sb.com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sb.com.project.BL.Lecture;
import sb.com.project.BL.Users.Student;
import sb.com.project.exeptions.BadRequestException;
import sb.com.project.exeptions.ErrorResponse;
import sb.com.project.exeptions.ResourceNotFoundException;
import sb.com.project.repositories.*;
import sb.com.project.services.LectureService;
import sb.com.project.services.StudentService;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RequestMapping("/lectures")
@RestController
@Validated
public class LectureController {
    @Autowired
    ILectureRepository lectureRepository;

    @Autowired
    LectureService lectureService;

    @GetMapping
    List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Lecture getStudent(@PathVariable int id){
        return lectureRepository.findById(id)
                .stream().filter(elem -> elem.getId() == (id))
                .findFirst().get();
    }

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    IGroupRepository groupRepository;

    @Autowired
    ISubjectRepository subjectRepository;

    @Autowired
    ILecturerRepository lecturerRepository;
    @PostMapping("/{group_id}/{lecturer_id}/{subject_id}")
    Lecture createLecture(@Valid @RequestBody Lecture lecture,
                                  @PathVariable (value = "group_id") int group_id,
                                  @PathVariable (value = "lecturer_id") int lecturer_id,
                                  @PathVariable (value = "subject_id") int subject_id) {



        if(lecture.getWeekDay() == 6 || lecture.getWeekDay() == 7){
            throw new BadRequestException("You cannot set lectures on weekend!");
        }

        if (groupRepository.findById(group_id) == null){
            throw new ResourceNotFoundException("group with id "+ group_id+
                    " does not exist!");
        }
        if (subjectRepository.findById(subject_id) == null){
            throw new ResourceNotFoundException("subject with id "+ subject_id+
                    " does not exist!");
        }
        if (lecturerRepository.findById(lecturer_id) == null){
            throw new ResourceNotFoundException("lecturer with id "+ lecturer_id+
                    " does not exist!");
        }

//        if(lecture.getWeekDay() < 1 || lecture.getWeekDay() > 7){
//            throw new BadRequestException("weekday should be from 1 to 7");
//        }
        lecture.setGroup(groupRepository.findById(group_id).get(0));

        lecture.setLecturer( lecturerRepository.findById(lecturer_id).get(0));


        lecture.setSubject(subjectRepository.findById(subject_id).get(0));

        return lectureRepository.save(lecture);

    }

    @PatchMapping("/{id}")
    public String putStudent(@PathVariable int id ,
                             @RequestBody Lecture lecture){
        return lectureService.updateLecture(id , lecture);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        return lectureService.deleteLecture(id);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorResponse>
    handleUserNotFoundException(BadRequestException ex,  WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("ResourceNotFoundException", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
