package springboot.service.team;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.member.Member;
import springboot.domain.member.MemberRepository;
import springboot.domain.team.PreTeam;
import springboot.domain.team.PreTeamRepository;
import springboot.exception.BusinessLogicException;
import springboot.exception.ExceptionCode;
import springboot.web.dto.preteam.PreTeamJoinMemberResponseDto;
import springboot.web.dto.preteam.PreTeamResponseDto;
import springboot.web.dto.preteam.PreTeamSaveRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PreTeamService {
    private final PreTeamRepository preTeamRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(final PreTeamSaveRequestDto params) throws JsonProcessingException { //number_id 도 받아서
        PreTeam entity = preTeamRepository.save(params.toEntity());

        return entity.getId();
    }
    @Transactional
    public List<PreTeamResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<PreTeam> entity = preTeamRepository.findAll(sort);
        return entity.stream().map(PreTeamResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public List<PreTeamResponseDto> findByNumberId(final long number_id){
        List<PreTeam> entity = preTeamRepository.findByNumberId(number_id);
        return entity.stream().map(PreTeamResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public PreTeamJoinMemberResponseDto findById(final long id){
        PreTeam entity = preTeamRepository.findById(id)
                .orElseThrow(()-> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
       List<Member> memberInfo = memberRepository.findByPreTeamId(id);
        return new PreTeamJoinMemberResponseDto(entity,memberInfo);
    }
    //여기서 memberrepository 의 findbyteamid를 만들어서 member 타입 변수에 담아서 joinresponsedto에 파라미터 넘겨주고 joinresponsedto 생성자에 넣어주면???

    @Transactional
    public Long update(final Long id, final PreTeamSaveRequestDto params){
        PreTeam entity = preTeamRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        entity.update(params.getTeam_name(), params.getNumber_id(), params.getIs_opened(), params.getComment());
        return id;
    }

}
