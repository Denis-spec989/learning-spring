package denisspec.spring.dao;

import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.CommentRepository;
import denisspec.spring.dao.repository.PostRepository;
import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.entity.Comment;
import denisspec.spring.entity.Post;
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
    private final UsermRepository usermRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public UsermCommentPostTest(UsermRepository usermRepository, CommentRepository commentRepository, PostRepository postRepository) {
        this.usermRepository = usermRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Test
    public void CreatePostWithCommentByUser()
    {
        Post post = new Post();
        post.setTitle("How to take day off?");
        post.setContent("Just relax and listen good music.");
        post.setUserm(usermRepository.findByUsername("Denisspec").get());
        postRepository.save(post);
        Comment comment = new Comment();
        comment.setUserm(usermRepository.findByUsername("AleshaPopovich57").get());
        comment.setPost(postRepository.findByTitle("How to take day off?").get());
        comment.setContent("Wonderful advice");
        commentRepository.save(comment);

        assertEquals("AleshaPopovich57",commentRepository.findByContent("Wonderful advice").get().getUserm().getUsername());
        assertEquals("Denisspec",commentRepository.findByContent("Wonderful advice").get().getPost().getUserm().getUsername());

    }


}
