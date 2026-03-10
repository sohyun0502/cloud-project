package kr.spartaclub.cloudproject.member.repository;

import kr.spartaclub.cloudproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
