package denisspec.spring.dao;


import denisspec.spring.config.DataConfig;
import denisspec.spring.service.RoleService;
import org.checkerframework.checker.units.qual.A;
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
    private final RoleService roleService;
    @Autowired
    public RoleRepositoryTest(RoleService roleService) {
        this.roleService = roleService;
    }

    @Test
    public void create()
    {
        roleService.create("Moderator");
        assertEquals("Moderator",roleService.getById(4L).getName());
    }


}
