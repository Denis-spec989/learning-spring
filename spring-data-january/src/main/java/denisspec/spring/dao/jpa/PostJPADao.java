package denisspec.spring.dao.jpa;

import denisspec.spring.dao.AbstractDAO;
import denisspec.spring.entity.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostJPADao implements AbstractDAO<Post> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Post data) {
        em.persist(data);
    }

    @Override
    public List<Post> getAll() {
        String query = "select p from Post p";
        return em.createQuery(query).getResultList();
    }

    @Override
    public Post getById(long id) {
        return em.find(Post.class,id);
    }

    @Override
    public void update(long id, Post data) {
    data.setPostId(id);
    em.merge(data);

    }

    @Override
    public void delete(long id) {
    Post post = em.find(Post.class,id);
    em.remove(post);
    }
}
