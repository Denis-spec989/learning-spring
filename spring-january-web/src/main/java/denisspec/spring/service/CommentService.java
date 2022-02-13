package denisspec.spring.service;



import denisspec.spring.entity.Comment;
import denisspec.spring.repository.CommentRepository;
import denisspec.spring.repository.PostRepository;
import denisspec.spring.repository.UsermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UsermRepository usermRepository;
    private final PostRepository postRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, UsermRepository usermRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.usermRepository = usermRepository;
        this.postRepository = postRepository;
    }

    public void create(String username, String postTitle, String content)
    {
        Comment comment = new Comment();
        comment.setUserm(usermRepository.findByUsername(username).get());
        comment.setPost(postRepository.findByTitle(postTitle).get());
        comment.setContent(content);
        commentRepository.save(comment);
    }

    public void updateCommentById(String content, Long commentId)
    {
     Comment comment = commentRepository.findById(commentId).get();
     comment.setContent(content);
     comment.setDtUpdated(LocalDateTime.now());
     commentRepository.save(comment);
    }
    public void deleteById(Long commentId)
    {
        commentRepository.deleteById(commentId);
    }
    public Comment getById(Long commentId)
    {
        return commentRepository.findById(commentId).get();
    }
    public List<Comment> getAllInPost(Long postId)
    {
       return postRepository.findById(postId).get().getComments();

    }
    public Comment findByContent( String content)
    {
        return commentRepository.findByContent(content).get();
    }






}
