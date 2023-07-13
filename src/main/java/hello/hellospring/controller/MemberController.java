package hello.hellospring.controller;

import hello.hellospring.repository.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
// @Autowired private final MemberService memberService; // 필드 주입: 별로 안 좋다. 중간에 바꿔치기 불가
  private final MemberService memberService;

//  @Autowired // Setter 주입 Setter Injection: public이라 바꿔치기 당할 수 있다.
//  public setMemberService(MemberService memberService) {
//    this.memberService = memberService;
//  }

  @Autowired // 생성자 주입: 권장 사항1
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }
}
