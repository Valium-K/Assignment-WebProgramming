package ac.ks.web.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

// JPA
@Entity
@Table
public class Entity4 {
    @Column
    private String company;

    @Column
    private String position;

    @Id
    @Column
    private String website;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String summary;

    @Builder
    public Entity4(String company, String position, String website, Date startDate, Date endDate, String summary) {
        this.company = company;
        this.position = position;
        this.website = website;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
    }
}
