package denisspec.spring.dao.repository;

import denisspec.spring.entity.Userm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsermRepository extends JpaRepository<Userm,Long> {
    Optional<Userm> findByUsername(String username);
}
