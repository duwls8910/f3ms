package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.service.number.NumberService;
import springboot.web.dto.number.NumberResponseDto;
import springboot.web.dto.number.NumberRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NumberApiController {
    private final NumberService numberService;

    @GetMapping("admin/management/number")
    public List<NumberResponseDto> findAll() {
        return numberService.findAll();
    }

    @GetMapping("admin/management/number/{id}")
    public NumberResponseDto findById(@PathVariable Long id) {
        return numberService.findById(id);
    }

    @PostMapping("admin/management/number")
    public long save(@RequestBody final NumberRequestDto params){
        return numberService.save(params);
    }

    @PutMapping("admin/management/number/{id}")
    public Long save(@PathVariable final Long id,@RequestBody final NumberRequestDto params){
        return numberService.update(id, params);
    }

}