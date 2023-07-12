package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  // API 실습: JSON 형태로 반환
  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam(value = "name", required = true) String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello; // 객체가 반환이 되면 Spring은 HttpMessageConverter JSON 형태로 만들어서 반환(기본값)
  }

  static class Hello {
    private String name;

    public String getName() { // property 접근 방식
      return name;
    }

    public void setName(String name) { // property 접근 방식
      this.name = name;
    }
  }

  // API 실습
  @GetMapping("hello-string")
  @ResponseBody // http 에서 body 부에 return 데이터를 직접 넣겠다.
  public String helloString(@RequestParam(value = "name", required = true) String name) {
    return "hello " + name; // 뷰가 없이 문자열만 그대로 전달
  }

  // 파라미터를 받는다.
  // Model 에 담아야 렌더할 때 사용
  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template"; // ViewResolver 가 html 찾아서 반환
  }

  // 파라미터를 직접 설정한다.
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!!!!!");
    return "hello";
  }
}
