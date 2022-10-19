package springboot.web.dto.preteam;

import lombok.Getter;
import springboot.domain.issue.MemberIssue;
import springboot.domain.member.Member;
import springboot.domain.team.PreTeam;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class PreTeamJoinMemberResponseDto {
    private Long id;

    private int team_name;
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
    private List<Member> member;

    public PreTeamJoinMemberResponseDto(PreTeam entity, List<Member> member){
        this.id = entity.getId();
        this.number_id = entity.getNumber_id();
        this.team_name = entity.getTeam_name();
        this.p_group = entity.getP_group();
        this.comment = entity.getComment();
        this.created_date = entity.getCreated_date();
        this.updated_date = entity.getUpdated_date();
        this.member = member;
    }
}
