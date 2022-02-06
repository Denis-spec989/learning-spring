package denisspec.spring.dao;

import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.PostRepository;
import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.entity.Post;
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

    private final PostRepository postRepository;

    private final UsermRepository usermRepository;

    @Autowired
    public PostRepositoryTest(PostRepository postRepository, UsermRepository usermRepository) {
        this.postRepository = postRepository;
        this.usermRepository = usermRepository;
    }

    @Test
    void create(){
        //  Assertions.assertEquals(4,2+2);
        Post post = new Post();
        post.setTitle("Day 4");
        post.setContent("All is ok again");
        post.setDtCreated(LocalDateTime.now());
        post.setUserm(usermRepository.getById(1L));
        postRepository.save(post);
        assertEquals("Day 4", postRepository.findById(4L).get().getTitle());
    }
    @Test
    void update(){
        //  Assertions.assertEquals(4,2+2);
        Post post = postRepository.findById(1L).get();
        post.setTitle("Day 4");
        post.setDtUpdated(LocalDateTime.now());
        postRepository.save(post);
        assertEquals("Day 4", postRepository.findById(1L).get().getTitle());
        assertNotNull(postRepository.findById(1L).get().getDtUpdated());
    }
    @Test
    void delete(){
        postRepository.deleteById(1L);
        assertEquals(2, postRepository.findAll().size());
    }

    @Test
    void postTagComment()
    {
        Post post = postRepository.findById(1L).get();
        assertEquals(3,post.getComments().size());
        assertEquals(2,post.getTags().size());
    }



}
