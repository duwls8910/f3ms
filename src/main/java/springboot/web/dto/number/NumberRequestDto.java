package springboot.web.dto.number;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.number.Number;

import java.util.Date;
@Getter
@NoArgsConstructor
public class NumberRequestDto {
    //생성을 처리할 요청(Request) DTO 클래스
    //RequestDto로 전달받은 데이터(파라미터)를 기준으로 Entity 객체를 생성

    private int number_id;

    private Date start_date; //기수 프로젝트 시작일

    private Date end_date; //기수 프로젝트 종료일

    private String comment; //기수 특이사항

    private Boolean is_closed; //기수 종료여부 진행시 = true



//    @Builder
//    public NumberSaveRequestDto(int number_id, Date start_date, Date end_date, String comment, Boolean is_closed){
//        this.number_id = number_id;
//        this.start_date = start_date;
//        this.end_date = end_date;
//        this.comment = comment;
//        this.is_closed = is_closed;
//    }

    public Number toEntity(){
        return Number.builder()
                .number_id(number_id)
                .start_date(start_date)
                .end_date(end_date)
                .comment(comment)
                .is_closed(is_closed)
                .build();
    }
}
