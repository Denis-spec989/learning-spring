package denisspec.spring.service;


import denisspec.spring.entity.Post;
import denisspec.spring.repository.PostRepository;
import denisspec.spring.repository.UsermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

private final PostRepository postRepository;
private final UsermRepository usermRepository;


    @Autowired
    public PostService(PostRepository postRepository, UsermRepository usermRepository) {
        this.postRepository = postRepository;
        this.usermRepository = usermRepository;
    }

    public void create(String title, String content,Long userId)
    {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setDtCreated(LocalDateTime.now());
        post.setUserm(usermRepository.getById(userId));
        postRepository.save(post);
    }
    public void create(String title, String content,String username)
    {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setDtCreated(LocalDateTime.now());
        post.setUserm(usermRepository.findByUsername(username).get());
        postRepository.save(post);
    }
    public void updatePostById(String title,String content, Long postId)
    {
        Post post = postRepository.findById(postId).get();
        post.setTitle(title);
        post.setContent(content);
        post.setDtUpdated(LocalDateTime.now());
        postRepository.save(post);
    }
    public void updateTitleByPostId(String title,Long postId)
    {
        Post post = postRepository.findById(postId).get();
        post.setTitle(title);
        post.setDtUpdated(LocalDateTime.now());
        postRepository.save(post);
    }
    public void updateContentByPostId(String content,Long postId)
    {
        Post post = postRepository.findById(postId).get();
        post.setContent(content);
        post.setDtUpdated(LocalDateTime.now());
        postRepository.save(post);
    }
    public void deleteById(Long postId)
    {
        postRepository.deleteById(postId);
    }
    public Post getById(Long postId)
    {
        return postRepository.findById(postId).get();
    }

    public List<Post>  getAll()
    {
        return postRepository.findAll();
    }





}
