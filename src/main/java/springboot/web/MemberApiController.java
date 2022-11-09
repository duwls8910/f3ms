package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.service.member.MemberService;
import springboot.web.dto.member.MemberJoinNumberResponseDto;
import springboot.web.dto.member.MemberRequestDto;
import springboot.web.dto.member.MemberResponseDto;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("admin/management/member")
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("") //저장
    public ResponseEntity<Long> save(@RequestBody final MemberRequestDto params){
        return ResponseEntity.ok().body(memberService.save(params));
    }
    @GetMapping("")
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        return ResponseEntity.ok().body(memberService.findAll());
    }

    @GetMapping(" /number/{number_id}/position_cd") //해당 기수 포지션별 수강생 조회
    public ResponseEntity<List<MemberResponseDto>> findByNumberIdAndPosition(@PathVariable("number_id") Long number_id,@RequestParam("position_cd")int position_cd) {
        return ResponseEntity.ok().body(memberService.findByNumberIdAndPosition(number_id, position_cd));
    }

    @GetMapping("/number/{number_id}") //해당 기수 전체 수강생 조회
    public ResponseEntity<List<MemberResponseDto>> findByNumberId(@PathVariable Long number_id){
        return ResponseEntity.ok().body(memberService.findByNumberId(number_id));
    }
    @GetMapping("/{id}") //수강생 개인 조회
    public ResponseEntity<MemberJoinNumberResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(memberService.findById(id));
    }
    @PutMapping("/{id}") // 정보 수정 여기서 비활성화 가능
    public ResponseEntity<Long> update(@PathVariable final Long id, @RequestBody final MemberRequestDto params){
        return ResponseEntity.ok().body(memberService.update(id, params));
    }
}
