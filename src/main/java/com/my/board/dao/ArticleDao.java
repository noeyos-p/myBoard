package com.my.board.dao;

import com.my.board.dto.ArticleDto;
import com.my.board.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Transactional
public class ArticleDao {
    // Dao = SQL 실행 + 결과 Mapping
    @Autowired
    EntityManager em;

    public List<Article> findAllArticle() {
        String sql = "SELECT a FROM Article a " +
                "ORDER BY a.id DESC";
        // 순수 SQL이 아닌 JPQL 이다
        List<Article> articles =
                em.createQuery(sql)/* JPQL을 전달해서 Query 객체를 생성 */
                        .getResultList/* DB에 SQL 구문을 보내고, 결과를 받아옴 */();

        // JPQL 을 JPA 가 적절한 SQL 구문으로 번역해줌
        return articles;
    }

    public Article getOneArticle(Long id) {
        return em.find(Article.class, id);
        // Article.class는 클래스 객체를 의미함
    }

    public void deleteArticle(Long id) {
        Article article = em.find(Article.class, id);
        em.remove(article); // 삭제
    }

    public void insertArticle(Article article) {
        em.persist(article); // INSERT SQL 으로 전송X (쓰기지연)
        em.flush(); // 여기서 INSERT SQL 즉시 실행
    }

    public void updateArticles(ArticleDto dto) {
        Article article = em.find(Article.class, dto.getId()); /* Article 에서 dto를 찾아서 넣음 */
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        // title과 content만 바꿔줌
    }

}