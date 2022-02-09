package denisspec.spring.service;

import denisspec.spring.dao.repository.PostRepository;
import denisspec.spring.dao.repository.TagRepository;
import denisspec.spring.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;
    private final PostRepository postRepository;

    @Autowired
    public TagService(TagRepository tagRepository, PostRepository postRepository) {
        this.tagRepository = tagRepository;
        this.postRepository = postRepository;
    }

    public void create(String name)
    {
        Tag tag = new Tag();
        tag.setName(name);
        tagRepository.save(tag);
    }
    public void deleteById(Long tagId)
    {
        tagRepository.deleteById(tagId);
    }
    public List<Tag> getAll()
    {
        return tagRepository.findAll();
    }
    public List<Tag> getAllPostTags(Long postId)
    {
        return postRepository.findById(postId).get().getTags();
    }
}
