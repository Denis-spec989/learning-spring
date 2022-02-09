package denisspec.spring.dao;

import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.PostRepository;
import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.entity.Post;
import denisspec.spring.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class PostRepositoryTest {


    private final PostService postService;

    @Autowired
    public PostRepositoryTest(PostService postService) {
        this.postService = postService;
    }

    @Test
    void create(){
        postService.create("Day 4","All is ok again",1L);
        assertEquals("Day 4", postService.getById(4L).getTitle());
    }
    @Test
    void update(){
        postService.updateTitleByPostId("Day 4",1L);
        assertEquals("Day 4",postService.getById(1L).getTitle());
        assertNotNull(postService.getById(1L).getDtUpdated());
    }
    @Test
    void delete(){
        postService.deleteById(1L);
        assertEquals(2,postService.getAll().size());
    }

    @Test
    void postTagComment()
    {
        Post post = postService.getById(1L);
        assertEquals(3,post.getComments().size());
        assertEquals(2,post.getTags().size());
    }

}
