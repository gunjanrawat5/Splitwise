package dev.gunjan.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupCreateRequestDTO {
    private String name;
    private int createdById;
    private List<Integer> userIds;
}
