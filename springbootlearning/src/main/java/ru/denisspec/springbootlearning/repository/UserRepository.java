package ru.denisspec.springbootlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denisspec.springbootlearning.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
