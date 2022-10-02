package springboot.service.team;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.number.Number;
import springboot.domain.team.Team;
import springboot.domain.team.TeamRepository;
import springboot.web.dto.number.NumberResponseDto;
import springboot.web.dto.team.TeamResponseDto;
import springboot.web.dto.team.TeamSaveRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Transactional
    public Long save(final TeamSaveRequestDto params) throws JsonProcessingException { //number_id 도 받아서
        Team entity = teamRepository.save(params.toEntity());
        //System.out.println(params.getNumber().getNumber_id());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(params);
        System.out.println("팀서비스 뭐들어오나 보자~~"+json);
        return entity.getId();
    }
    @Transactional
    public List<TeamResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Team> entity = teamRepository.findAll(sort);
        return entity.stream().map(TeamResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public List<TeamResponseDto> findByNumber_id(int number_id){
        List<Team> entity =teamRepository.findByNumber_id(number_id);
        return entity.stream().map(TeamResponseDto::new).collect(Collectors.toList());
    }

}
