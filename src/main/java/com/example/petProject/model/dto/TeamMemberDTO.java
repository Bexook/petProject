package com.example.petProject.model.dto;

import com.example.petProject.model.enumTypes.TeamMemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamMemberDTO {
    private Long id;
    private String username;
    private TeamMemberRole teamMemberRole;
    private Long userId;


    public TeamMemberDTO(Long id, String username, Integer teamMemberRole, Long userId) {
        this.id = id;
        this.username = username;
        this.teamMemberRole = TeamMemberRole.getByCode(teamMemberRole);
        this.userId = userId;
    }
}
