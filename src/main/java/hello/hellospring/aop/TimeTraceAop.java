package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP
@Component
public class TimeTraceAop { // 공통 로직 구성

  @Around("execution(* hello.hellospring..*(..)))") // 어디에 사용할지 지정한다. 패키지 *(..) : class 명, 파라미터
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    System.out.println("START:  " + joinPoint.toString());
    try {
      return joinPoint.proceed();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END:  " + joinPoint.toString() + " " + timeMs + "ms");
    }
  }
//  START:  execution(String hello.hellospring.controller.MemberController.list(Model))
//  START:  execution(List hello.hellospring.repository.service.MemberService.findMembers())
//  START:  execution(List hello.hellospring.repository.JpaMemberRepository.findAll())
//  Hibernate: select member0_.id as id1_0_, member0_.name as name2_0_ from member member0_
//  END:  execution(List hello.hellospring.repository.JpaMemberRepository.findAll()) 95ms
//  END:  execution(List hello.hellospring.repository.service.MemberService.findMembers()) 98ms
//  END:  execution(String hello.hellospring.controller.MemberController.list(Model)) 116ms
//  인터셉터로 로직 제어
}
