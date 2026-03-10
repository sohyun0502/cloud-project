package kr.spartaclub.cloudproject.member.service;

import kr.spartaclub.cloudproject.member.dto.CreateMemberRequest;
import kr.spartaclub.cloudproject.member.dto.GetMemberResponse;
import kr.spartaclub.cloudproject.member.entity.Member;
import kr.spartaclub.cloudproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(CreateMemberRequest request) {
        Member member = new Member(
                request.getName(),
                request.getAge(),
                request.getMbti()
        );

        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public GetMemberResponse getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 멤버입니다.")
        );

        return new GetMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }
}
