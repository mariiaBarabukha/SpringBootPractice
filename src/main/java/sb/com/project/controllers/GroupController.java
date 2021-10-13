package sb.com.project.controllers;

import org.springframework.web.bind.annotation.*;
import sb.com.project.BL.StGroup;
import org.springframework.beans.factory.annotation.Autowired;
import sb.com.project.services.GroupService;

import javax.swing.*;
import java.util.List;

@RestController
public class GroupController {
    @Autowired
    GroupService groupService;

//    @RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
//    public List<StGroup> getAllGroups(){
//        return  groupService.readGroups();
//    }

    @GetMapping("/groups")
    List<StGroup> all() {
        return groupService.readGroups();
    }

    @RequestMapping(value = "createGroup", method = RequestMethod.POST)
    public String createGroup(@RequestBody StGroup group){
        return groupService.addGroup(group);
    }
    @RequestMapping(value = "updateGroup", method = RequestMethod.PUT)
    public String updateGroup(@RequestBody StGroup group){

        return groupService.updateGroup(group);
    }

    @RequestMapping(value = "deleteGroup/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody StGroup group){

        return groupService.deleteGroup(group);
    }

}
