package springboot.domain.issue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class MemberIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name="member_id")
    @JsonIgnore
    private Member member;

    private Boolean is_completed = false;

    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date= LocalDate.now();

    @Builder
    public MemberIssue(String title, String content, Member member){
        this.title = title;
        this.content= content;
        this.member = member;
    }
    @Override
    public String toString(){
        return "Member Issue {"+
                "id : " + id +
                ", title : "+ title+ '\''+
                ", content : "+ content+
                ", member : "+ member+
                "}";
    }

    public void mappedMember(Member member){
        this.member= member;
    }
}
