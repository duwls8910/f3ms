package springboot.service.number;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.number.Number;
import springboot.domain.number.NumberRepository;
import springboot.web.dto.number.NumberResponseDto;
import springboot.web.dto.number.NumberRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //final이 선언된 모든필드를 인자값으로하는 생성자를 생성해줌 = lombok
@Service
public class NumberService {
    private final NumberRepository numberRepository;

    @Transactional
    public Long save(final NumberRequestDto params){
        Number sameNameCheck =numberRepository.findByNumber_name(params.getNumber_name());
        if(sameNameCheck== null){
            Number entity = numberRepository.save(params.toEntity());
            return entity.getId();
        }else{
            return 404L;
        }

    }
    @Transactional
    public List<NumberResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Number> entity = numberRepository.findAll(sort);
        return entity.stream().map(NumberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long update(final Long id, final NumberRequestDto params){
        Number entity = numberRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("no.."));
        entity.update(params.getStart_date(),params.getEnd_date(),params.getComment(), params.getIs_closed());
        return id;
    }

    @Transactional
    public NumberResponseDto findById(final Long id){
        Number entity = numberRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("no.."));
        return new NumberResponseDto(entity);
    }

}
