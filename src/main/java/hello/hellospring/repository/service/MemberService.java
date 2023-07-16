package hello.hellospring.repository.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
  private final MemberRepository memberRepository;

  @Autowired // DI
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원 가입
   *
   * @param member
   * @return
   */
  public Long join(Member member) {
    long start = System.currentTimeMillis();

    try {// 동명이인은 회원 등록 안 함
      validateDuplicateMember(member);
      memberRepository.save(member);
      return member.getId();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("join = " + timeMs + " ms");
    }
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("Already exist name.");
        });
  }

  /**
   * 전체 회원 조회
   * @return
   */
  public List<Member> findMembers() {
    long start = System.currentTimeMillis();

    try {
      return memberRepository.findAll();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("findMembers = " + timeMs + " ms");
    }
  }

  /**
   * 회원 아이디로 조회
   * @param memberId
   * @return
   */
  public Optional<Member> findOne(Long memberId) {
    long start = System.currentTimeMillis();

    try {
      return memberRepository.findById(memberId);
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("findOne = " + timeMs + " ms");
    }
  }
}
