package com.my.board.service;

import com.my.board.ArticlesRepository;
import com.my.board.dao.ArticleDao;
import com.my.board.dto.ArticleDto;
import com.my.board.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleDao dao;
    private final ArticlesRepository articlesRepository;

    public List<ArticleDto> getAllArticle() {
        List<Article> articles = dao.findAllArticle();
        if (ObjectUtils.isEmpty(articles)) {
            return Collections.emptyList();
        } else {
            return articles.stream()
                    .map(x -> ArticleDto.fromArticle(x))
                    .toList();
        }
    }

    public Page<ArticleDto> getArticlePage(Pageable pageable) {
        Page<Article> articles = articlesRepository.findAll(pageable);
        if (ObjectUtils.isEmpty(articles)) {
            return null;
        }
        return articles.map(x -> ArticleDto.fromArticle(x));
    }

    public ArticleDto getOneArticle(Long id) {
        Article article = dao.getOneArticle(id);
        if (ObjectUtils.isEmpty(article)) {
            return null;
        }
        return ArticleDto.fromArticle(article);
    }
}