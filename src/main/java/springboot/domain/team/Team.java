package springboot.domain.team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.domain.number.Number;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int team_name;
    private int number_id;

    private int team_issue_id;

    private Boolean is_opened = true;

    @Enumerated(EnumType.STRING)
    private P_group p_group ;

    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date= LocalDate.now();
    //@ManyToOne(targetEntity = Number.class,fetch = LAZY)
    //@JoinColumn(name="n_id")

    public enum P_group{ //0은 Pre 1은 Main
        Pre, Main;
    }


    @Builder
    public Team(int team_name,P_group p_group, int number_id){
        this.team_name = team_name;
        this.p_group = p_group;
        this.number_id = number_id;

    }
}
