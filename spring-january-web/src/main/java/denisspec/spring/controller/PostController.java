package denisspec.spring.controller;

import denisspec.spring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    private final PostRepository postRepository;

     @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
