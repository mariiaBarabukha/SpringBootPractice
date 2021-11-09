package sb.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.com.project.BL.Lecture;

import java.util.List;

@Repository
public interface ILectureRepository extends JpaRepository<Lecture, Integer> {
    public List<Lecture> findById(int id);
}
