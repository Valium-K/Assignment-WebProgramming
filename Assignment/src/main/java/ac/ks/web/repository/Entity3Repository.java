package ac.ks.web.repository;

import ac.ks.web.domain.Entity3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Entity3Repository extends JpaRepository<Entity3, Long> {
    List<Entity3> findAllByNetwork(final String network);
    List<Entity3> findAllByUserName(final String userName);
    List<Entity3> findAllByUrl(final String url);
}