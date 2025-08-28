package com.my.board.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    private String body;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;

}
