# 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

## Gradle Build
`./gradlew build` or `./gradlew clean build`

* Result
`{projectRoot}/build/lib/hello-spring-0.0.1-SNAPSHOT.jar`

* Run Spring boot server
`java -jar hello-spring-0.0.1-SNAPSHOT.jar`


## 웹 개발 기초

정적 컨텐츠: html js 파일 그대로 웹브라우저에 전달
MVC와 템플릿 엔진: jsp php 가공해서 전달
API: json 데이터 포맷으로 전달 서버끼리 통신하거나... 데이터 전달이 필요한 경우


## MVC
* model
* view
* controller

## 비즈니스 요구사항 정의
### 회원 관리

`어떤 디비를 사용할지 정해지지 않은 상태에서 개발해야 할 때를 가정한다.`

* 컨트롤러: 웹 MVC의 컨트롤러
* 서비스: 핵심 비즈니스 로직 구현
* 도메인: 비즈니스 도메인 객체 예) 회원 주문 쿠폰 등 주로 디비에 저장하고 관리됨
* 리포지토리: 디비에 접근, 도메인 객체를 디비에 저장하고 관리


클래스 의존 관계
회원 서비스 - 회원 리포지토리(인터페이스) - 메모리기반 회원 리포지토리(구현체)


## H2 console
Console URL `http://localhost:8082/test.do`
JDBC URL `jdbc:h2:tcp://localhost/~/test`


## AOP
* 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)을 분리한다.
* Aspect Oriented Programming
* 