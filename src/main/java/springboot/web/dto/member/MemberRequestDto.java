package springboot.web.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.issue.MemberIssue;
import springboot.domain.member.Member;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//요청들어온것을 받아 엔티티로 넘겨주는곳
@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String member_name;

    private Set<MemberIssue> memberIssue = new HashSet<MemberIssue>();

    private Boolean is_active = true;

    private Member.Position_cd position_cd;

    private Long number_id;

    private Long main_team_id;

    private Long pre_team_id;

    private LocalDate updated_date= LocalDate.now();

    @Builder
    public MemberRequestDto(String member_name, Set<MemberIssue> memberIssue, Boolean is_active, Member.Position_cd position_cd, Long number_id, Long main_team_id, Long pre_team_id, LocalDate updated_date){
        this.member_name = member_name;
        if(memberIssue != null) this.memberIssue = memberIssue;
        this.is_active = is_active;
        this.position_cd = position_cd;
        this.number_id = number_id;
        this.main_team_id= main_team_id;
        this.pre_team_id = pre_team_id;
        this.updated_date = updated_date;
//여기서 들어온값으로 필드를 바꾸고 toEntity 메서드로 엔티티에 빌드(생성자에 파라미터값 넣기)
    }

    public Member toEntity(){
        return Member.builder()
                .member_name(member_name)
                .memberIssue(memberIssue)
                .is_active(is_active)
                .position_cd(position_cd)
                .number_id(number_id)
                .main_team_id(main_team_id)
                .pre_team_id(pre_team_id)
                .updated_date(updated_date)
                .build();
    }
}
