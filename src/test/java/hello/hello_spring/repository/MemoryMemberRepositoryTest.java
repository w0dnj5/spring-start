package hello.hello_spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hello.hello_spring.domain.Member;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // @Test 실행이 되고 끝날 때 마다 @AfterEach 실행
    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    // 여러 개의 문자열을 테스트하는 방법
    @ParameterizedTest
    @ValueSource(strings = {"spring1", "spring2"})
    void findByName(String name) {
        Member member1 = new Member();
        member1.setName(name);
        repository.save(member1);

        Member result = repository.findByName(name).get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}