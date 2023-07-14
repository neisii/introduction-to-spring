package hello.hellospring.repository.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Spring 통합 테스트
 */
@SpringBootTest
@Transactional // 다음 테스트에 영향을 주지 않는다.
class MemberServiceIntergrationTest {

  @Autowired MemberService memberService; // test case 에서는 필드 주입도 가능, 딴데서 안 쓰니까
  @Autowired MemberRepository memberRepository;

  @DisplayName("회원가입")
  @Test
  void join() {
    // given
    Member member = new Member();
    member.setName("spring");
    // when
    Long saveId = memberService.join(member);

    // then
    Member findMember = memberService.findOne(saveId).get();
    Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @DisplayName("중복 회원 예외")
  @Test
  void exceptionDuplicateMember() {

    // given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    // when // then
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    Assertions.assertThat(e.getMessage()).isEqualTo("Already exist name.");
  }
}