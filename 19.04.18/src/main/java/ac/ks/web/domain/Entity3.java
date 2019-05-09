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
public class Entity3 {
    @Column
    private String network;

    @Column
    private String userName;

    @Id
    @Column
    private String url;

    @Builder
    public Entity3(String network, String userName, String url) {
        this.network = network;
        this.userName = userName;
        this.url = url;
    }
}
