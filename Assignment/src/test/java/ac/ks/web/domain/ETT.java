package ac.ks.web.domain;

import ac.ks.web.repository.ETR;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ETT {
    @Autowired
    public ETR etr;

    @Before
    public void init() {
        etr.save(ET.builder().index(1).name("이승찬").build());
        etr.save(ET.builder().index(2).name("Lee").build());
    }

    @Test
    public void nameTest() {
        List<ET> foundName1 = etr.findAllByName("이승찬");
        assertThat(foundName1.size()).isEqualTo(1);

        List<ET> foundName2 = etr.findAllByName("Lee");
        assertThat(foundName2.size()).isEqualTo(1);
    }

    @Test
    public void indexTest() {
        List<ET> foundIndex1 = etr.findAllByIndex(1);
        assertThat(foundIndex1.size()).isEqualTo(1);

        List<ET> foundIndex2 = etr.findAllByIndex(2);
        assertThat(foundIndex2.size()).isEqualTo(1);
    }
}
