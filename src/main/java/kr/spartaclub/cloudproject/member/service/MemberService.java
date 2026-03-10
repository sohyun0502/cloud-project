package kr.spartaclub.cloudproject.member.service;

import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Template;
import kr.spartaclub.cloudproject.member.dto.CreateMemberRequest;
import kr.spartaclub.cloudproject.member.dto.GetMemberResponse;
import kr.spartaclub.cloudproject.member.entity.Member;
import kr.spartaclub.cloudproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofDays(10);
    private final S3Template s3Template;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

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

    @Transactional
    public void uploadProfileImage(Long id, MultipartFile file) {

        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 멤버입니다.")
        );

        String key = "uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename();

        try {
            s3Template.upload(bucket, key, file.getInputStream());

        } catch (IOException e) {
            // 적절한 커스텀 예외로 바꾸고, GlobalExceptionHandler로 핸들링 필요
            throw new RuntimeException("파일 업로드 실패", e);
        }

        member.updateProfileImageUrl(key);
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public URL getProfileImagePresignedUrl(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 멤버입니다.")
        );

        String key = member.getProfileImageUrl();
        return s3Template.createSignedGetURL(bucket, key, PRESIGNED_URL_EXPIRATION);
    }
}
