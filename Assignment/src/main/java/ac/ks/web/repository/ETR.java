package ac.ks.web.repository;

import ac.ks.web.domain.ET;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ETR extends JpaRepository<ET, Long> {
    List<ET> findAllByIndex(int index);
    List<ET> findAllByName(String name);
}
