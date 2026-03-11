package kr.spartaclub.cloudproject.member.controller;

import kr.spartaclub.cloudproject.member.dto.CreateMemberRequest;
import kr.spartaclub.cloudproject.member.dto.GetMemberResponse;
import kr.spartaclub.cloudproject.member.dto.GetProfileImageUrlResponse;
import kr.spartaclub.cloudproject.member.entity.Member;
import kr.spartaclub.cloudproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 멤버 생성
     * @param request
     * @return
     */
    @PostMapping("/api/members")
    public ResponseEntity<Void> createMember(@RequestBody CreateMemberRequest request) {
        memberService.saveMember(request);
        return ResponseEntity.ok().build();
    }

    /**
     * 멤버 단건 조회
     * @param id
     * @return
     */
    @GetMapping("/api/members/{id}")
    public ResponseEntity<GetMemberResponse> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    /**
     * 파일 업로드
     * @param id
     * @param file
     * @return
     */
    @PostMapping("/api/members/{id}/profile-image")
    public ResponseEntity<String> uploadProfileImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        memberService.uploadProfileImage(id, file);
        return ResponseEntity.ok("프로필 업로드 성공");
    }

    /**
     * 파일 PresignedUrl 받기
     * @param id
     * @return
     */
    @GetMapping("/api/members/{id}/profile-image")
    public ResponseEntity<GetProfileImageUrlResponse> getProfileImage(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getProfileImagePresignedUrl(id));
    }
}
