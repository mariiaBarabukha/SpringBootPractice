package sb.com.project.services;

import sb.com.project.BL.StGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.com.project.repositories.IGroupRepository;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    IGroupRepository groupRepository;

    @Transactional
    public String addGroup(StGroup group){
        try {
            groupRepository.save(group);
            return "Group added!";
        }catch (Exception e){
            return  "Something went wrong! Try again";
        }
    }

    public List<StGroup> readGroups(){
        return  groupRepository.findAll();
    }

    @Transactional
    public String updateGroup(int id, StGroup group){
        try {
            List<StGroup> currentGroup = groupRepository.findById(id);
            if (currentGroup == null){
                throw new NullPointerException();
            }
            currentGroup.stream().forEach(currGroupObj -> {
                if(group.getFaculty() != null){
                    currGroupObj.setFaculty(group.getFaculty());
                }
                if(group.getYearOfStudying() != 0){
                    currGroupObj.setYearOfStudying(group.getYearOfStudying());
                }
                groupRepository.save(currGroupObj);
            });
            return "Group updated";
        }catch (Exception e){
            return "Something went wrong! Try again";
        }
    }

    @Transactional
    public String deleteGroup(int id){

        try {
            List<StGroup> currentGroup = groupRepository.findById(id);
            if (currentGroup == null){
                throw new NullPointerException("group is null");
            }
            List<StGroup> groups = groupRepository.findById(id);
            if (groups == null){
                throw new NullPointerException();
            }
            groups.stream().forEach(g -> {
                groupRepository.delete(g);
            });
            return "Group removed";
        }catch (Exception e){
            return e.toString();
        }
    }

    public StGroup getGroup(Integer id) {
        List<StGroup> groups = groupRepository.findAll();
        return groups.stream().filter(elem -> elem.getId() == (id)).findFirst().get();
    }
}
