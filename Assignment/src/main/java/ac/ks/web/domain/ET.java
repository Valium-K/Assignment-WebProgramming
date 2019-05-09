package ac.ks.web.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor

@Table
@Entity
public class ET {


    @Column
    @Id
    private int index;

    @Column
    private String name;


    @Builder
    public ET(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
