package ac.ks.web.repository;

import ac.ks.web.domain.Entity4;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface Entity4Repository extends JpaRepository<Entity4, Long> {
    List<Entity4> findAllByCompany(final String company);
    List<Entity4> findAllByPosition(final String position);
    List<Entity4> findAllByWebsite(final String website);
    List<Entity4> findAllByStartDate(final Date startDate);
    List<Entity4> findAllByEndDate(final Date endDate);
    List<Entity4> findAllBySummary(final String summary);
}
