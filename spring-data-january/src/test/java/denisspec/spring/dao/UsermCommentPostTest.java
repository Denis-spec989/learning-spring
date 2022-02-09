package denisspec.spring.dao;

import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.CommentRepository;
import denisspec.spring.dao.repository.PostRepository;
import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.service.CommentService;
import denisspec.spring.service.PostService;
import denisspec.spring.service.UsermService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class UsermCommentPostTest
{
    private final UsermService usermService;
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public UsermCommentPostTest( UsermService usermService, PostService postService, CommentService commentService) {
        this.usermService = usermService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @Test
    public void CreatePostWithCommentByUser()
    {
        postService.create("How to take day off?","Just relax and listen good music.","Denisspec");
        commentService.create("AleshaPopovich57","How to take day off?","Wonderful advice");
        assertEquals("AleshaPopovich57",commentService.findByContent("Wonderful advice").getUserm().getUsername());
        assertEquals("Denisspec",commentService.findByContent("Wonderful advice").getPost().getUserm().getUsername());

    }


}
