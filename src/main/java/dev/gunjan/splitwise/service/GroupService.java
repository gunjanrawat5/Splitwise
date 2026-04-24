package dev.gunjan.splitwise.service;

import dev.gunjan.splitwise.dto.GroupCreateRequestDTO;
import dev.gunjan.splitwise.exception.GroupNotFoundException;
import dev.gunjan.splitwise.model.Group;
import dev.gunjan.splitwise.model.User;
import dev.gunjan.splitwise.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserService userService;

    public Group createGroup(GroupCreateRequestDTO groupCreateRequestDTO){
        Group group = new Group();
        group.setName(groupCreateRequestDTO.getName());
        group.setTotalAmountSpend(0);
        group.setAllSettlementDone(false);
        group.setCreatedBy(userService.findById(groupCreateRequestDTO.getCreatedById()));
        List<User> members = new ArrayList<>();
        for(Integer id: groupCreateRequestDTO.getUserIds()){
            members.add(userService.findById(id));
        }
        group.setMembers(members);

        return groupRepository.save(group);

    }

    public Group getGroupById(Integer id) {
        return groupRepository.findById(id).orElseThrow(
                ()-> new GroupNotFoundException("Group with given id not found")
        );
    }

}
