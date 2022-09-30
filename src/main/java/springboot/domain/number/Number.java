package springboot.domain.number;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int number_id; //기수

    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date; //기수 프로젝트 시작일

    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date; //기수 프로젝트 종료일

    @Column(length = 500)
    private String comment; //기수 특이사항

    private Boolean is_closed; //기수 종료여부 진행시 = true

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_date = LocalDateTime.now();

   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updated_date;

    @Builder
    public Number(int number_id, Date start_date, Date end_date, String comment, Boolean is_closed){
        this.number_id = number_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.comment = comment;
        this.is_closed = is_closed;
    }

    public void update (Date start_date, Date end_date, String comment, Boolean is_closed) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.comment = comment;
        this.is_closed = is_closed;
        this.updated_date = LocalDateTime.now();
    }
}
