package ac.ks.web.domain;


import ac.ks.web.repository.Entity4Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Entity4Test {

    @Autowired
    private Entity4Repository entity4Repository;


    @Before
    public void init() {
        entity4Repository.save(Entity4.builder()
                .company("(주)홍길동")
                .position("개발자")
                .website("http://company.domain")
                .startDate(new Date(2019, 1, 1))
                .endDate(new Date(2019, 1, 1))
                .summary("요약")
                .build());

        entity4Repository.save(Entity4.builder()
            .company("회사")
            .position("디자이너")
            .website("http://company.domain")
            .startDate(new Date(2016, 1, 1))
            .endDate(new Date(2019, 2, 2))
            .summary("괜찮")
            .build());
    }

    @Test
    public void testFindCompany() {
        List<Entity4> findCompany = entity4Repository.findAllByCompany("(주)홍길동");
        assertThat(findCompany.size()).isEqualTo(1);

        List<Entity4> findCompany2 = entity4Repository.findAllByCompany("회사");
        assertThat(findCompany2.size()).isEqualTo(1);
    }

    @Test
    public void testFindPosition() {
        List<Entity4> findPosition = entity4Repository.findAllByPosition("개발자");
        assertThat(findPosition.size()).isEqualTo(1);

        List<Entity4> findPosition2 = entity4Repository.findAllByPosition("디자이너");
        assertThat(findPosition2.size()).isEqualTo(1);
    }

    @Test
    public void testFindWebsite() {
        List<Entity4> findWebsite = entity4Repository.findAllByWebsite("http://company.domain");
        assertThat(findWebsite.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void testFindStartDate() {
        List<Entity4> findStartDate = entity4Repository.findAllByStartDate(new Date(2019, 1, 1));
        assertThat(findStartDate.size()).isEqualTo(1);

        List<Entity4> findStartDate2 = entity4Repository.findAllByStartDate(new Date(2016, 1, 1));
        assertThat(findStartDate2.size()).isEqualTo(1);
    }

    @Test
    public void testFindEndDate() {
        List<Entity4> findEndDate = entity4Repository.findAllByEndDate(new Date(2019, 1, 1));
        assertThat(findEndDate.size()).isEqualTo(1);

        List<Entity4> findEndDate2 = entity4Repository.findAllByEndDate(new Date(2019, 2, 2));
        assertThat(findEndDate2.size()).isEqualTo(1);
    }

    @Test
    public void testFindSummary() {
        List<Entity4> findSummary= entity4Repository.findAllBySummary("괜찮");
        assertThat(findSummary.size()).isEqualTo(1);

        List<Entity4> findSummary2= entity4Repository.findAllBySummary("요약");
        assertThat(findSummary2.size()).isEqualTo(1);
    }
}
