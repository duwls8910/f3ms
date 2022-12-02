package springboot.web.dto.member;

import lombok.Builder;
import lombok.Getter;
import springboot.domain.member.Member;
import springboot.domain.number.Number;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
public class MemberJoinNumberResponseDto {
    private long id;

    private String member_name;

    private Boolean is_active;
    @Enumerated(EnumType.STRING)
    private Member.Position_cd position_cd;

    private Long main_team_id;

    private Long pre_team_id;

    private LocalDate created_date;

    private LocalDate updated_date;

    private Number number;



    public enum Position_cd{ //0은 be 1은 fe
        p_be, p_fe;
    }

    @Builder
    public MemberJoinNumberResponseDto(Member entity , Number number){
        this.id = entity.getId();
        this.member_name = entity.getMember_name();
        this.is_active = entity.getIs_active();
        this.position_cd = entity.getPosition_cd();
        this.main_team_id = entity.getMain_team_id();
        this.pre_team_id = entity.getPre_team_id();
        this.created_date = entity.getCreated_date();
        this.updated_date = entity.getUpdated_date();
        this.number = number;
    }
}
