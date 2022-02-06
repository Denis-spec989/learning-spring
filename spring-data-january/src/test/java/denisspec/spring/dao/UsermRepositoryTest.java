package denisspec.spring.dao;


import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.entity.Userm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class UsermRepositoryTest {

    private final UsermRepository usermRepository;

    @Autowired
    public UsermRepositoryTest(UsermRepository usermRepository) {
        this.usermRepository = usermRepository;
    }

    @Test
    void create()
    {
        Userm userm = new Userm();
        userm.setUsername("Marina57");
        userm.setPassword("1234567");
        userm.setFirstName("Marina");
        userm.setLastName("Ignatova");
        userm.setD_created(LocalDateTime.now());
        userm.setActive(true);
        usermRepository.save(userm);
        assertEquals("Marina57", usermRepository.findById(3L).get().getUsername());
    }

    @Test
    void update()
    {
        Userm userm = usermRepository.findById(1L).get();
        userm.setPassword("DenisKrasavaR_");
        userm.setActive(false);
        usermRepository.save(userm);
        assertNotEquals("1234R", usermRepository.findById(1L).get().getPassword());
        assertEquals(false, usermRepository.findById(1L).get().isActive());
    }

    @Test
    void delete()
    {
        usermRepository.deleteById(1L);
        assertEquals(1,usermRepository.findAll().size());
    }






}
