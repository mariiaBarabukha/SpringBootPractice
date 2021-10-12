package sb.com.project.repositories;

import sb.com.project.BL.StGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IGroupRepository extends JpaRepository<StGroup, Integer> {
   public List<StGroup> findById(int id);
}
