package ac.ks.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

// JPA
@Entity
@Table
public class Entity1 {
    @Column
    private  String name;

    @Column
    private  String label;

    @Column
    private  String email;

    @Id
    @Column
    private  String phone;

    @Builder
    public Entity1(String name, String label, String email, String phone) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
    }
}
