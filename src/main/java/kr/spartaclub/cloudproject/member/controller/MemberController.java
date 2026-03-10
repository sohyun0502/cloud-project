package kr.spartaclub.cloudproject.member.controller;

import kr.spartaclub.cloudproject.member.dto.CreateMemberRequest;
import kr.spartaclub.cloudproject.member.dto.GetMemberResponse;
import kr.spartaclub.cloudproject.member.entity.Member;
import kr.spartaclub.cloudproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity<Void> createMember(@RequestBody CreateMemberRequest request) {
        memberService.saveMember(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<GetMemberResponse> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }
}
