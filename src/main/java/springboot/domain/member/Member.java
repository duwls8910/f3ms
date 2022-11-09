package springboot.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import springboot.domain.issue.MemberIssue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String member_name;

    private Boolean is_active = true;

    private Position_cd position_cd;
    @NonNull
    private Long number_id;

    private Long main_team_id;

    private Long pre_team_id;

    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date= LocalDate.now();


    public enum Position_cd{ //0은 be 1은 fe
        p_be, p_fe;
    }

    @Builder
    public Member(String member_name, Boolean is_active, Position_cd position_cd, Long number_id, Long main_team_id, Long pre_team_id, LocalDate updated_date){
        this.member_name=member_name;
        this.is_active = is_active;
        this.position_cd = position_cd;
        this.number_id = number_id;
        this.main_team_id= main_team_id;
        this.pre_team_id = pre_team_id;
        this.updated_date = updated_date;
    }

    public void update(String member_name,Boolean is_active,Position_cd position_cd,Long main_team_id,Long pre_team_id){
        this.member_name = member_name;
        this.is_active = is_active;
        this.position_cd = position_cd;
        this.main_team_id = main_team_id;
        this.pre_team_id = pre_team_id;
        this.updated_date = LocalDate.now();
    }

//    public void mappedMemberIssue(MemberIssue memberIssue){
//        this.memberIssue.add(memberIssue);
//    }
    //이게 여기있으면 안될거 같은데..
}
