package ac.ks.web.domain;


import ac.ks.web.repository.Entity3Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Entity3Test {
    @Autowired
    private Entity3Repository entity3Repository;
    private Entity3 savedEntity3;

    @Before
    public void init() {
        savedEntity3 = entity3Repository.save(Entity3.builder()
                    .network("Twitter")
                    .userName("홍길동")
                    .url("http://twitter.com/홍길동")
                    .build());

        entity3Repository.save(Entity3.builder()
                .network("Facebook")
                .userName("이승찬")
                .url("http://facebook.com/이승찬")
                .build());
    }

    @Test
    public void testFindNetwork() {
        List<Entity3> findNetwork = entity3Repository.findAllByNetwork("Twitter");
        assertThat(findNetwork.size()).isEqualTo(1);

        List<Entity3> findNetwork2 = entity3Repository.findAllByNetwork("Facebook");
        assertThat(findNetwork2.size()).isEqualTo(1);
    }
    @Test
    public void testFindUserName() {
        List<Entity3> findUserName = entity3Repository.findAllByUserName("이승찬");
        assertThat(findUserName.size()).isEqualTo(1);

        List<Entity3> findUserName2 = entity3Repository.findAllByUserName("홍길동");
        assertThat(findUserName2.size()).isEqualTo(1);
    }

    @Test
    public void testFinedUrl() {
        List<Entity3> findUserUrl = entity3Repository.findAllByUrl("http://facebook.com/이승찬");
        assertThat(findUserUrl.size()).isEqualTo(1);

        List<Entity3> findUserUrl2 = entity3Repository.findAllByUrl("http://twitter.com/홍길동");
        assertThat(findUserUrl2.size()).isEqualTo(1);
    }
}
