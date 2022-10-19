package springboot.web.dto.member;

import lombok.Builder;
import lombok.Getter;
import springboot.domain.issue.MemberIssue;
import springboot.domain.member.Member;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
public class MemberResponseDto  {
    private long id;

    private String member_name;

    private Boolean is_active;
    @Enumerated(EnumType.STRING)
    private Member.Position_cd position_cd;

    private Long number_id;

    private Long main_team_id;

    private Long pre_team_id;

    private LocalDate created_date;

    private LocalDate updated_date;

    @OneToMany(mappedBy = "member")//참조하는 필드
    private Set<MemberIssue> memberIssue = new HashSet<MemberIssue>();

    public enum Position_cd{ //0은 be 1은 fe
        p_be, p_fe;
    }

    @Builder
    public MemberResponseDto(Member entity){
        this.id = entity.getId();
        this.member_name = entity.getMember_name();
        //if(memberIssue != null) this.memberIssue = entity.getMemberIssue();
        this.is_active = entity.getIs_active();
        this.position_cd = entity.getPosition_cd();
        this.number_id = entity.getNumber_id();
        this.main_team_id = entity.getMain_team_id();
        this.pre_team_id = entity.getPre_team_id();
        this.created_date = entity.getCreated_date();
        this.updated_date = entity.getUpdated_date();
    }
}
