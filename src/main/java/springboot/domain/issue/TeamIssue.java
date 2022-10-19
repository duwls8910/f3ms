package springboot.domain.issue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class TeamIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    private Member member;

    private Boolean is_completed = false;

    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date= LocalDate.now();
}
