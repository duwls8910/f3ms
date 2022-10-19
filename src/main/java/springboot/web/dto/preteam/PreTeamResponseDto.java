package springboot.web.dto.preteam;

import lombok.Getter;
import springboot.domain.member.Member;
import springboot.domain.number.Number;
import springboot.domain.team.PreTeam;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
public class PreTeamResponseDto {

    private Long id;

    private int team_name;
    private String number_name;

    private String comment;
    private long number_id;

    private Boolean is_opened = true;

    @Enumerated(EnumType.STRING)
    private PreTeam.P_group p_group ;

    public enum P_group{ //0은 Pre 1은 Main
        Pre, Main;
    }
    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date= LocalDate.now();


    public PreTeamResponseDto(PreTeam entity ){
        this.id = entity.getId();
        this.number_id = entity.getNumber_id();
        this.team_name = entity.getTeam_name();
        this.p_group = entity.getP_group();
        this.comment = entity.getComment();
        this.created_date = entity.getCreated_date();
        this.updated_date = entity.getUpdated_date();




    }
}
