package sb.com.project.controllers;

import org.springframework.web.bind.annotation.*;
import sb.com.project.BL.StGroup;
import org.springframework.beans.factory.annotation.Autowired;
import sb.com.project.services.GroupService;

import java.util.List;

@RequestMapping("/groups")
@RestController
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping
    List<StGroup> getAllGroups() {
        return groupService.readGroups();
    }

    @GetMapping("/{id}")
    public StGroup getGroup(@PathVariable int id){
        return groupService.getGroup(id);
    }

    @PostMapping
    String createGroup(@RequestBody StGroup newGroup) {
        return groupService.addGroup(newGroup);
    }

    @PatchMapping("/{id}")
    public String putGroup(@PathVariable int id , @RequestBody StGroup group){
        return groupService.updateGroup(id , group);
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable int id){
        return groupService.deleteGroup(id);
    }

}
