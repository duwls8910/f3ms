package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.domain.issue.MemberIssue;
import springboot.domain.issue.MemberIssueRepository;
import springboot.domain.member.Member;
import springboot.domain.member.MemberRepository;
import springboot.service.member.MemberService;
import springboot.web.dto.member.MemberRequestDto;
import springboot.web.dto.member.MemberResponseDto;
import springboot.web.dto.number.NumberRequestDto;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("admin/management/member")
public class MemberApiController {
    private final MemberService memberService;
    //---------------------------------
    private final MemberRepository memberRepository;
    private final MemberIssueRepository memberIssueRepository;

//    @GetMapping("/{id}")
//    public String test(@PathVariable Long id){
//        Member member = Member.builder().member_name("길동이").build();
//        MemberIssue memberIssue = MemberIssue.builder().title("학습고민").content("이게 멀까여").build();
//        member.mappedMemberIssue(memberIssue);
//        memberIssue.mappedMember(member);
//        //member.mappedMemberIssue(memberIssue);
//
//        memberRepository.save(member);
//        memberIssueRepository.save(memberIssue);
//
//        return "done..!!";
//    }

//    @GetMapping("")
//    public ResponseEntity<List<Member>> findAll() {
//        return new ResponseEntity<>(memberRepository.findAll(), HttpStatus.OK);
//    }
    //-------------------------------
    @PostMapping("") //저장
    public ResponseEntity<Long> save(@RequestBody final MemberRequestDto params){
        return ResponseEntity.ok().body(memberService.save(params));
    }
    //@PathVariable("email") String email)
    @GetMapping(" /number/{number_id}/position_cd") //해당 기수 포지션별 수강생 조회
    public ResponseEntity<List<MemberResponseDto>> findByNumberIdAndPosition(@PathVariable("number_id") Long number_id,@RequestParam("position_cd")int position_cd) {
        return ResponseEntity.ok().body(memberService.findByNumberIdAndPosition(number_id, position_cd));
    }

    @GetMapping("/number/{number_id}") //해당 기수 전체 수강생 조회
    public ResponseEntity<List<MemberResponseDto>> findByNumberId(@PathVariable Long number_id){
        return ResponseEntity.ok().body(memberService.findByNumberId(number_id));
    }
    @GetMapping("/{id}") //수강생 개인 조회
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(memberService.findById(id));
    }
    @PutMapping("/{id}") // 정보 수정 여기서 비활성화 가능
    public ResponseEntity<Long> update(@PathVariable final Long id,@RequestBody final MemberRequestDto params){
        return ResponseEntity.ok().body(memberService.update(id, params));
    }
}
