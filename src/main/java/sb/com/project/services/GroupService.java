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
//
//    public GroupService(){
//        groupRepository = new Gro
//    }


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
    public String updateGroup(StGroup group){
        try {
            List<StGroup> groups = groupRepository.findById(group.getId());
            if (groups == null){
                throw new NullPointerException();
            }
            groups.stream().forEach(g -> {
                g.setFaculty(group.getFaculty());
                g.setYearOfStudying(group.getYearOfStudying());
                groupRepository.save(g);
            });
            return "Group updated";
        }catch (Exception e){
            return "Something went wrong! Try again";
        }
    }

    @Transactional
    public String deleteGroup(StGroup group){

        try {
            System.out.println(group.getId());
            if (group == null){
                throw new NullPointerException("group is null");
            }
            List<StGroup> groups = groupRepository.findById(group.getId());
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
}
