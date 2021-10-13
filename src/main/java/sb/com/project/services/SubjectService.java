package sb.com.project.services;

import sb.com.project.BL.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.com.project.repositories.ISubjectRepository;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    ISubjectRepository subjectRepository;

    @Transactional
    public String addSubject(Subject subject){
        try {
            subjectRepository.save(subject);
            return "Subject added!";
        }catch (Exception e){
            return  "Something went wrong! Try again";
        }
    }

    public List<Subject> readSubjects(){
        return  subjectRepository.findAll();
    }

    @Transactional
    public String updateSubject(int id, Subject subject){
        try {
            List<Subject> currentSubject = subjectRepository.findById(id);
            if (currentSubject == null){
                throw new NullPointerException();
            }
            currentSubject.stream().forEach(currSubjectObj -> {
                if(subject.getName() != null){
                    currSubjectObj.setName(subject.getName());
                }
                if(subject.getAmountOfCredits() != 0){
                    currSubjectObj.setAmountOfCredits(subject.getAmountOfCredits());
                }
                subjectRepository.save(currSubjectObj);
            });
            return "Subject updated";
        }catch (Exception e){
            return "Something went wrong! Try again";
        }
    }

    @Transactional
    public String deleteSubject(int id){

        try {
            List<Subject> currentSubject = subjectRepository.findById(id);
            if (currentSubject == null){
                throw new NullPointerException("subject is null");
            }
            List<Subject> subjects = subjectRepository.findById(id);
            if (subjects == null){
                throw new NullPointerException();
            }
            subjects.stream().forEach(g -> {
                subjectRepository.delete(g);
            });
            return "Subject removed";
        }catch (Exception e){
            return e.toString();
        }
    }

    public Subject getSubject(Integer id) {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().filter(elem -> elem.getId() == (id)).findFirst().get();
    }
}
