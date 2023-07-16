package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
  @Bean // 스프링 빈으로 자동 주입
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }
//  @Bean
//  public MemberRepository memberRepository() {
////    return new MemoryMemberRepository();
////    return new JdbcMemberRepository(dataSource);
////    return new JdbcTemplateMemberRepository(dataSource);
////    return new JpaMemberRepository(em);
//  }
}
