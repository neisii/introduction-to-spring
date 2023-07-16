package hello.hellospring.repository.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 단위 테스트
 */
class MemberServiceTest {
  MemberService memberService;
  MemberRepository memberRepository;

  @BeforeEach
  void setUp() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  void tearDown() {
//    memberRepository.clearStore();
  }

  @DisplayName("회원가입")
  @Test
  void join() {
    // given
    Member member = new Member();
    member.setName("hello");

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
//    try {
//      memberService.join(member2);
//      fail();
//    } catch (IllegalStateException e) {
//      Assertions.assertThat(e.getMessage()).isEqualTo("Already exist name.");
//    }
  }

  @DisplayName("전체 회원 조회")
  @Test
  void findMembers() {
    // given

    // when

    // then
  }

  @DisplayName("회원 조회")
  @Test
  void findOne() {
    // given

    // when

    // then
  }
}