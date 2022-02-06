package denisspec.spring.dao;


import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.RoleRepository;
import denisspec.spring.entity.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class RoleRepositoryTest
{
    private final RoleRepository roleRepository;

    @Autowired
    public RoleRepositoryTest(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Test
    public void create()
    {
        Role role = new Role();
        role.setName("Moderator");
        roleRepository.save(role);
        assertEquals("Moderator",roleRepository.findById(4L).get().getName());
    }


}
