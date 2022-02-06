package denisspec.spring.dao.repository;

import denisspec.spring.entity.Post;
import denisspec.spring.entity.Userm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findByTitle(String title);

}
