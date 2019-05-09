package ac.ks.web.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor

// JPA
@Entity
@Table
public class Entity2 {
    @Id // Key
    @Column
    //PDF에 칼럼이 하나 잘려서 비슷할것 같은 칼럼 임의로 정의했습니다.
    private String zipcode;

    @Column
    private String postcode;

    @Builder// Lombok 빌더패턴
    public Entity2(String zipcode, String postcode) {
        this.zipcode = zipcode;
        this.postcode = postcode;
    }
}
