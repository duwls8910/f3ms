package springboot.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.service.team.PreTeamService;
import springboot.web.dto.preteam.PreTeamResponseDto;
import springboot.web.dto.preteam.PreTeamSaveRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("admin/management/pre-team")
public class PreTeamApiController {
    private final PreTeamService preTeamService;

    @PostMapping("")
    public ResponseEntity<Long> save(@RequestBody final PreTeamSaveRequestDto params) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(params);
        System.out.println("params 뭐들어오나 보자~~"+json);

        return ResponseEntity.ok().body(preTeamService.save(params));
    }

    @GetMapping("")
    public ResponseEntity<List<PreTeamResponseDto>> findAll() {
        return ResponseEntity.ok().body(preTeamService.findAll());
    }

    @GetMapping("/{number_id}")
    public ResponseEntity<List<PreTeamResponseDto>> findByNumber_id(@PathVariable long number_id){
        return ResponseEntity.ok().body(preTeamService.findByNumber_id(number_id));
    }
}
