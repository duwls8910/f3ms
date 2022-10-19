package springboot.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.service.team.PreTeamService;
import springboot.web.dto.preteam.PreTeamJoinMemberResponseDto;
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

    @GetMapping("/number/{number_id}")
    public ResponseEntity<List<PreTeamResponseDto>> findByNumberId(@PathVariable Long number_id){
        return ResponseEntity.ok().body(preTeamService.findByNumberId(number_id));
    }

    @GetMapping("/{id}") //멤버정보 같이 줘야함
    public ResponseEntity<PreTeamJoinMemberResponseDto> FindById(@PathVariable Long id){
        return ResponseEntity.ok().body(preTeamService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable final Long id, @RequestBody final PreTeamSaveRequestDto params){
        return ResponseEntity.ok().body(preTeamService.update(id, params));
    }
}
