package springboot.domain.team;

import lombok.*;
import springboot.domain.number.Number;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
public class PreTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int team_name;

    @NonNull
    private Long number_id;


    private Boolean is_opened = true;

    private String comment;

    @Enumerated(EnumType.STRING)
    private P_group p_group ;

    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date= LocalDate.now();


    public enum P_group{ //0은 Pre 1은 Main
        Pre, Main;
    }


    @Builder //save 할때 필요
    public PreTeam(int team_name, P_group p_group, long number_id,String comment){
        this.team_name = team_name;
        this.p_group = p_group;
        this.number_id = number_id;
        this.comment = comment;
    }

    public void update (int team_name, Long number_id, Boolean is_opened,String comment){
        this.team_name = team_name;
        this.number_id = number_id;
        this.is_opened= is_opened;
        this.updated_date = LocalDate.now();
        this.comment = comment;
    }
    public void openedUpdate(Boolean is_opened){
        this.is_opened = is_opened;
    }
}
