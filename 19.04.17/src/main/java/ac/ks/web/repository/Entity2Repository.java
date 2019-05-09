package ac.ks.web.repository;

import ac.ks.web.domain.Entity2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Entity2Repository extends JpaRepository<Entity2, Long> {
    List<Entity2> findAllByZipcode(final String zipcode);
    List<Entity2> findAllByPostcode(final String postcode);
}