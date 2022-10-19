package springboot.web.dto.number;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.number.Number;

import java.time.LocalDate;
import java.util.Date;
@Getter
@NoArgsConstructor//파라미터가 없는 생성자 자동 생성
public class NumberRequestDto {
    //생성을 처리할 요청(Request) DTO 클래스
    //RequestDto로 전달받은 데이터(파라미터)를 기준으로 Entity 객체를 생성
    private int number_name;

    private LocalDate start_date; //기수 프로젝트 시작일

    private LocalDate end_date; //기수 프로젝트 종료일

    private String comment; //기수 특이사항

    private Boolean is_closed; //기수 종료여부 진행시 = true



    @Builder
    public NumberRequestDto( int number_name, LocalDate start_date, LocalDate end_date, String comment){
        this.number_name = number_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.comment = comment;
    }

    public Number toEntity(){
        return Number.builder()
                .number_name(number_name)
                .start_date(start_date)
                .end_date(end_date)
                .comment(comment)
                .build();
    }
}
