package ac.ks.web.repository;

import ac.ks.web.domain.Entity1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Entity1Repository extends JpaRepository<Entity1, Long>  {
    List<Entity1> findAllByName(final String name);
    List<Entity1> findAllByLabel(final String label);
    List<Entity1> findAllByEmail(final String email);
    List<Entity1> findAllByPhone(final String phone);
}
