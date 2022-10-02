package springboot.web.dto.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.number.Number;
import springboot.domain.team.Team;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
public class TeamSaveRequestDto {
    //Team team = new Team();
    private int team_name;

    private int number_id;
    @Enumerated(EnumType.STRING)
    private Team.P_group p_group ;

    public Team toEntity(){ //domain.team의 Team.build 메서드와 연결되어있음
        System.out.println("여기 TeamSaveRequestDto toEntity()!!!");

        return Team.builder()
                .p_group(p_group)
                .team_name(team_name)
                .number_id(number_id)
                .build();
    }

}
