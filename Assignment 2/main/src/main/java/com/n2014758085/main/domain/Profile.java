package com.n2014758085.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Profile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String userName;

    @Column
    private String url;

    @Column
    private LocalDateTime createdAt;

    @Builder
    public Profile(String network, String userName, String url, LocalDateTime createdAt) {
        this.network = network;
        this.userName = userName;
        this.url = url;
        this.createdAt = createdAt;
    }
}
