package springboot.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.member.Member;
import springboot.domain.member.MemberRepository;
import springboot.domain.number.Number;
import springboot.domain.number.NumberRepository;
import springboot.web.dto.member.MemberJoinNumberResponseDto;
import springboot.web.dto.member.MemberRequestDto;
import springboot.web.dto.member.MemberResponseDto;
import springboot.web.dto.number.NumberResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final NumberRepository numberRepository;

    @Transactional
    public Long save(final MemberRequestDto params){
        Member entity = memberRepository.save(params.toEntity());
        return entity.getId();
    }
    @Transactional
    public List<MemberResponseDto> findAll(){
        List<Member> entity =  memberRepository.sortFindAll();
        return entity.stream().map(MemberResponseDto::new).collect(Collectors.toList());
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
    public MemberJoinNumberResponseDto findById(final Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("no.."));
       Number number = numberRepository.findByNumber_id(entity.getNumber_id());
        return new MemberJoinNumberResponseDto(entity, number);
    }
    @Transactional
    public Long update(final Long id , final MemberRequestDto params) {
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("nope.."));
        entity.update(params.getMember_name(), params.getIs_active(),params.getPosition_cd(),params.getMain_team_id(),params.getPre_team_id());
        return id;
    }

}
