package denisspec.spring.dao.repository;

import denisspec.spring.entity.Comment;
import denisspec.spring.entity.Userm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Optional<Comment> findByContent(String content);
}
