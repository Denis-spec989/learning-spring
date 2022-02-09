package denisspec.spring.dao;


import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.entity.Post;
import denisspec.spring.entity.Userm;
import denisspec.spring.service.UsermService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class UsermRepositoryTest {


    private final UsermService usermService;

    @Autowired
    public UsermRepositoryTest( UsermService usermService) {
        this.usermService = usermService;
    }

    @Test
    void create()
    {
        usermService.create("Marina57","1234567","Marina","Ignatova");
        assertEquals("Marina57", usermService.getById(3L).getUsername());
    }

    @Test
    void update()
    {
        usermService.updatePassword("Denisspec","DenisKrasavaR_");
        assertNotEquals("1234R", usermService.getById(1L).getPassword());
    }

    @Test
    void delete()
    {
        usermService.deleteUser("Denisspec");
        assertEquals(1,usermService.getAll().size());
    }








}
