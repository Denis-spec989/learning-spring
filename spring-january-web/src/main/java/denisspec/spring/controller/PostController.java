package denisspec.spring.controller;

import denisspec.spring.entity.Userm;
import denisspec.spring.repository.PostRepository;
import denisspec.spring.repository.UsermRepository;
import denisspec.spring.service.UsermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@ComponentScan("denisspec.spring.repository")
public class PostController {

    private final PostRepository postRepository;
    private final UsermRepository usermRepository;
    private final UsermService usermService;
    @Autowired
    public PostController(PostRepository postRepository, UsermRepository usermRepository, UsermService usermService) {
        this.postRepository = postRepository;
        this.usermRepository = usermRepository;
        this.usermService = usermService;
    }

    @GetMapping("/")
    public String posts(ModelMap model)
    {
        model.put("posts",postRepository.findAll());
        setCommonParams(model);
        return "blog";
    }
    @GetMapping("/user/{username}")
    public String postByUser(@PathVariable String username,ModelMap model)
    {
        Userm userm = usermService.findByUsername(username);
        model.put("posts",userm.getPosts());
        return "blog";
    }

    private void setCommonParams(ModelMap model)
    {
        model.put("users",usermRepository.findAll());
    }
}
