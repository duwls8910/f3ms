package springboot.web.dto.preteam;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.team.PreTeam;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PreTeamSaveRequestDto {
    private Long id;

    private int team_name;
    private String number_name;

    private String comment;
    private long number_id;

    private Boolean is_opened;

    @Enumerated(EnumType.STRING)
    private PreTeam.P_group p_group ;

    public enum P_group{ //0은 Pre 1은 Main
        Pre, Main;
    }
    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date;


    @Builder
    public PreTeamSaveRequestDto(int team_name,String number_name,String comment,Boolean is_opened,PreTeam.P_group p_group){
        this.team_name = team_name;
        this.number_name = number_name;
        this.comment = comment;
        this.is_opened = is_opened;
        this.p_group= p_group;
    }
    public PreTeam toEntity(){ //domain.team의 Team.build 메서드와 연결되어있음
        return PreTeam.builder()
                .p_group(p_group)
                .number_id(number_id)
                .team_name(team_name)
                .comment(comment)
                .build();
    }

}
