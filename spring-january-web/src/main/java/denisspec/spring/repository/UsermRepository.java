package denisspec.spring.repository;

import denisspec.spring.entity.Userm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsermRepository extends JpaRepository<Userm,Long> {
    Optional<Userm> findByUsername(String username);
}
