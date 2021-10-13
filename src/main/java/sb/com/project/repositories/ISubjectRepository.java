package sb.com.project.repositories;

import sb.com.project.BL.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
    public List<Subject> findById(int id);
}
