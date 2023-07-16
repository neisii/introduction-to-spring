package hello.hellospring.domain;

import javax.persistence.*;

@Entity // JPA가 관리하는 엔티티가 된다.
public class Member {

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 디비가 알아서 생성해준다.
  private Long id;
  
  
//  @Column(name = "username") // 디비와 컬럼명이 다른 경우 지정한다.ㅏ
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
