package denisspec.spring.controller;

import denisspec.spring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan("denisspec.spring.repository")
public class PostController {

    private final PostRepository postRepository;
    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String posts(ModelMap model)
    {
        model.put("posts",postRepository.findAll());
        return "all_posts";
    }
}
