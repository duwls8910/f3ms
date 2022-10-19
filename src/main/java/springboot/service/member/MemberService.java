package springboot.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.member.Member;
import springboot.domain.member.MemberRepository;
import springboot.web.dto.member.MemberRequestDto;
import springboot.web.dto.member.MemberResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(final MemberRequestDto params){
        Member entity = memberRepository.save(params.toEntity());
        return entity.getId();
    }
    @Transactional
    public List<MemberResponseDto> findByNumberId(final Long number_id){
        List<Member> entity = memberRepository.findByNumberId(number_id);
        return entity.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<MemberResponseDto> findByNumberIdAndPosition(final Long number_id, int position_cd){
        List<Member> entity = memberRepository.findByNumberIdAndPosition(number_id , position_cd);
        return entity.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public MemberResponseDto findById(final Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("no.."));
        return new MemberResponseDto(entity);
    }
    @Transactional
    public Long update(final Long id , final MemberRequestDto params) {
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("nope.."));
        entity.update(params.getMember_name(), params.getIs_active(),params.getPosition_cd(),params.getMain_team_id(),params.getPre_team_id());
        return id;
    }

}
