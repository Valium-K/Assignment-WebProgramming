package ac.ks.web.domain;

import ac.ks.web.repository.Entity1Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class Entity1Test {

    @Autowired
    private Entity1Repository entity1Repository;
    private Entity1 savedEntity1;


    @Before
    public void init() {
        savedEntity1 = entity1Repository.save(Entity1.builder()
                    .name("홍길동")
                    .label("웹 프로그래머")
                    .email("홍길동@메일주소.도메인")
                    .phone("111-1234-5678")
                    .build());

        entity1Repository.save(Entity1.builder()
                .name("이승찬")
                .label("웹 프로그래머")
                .email("sive.dev")
                .phone("010-3060-1003")
                .build());

        entity1Repository.save(Entity1.builder()
                .name("이원주")
                .label("디자이너")
                .email("이원주@메일주소.도메인")
                .phone("010-1364-8735")
                .build());
    }

    @Test
    public void testFindName() {
        List<Entity1> findName = entity1Repository.findAllByName("홍길동");
        assertThat(findName.size()).isEqualTo(1);

        List<Entity1> findName2 = entity1Repository.findAllByName("이승찬");
        assertThat(findName2.size()).isEqualTo(1);

        List<Entity1> findName3 = entity1Repository.findAllByName("이원주");
        assertThat(findName3.size()).isEqualTo(1);
    }

    @Test
    public void testFIndLabel() {
        List<Entity1> findLabel = entity1Repository.findAllByLabel("웹 프로그래머");
        assertThat(findLabel.size()).isGreaterThanOrEqualTo(1);

        List<Entity1> findLabel2 = entity1Repository.findAllByLabel("디자이너");
        assertThat(findLabel2.size()).isEqualTo(1);
    }

    @Test
    public void testFindEmail() {
        List<Entity1> findEmail = entity1Repository.findAllByEmail("홍길동@메일주소.도메인");
        assertThat(findEmail.size()).isEqualTo(1);

        List<Entity1> findEmail2 = entity1Repository.findAllByEmail("sive.dev");
        assertThat(findEmail2.size()).isEqualTo(1);

        List<Entity1> findEmail3 = entity1Repository.findAllByEmail("이원주@메일주소.도메인");
        assertThat(findEmail3.size()).isEqualTo(1);
    }

    @Test
    public void testFindPhone() {
        List<Entity1> findPhone = entity1Repository.findAllByPhone("111-1234-5678");
        assertThat(findPhone.size()).isEqualTo(1);

        List<Entity1> findPhone2 = entity1Repository.findAllByPhone("010-3060-1003");
        assertThat(findPhone2.size()).isEqualTo(1);

        List<Entity1> findPhone3 = entity1Repository.findAllByPhone("010-1364-8735");
        assertThat(findPhone3.size()).isEqualTo(1);
    }
}
