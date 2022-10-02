package springboot.web.dto.team;

import lombok.Getter;
import springboot.domain.team.Team;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
public class TeamResponseDto {

    private Long id;

    private int team_name;

    private int team_issue_id;

    private int number_id;

    private Boolean is_opened = true;

    @Enumerated(EnumType.STRING)
    private Team.P_group p_group ;

    public enum P_group{ //0은 Pre 1은 Main
        Pre, Main;
    }
    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date;

    public TeamResponseDto(Team entity){
        this.id = entity.getId();
        this.number_id = entity.getNumber_id(); //수정
        this.team_name = entity.getTeam_name();
        this.team_issue_id = entity.getTeam_issue_id();
        this.p_group = entity.getP_group();
        this.created_date = entity.getCreated_date();
        this.updated_date = entity.getUpdated_date();
    }
}
