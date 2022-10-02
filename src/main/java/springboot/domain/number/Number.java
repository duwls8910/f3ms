package springboot.domain.number;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.domain.team.Team;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private int number_id; //기수

    private LocalDate start_date; //기수 프로젝트 시작일

    private LocalDate end_date; //기수 프로젝트 종료일

    @Column(length = 500)
    private String comment; //기수 특이사항

    private Boolean is_closed = false; //기수 종료여부 진행시 = true

    private LocalDate created_date = LocalDate.now();

    private LocalDate updated_date;

//    @JsonIgnore
//    @OneToMany(mappedBy = "number")
//    private List<Team> team = new ArrayList<>();

    @Builder
    public Number(int number_id, LocalDate start_date, LocalDate end_date, String comment){
        this.number_id = number_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.comment = comment;

    }

    public void update (LocalDate start_date, LocalDate end_date, String comment, Boolean is_closed) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.comment = comment;
        this.is_closed = is_closed;
        this.updated_date = LocalDate.now();
    }

}
