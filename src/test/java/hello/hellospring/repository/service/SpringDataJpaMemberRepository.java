package hello.hellospring.repository.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { // interface가 interface를 받을 때는 implements가 아닌 extends를 쓴다.

    @Override
    Optional<Member> findByName(String name);

}
