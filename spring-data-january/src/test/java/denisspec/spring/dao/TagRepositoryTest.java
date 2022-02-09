package denisspec.spring.dao;


import denisspec.spring.config.DataConfig;

import denisspec.spring.dao.repository.TagRepository;
import denisspec.spring.service.TagService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class TagRepositoryTest {

    private final TagService tagService;

@Autowired
public TagRepositoryTest(TagService tagService) {
        this.tagService = tagService;

}


    @Test
    void createTags()
    {
        List.of("tag1","tag2","tag3").forEach(tagService::create);
        assertEquals(9,tagService.getAll().size());


    }
}
