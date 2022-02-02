package denisspec.spring.dao;

import denisspec.spring.config.DataConfig;
import denisspec.spring.dto.PostDTO;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class PostJDBCDaoTest {
    private final AbstractDAO<PostDTO> postDao;

    @Autowired
    public PostJDBCDaoTest(AbstractDAO<PostDTO> postDao) {
        this.postDao = postDao;
    }
    @Test
    void create(){
      //  Assertions.assertEquals(4,2+2);
        PostDTO post = new PostDTO();
        post.setTitle("Day 4");
        post.setContent("All is ok again");
        post.setDtCreated(LocalDateTime.now());
        postDao.create(post);

               assertEquals("Day 4",postDao.getById(4).getTitle());
    }
    @Test
    void update(){
        //  Assertions.assertEquals(4,2+2);
        PostDTO post = postDao.getById(1);
        post.setTitle("Day 4");
        post.setDtUpdated(LocalDateTime.now());
        postDao.update(1,post);
        assertEquals("Day 4",postDao.getById(1).getTitle());
        assertNotNull(postDao.getById(1).getDtUpdated());
    }
    @Test
    void delete(){
        postDao.delete(1);
        assertEquals(2,postDao.getAll().size());
    }



}
