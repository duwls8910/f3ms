package springboot.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.domain.team.Team;
import springboot.service.team.TeamService;
import springboot.web.dto.team.TeamResponseDto;
import springboot.web.dto.team.TeamSaveRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeamApiController {
    private final TeamService teamService;

    @PostMapping("admin/management/team")
    public Long save(@RequestBody final TeamSaveRequestDto params) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(params);
        System.out.println("params 뭐들어오나 보자~~"+json);

        return teamService.save(params);
    }

    @GetMapping("admin/management/team")
    public List<TeamResponseDto> findAll() {
        return teamService.findAll();
    }

    @GetMapping("admin/management/team/{number_id}")
    public List<TeamResponseDto> findByNumber_id(@PathVariable int number_id){
        return teamService.findByNumber_id(number_id);
    }
}
