package dev.gunjan.splitwise.controller;


import dev.gunjan.splitwise.dto.GroupCreateRequestDTO;
import dev.gunjan.splitwise.model.Group;
import dev.gunjan.splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    public ResponseEntity<Group> createGroup(@RequestBody GroupCreateRequestDTO groupCreateRequestDTO){
        return ResponseEntity.ok(groupService.createGroup(groupCreateRequestDTO));

    }

    @GetMapping("/group/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") int id){
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

}
