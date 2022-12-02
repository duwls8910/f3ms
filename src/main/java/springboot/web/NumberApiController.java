package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.service.number.NumberService;
import springboot.web.dto.number.NumberResponseDto;
import springboot.web.dto.number.NumberRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("admin/management/number")
public class NumberApiController {
    private final NumberService numberService;


    @GetMapping("")
    public ResponseEntity<List<NumberResponseDto>> findAll() {
        return ResponseEntity.ok().body(numberService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<NumberResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(numberService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> save(@RequestBody final NumberRequestDto params){
        return ResponseEntity.ok().body(numberService.save(params));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable final Long id,@RequestBody final NumberRequestDto params){
        return ResponseEntity.ok().body(numberService.update(id, params));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Long> closedUpdate(@PathVariable final Long id,@RequestBody final NumberRequestDto params){
        return ResponseEntity.ok().body(numberService.closedUpdate(id, params));
    }
}
