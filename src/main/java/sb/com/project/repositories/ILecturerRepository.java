package sb.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.com.project.BL.Lecture;
import sb.com.project.BL.Users.Lecturer;

import java.util.List;

@Repository
public interface ILecturerRepository extends JpaRepository<Lecturer, Integer> {
    public List<Lecturer> findById(int id);
}
