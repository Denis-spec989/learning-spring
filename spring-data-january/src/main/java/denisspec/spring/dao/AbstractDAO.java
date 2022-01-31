package denisspec.spring.dao;

import java.util.List;

public interface AbstractDAO<T> {

    void create(T data);

    List<T> getAll();

    T getById(long id);

    void update(long id, T data);

    void delete(long id);
}
