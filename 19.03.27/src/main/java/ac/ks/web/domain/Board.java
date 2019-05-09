package ac.ks.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity = 아래의 클래스는 db table로 쓸꺼다
//@Table =

// 2개 Lombok꺼
@Getter
//디폴트 생성자 생성
@NoArgsConstructor
//2개 JPA꺼
@Entity
@Table
public class Board {
    //DDL에서 제약조건을 건다
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;
    @Column
    private String subTitle;
    //content을 Column으로 선언
    @Column
    private String content;

    @Column
    //값의 의미를위해 이넘타입씀
    @Enumerated(EnumType.STRING)
    private BoardType boardType;
    @Column
    private LocalDateTime createdDate;
    @Column
    private LocalDateTime updatedDate;



    // 빌더는 생성자 위에 바로붙이기
    @Builder
    public Board(String title, String subTitle, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}

