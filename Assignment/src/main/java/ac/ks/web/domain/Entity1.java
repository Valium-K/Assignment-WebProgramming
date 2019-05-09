package ac.ks.web.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Lombok
@NoArgsConstructor // 생성자함수

// JPA
@Entity
@Table
public class Entity1 {
    @Column // Attribute
    private String name;

    @Column
    private String label;

    @Column
    private String email;

    @Id // key
    @Column
    private String phone;

    @Builder // Lombok 빌더패턴
    public Entity1(String name, String label, String email, String phone) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
    }
}
