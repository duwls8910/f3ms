package springboot.domain.team;

import lombok.*;
import springboot.domain.number.Number;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PreTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int team_name;

    @NonNull
    private Long number_id;

    private String number_name;

    private int team_issue_id;

    private Boolean is_opened = true;

    @Enumerated(EnumType.STRING)
    private P_group p_group ;

    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date= LocalDate.now();


    public enum P_group{ //0은 Pre 1은 Main
        Pre, Main;
    }


    @Builder
    public PreTeam(int team_name, P_group p_group, Long number_id,String number_name){
        this.team_name = team_name;
        this.p_group = p_group;
        this.number_id = number_id;
        this.number_name = number_name;

    }
}
