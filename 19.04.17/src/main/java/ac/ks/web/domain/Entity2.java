package ac.ks.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

// JPA
@Entity
@Table
public class Entity2 {
    @Id
    @Column
    private String zipcode;

    @Column
    private String postcode;

    @Builder
    public Entity2(String zipcode, String postcode) {
        this.zipcode = zipcode;
        this.postcode = postcode;
    }
}
