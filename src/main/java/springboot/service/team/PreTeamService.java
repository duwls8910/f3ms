package springboot.service.team;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.team.PreTeam;
import springboot.domain.team.PreTeamRepository;
import springboot.web.dto.preteam.PreTeamResponseDto;
import springboot.web.dto.preteam.PreTeamSaveRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PreTeamService {
    private final PreTeamRepository preTeamRepository;

    @Transactional
    public Long save(final PreTeamSaveRequestDto params) throws JsonProcessingException { //number_id 도 받아서
        PreTeam entity = preTeamRepository.save(params.toEntity());
        //System.out.println(params.getNumber().getNumber_id());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(params);
        System.out.println("팀서비스 뭐들어오나 보자~~"+json);
        return entity.getId();
    }
    @Transactional
    public List<PreTeamResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<PreTeam> entity = preTeamRepository.findAll(sort);
        return entity.stream().map(PreTeamResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public List<PreTeamResponseDto> findByNumber_id(long number_id){
        List<PreTeam> entity = preTeamRepository.findByNumber_id(number_id);
        return entity.stream().map(PreTeamResponseDto::new).collect(Collectors.toList());
    }

}
