package ac.ks.web.domain;

import ac.ks.web.repository.Entity2Repository;
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
public class Entity2Test {

    @Autowired
    private Entity2Repository entity2Repository;


    @Before
    public void init() {
        entity2Repository.save(Entity2.builder()
                .zipcode("000-00")
                .postcode("12345")
                .build());

        entity2Repository.save(Entity2.builder()
                .zipcode("123-45")
                .postcode("45678")
                .build());
    }

    @Test
    public void testFindZipcode() {
        List<Entity2> findZipcode = entity2Repository.findAllByZipcode("000-00");
        assertThat(findZipcode.size()).isEqualTo(1);

        List<Entity2> findZipcode2 = entity2Repository.findAllByZipcode("000-24");
        assertThat(findZipcode2.size()).isEqualTo(0);
    }

    @Test
    public void testFindPostcode() {
        List<Entity2> findPostcode = entity2Repository.findAllByPostcode("12345");
        assertThat(findPostcode.size()).isEqualTo(1);

        List<Entity2> findPostcode2 = entity2Repository.findAllByPostcode("45678");
        assertThat(findPostcode2.size()).isEqualTo(1);
    }
}
