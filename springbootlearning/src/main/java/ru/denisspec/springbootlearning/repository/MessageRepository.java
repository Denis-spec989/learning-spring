package ru.denisspec.springbootlearning.repository;


import org.springframework.data.repository.CrudRepository;
import ru.denisspec.springbootlearning.domain.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    List<Message> findByTag(String tag);
}
