package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

  MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();


  @AfterEach
  void tearDown() {
    memoryMemberRepository.clearStore();
  }

  @DisplayName("save")
  @Test
  void save() {

    // given
    Member member = new Member();
    member.setName("spring");
    memoryMemberRepository.save(member);

    // when
    Member result = memoryMemberRepository.findById(member.getId()).get();

    // then
    assertThat(member).isEqualTo(result);
  }

  @DisplayName("findByName")
  @Test
  void findByName() {

    // given
    Member member1 = new Member();
    member1.setName("spring1");
    memoryMemberRepository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    memoryMemberRepository.save(member2);

    // when
    Member result = memoryMemberRepository.findByName("spring1").get();

    // then
    assertThat(result).isEqualTo(member1);
  }

  @DisplayName("findAll")
  @Test
  void findAll() {

    // given
    Member member1 = new Member();
    member1.setName("spring1");
    memoryMemberRepository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    memoryMemberRepository.save(member2);

    // when
    List<Member> result = memoryMemberRepository.findAll();

    // then
    assertThat(result.size()).isEqualTo(2);
  }


}