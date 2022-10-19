package springboot.web.dto.preteam;

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
    private int team_issue_id;

    private long number_id;

    private Boolean is_opened = true;

    @Enumerated(EnumType.STRING)
    private PreTeam.P_group p_group ;

    public enum P_group{ //0은 Pre 1은 Main
        Pre, Main;
    }
    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date;


    public PreTeam toEntity(){ //domain.team의 Team.build 메서드와 연결되어있음
        System.out.println("여기 TeamSaveRequestDto toEntity()!!!");

        return PreTeam.builder()
                .p_group(p_group)
                .number_name(number_name)
                .number_id(number_id)
                .team_name(team_name)
                .build();
    }

}
