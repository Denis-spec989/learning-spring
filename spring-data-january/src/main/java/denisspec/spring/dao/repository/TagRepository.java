package denisspec.spring.dao.repository;

import denisspec.spring.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {

}
