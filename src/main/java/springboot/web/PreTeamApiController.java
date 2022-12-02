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
    public ResponseEntity<Long> save(@RequestBody final PreTeamSaveRequestDto params) {
        return ResponseEntity.ok().body(preTeamService.save(params));
    }

    @GetMapping("")// 팀 전체 조회
    public ResponseEntity<List<PreTeamResponseDto>> findAll() {
        return ResponseEntity.ok().body(preTeamService.findAll());
    }

    @GetMapping("/number/{number_id}") //해당 기수 전체 팀 조회
    public ResponseEntity<List<PreTeamResponseDto>> findByNumberId(@PathVariable Long number_id){
        return ResponseEntity.ok().body(preTeamService.findByNumberId(number_id));
    }

    @GetMapping("/{id}") //해당 팀 조회 (팀 정보)+ 멤버정보 같이 줘야함
    public ResponseEntity<PreTeamJoinMemberResponseDto> FindById(@PathVariable Long id){
        return ResponseEntity.ok().body(preTeamService.findById(id));
    }
    @PutMapping("/{id}")//팀 정보 수정(비활성화 기능포함)
    public ResponseEntity<Long> update(@PathVariable final Long id, @RequestBody final PreTeamSaveRequestDto params){
        return ResponseEntity.ok().body(preTeamService.update(id, params));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Long> openedUpdate(@PathVariable final Long id, @RequestBody final PreTeamSaveRequestDto params){
        return ResponseEntity.ok().body(preTeamService.openedUpdate(id, params));
    }
}
