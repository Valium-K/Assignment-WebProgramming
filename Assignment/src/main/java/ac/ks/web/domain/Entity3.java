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
public class Entity3 {
    @Column
    private String network;

    @Column
    private String userName;

    @Id // Key
    @Column
    private String url;

    @Builder// Lombok 빌더패턴
    public Entity3(String network, String userName, String url) {
        this.network = network;
        this.userName = userName;
        this.url = url;
    }
}
