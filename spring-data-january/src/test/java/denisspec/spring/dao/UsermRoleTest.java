package denisspec.spring.dao;


import denisspec.spring.config.DataConfig;
import denisspec.spring.dao.repository.RoleRepository;
import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.entity.Role;
import denisspec.spring.entity.Userm;
import denisspec.spring.service.RoleService;
import denisspec.spring.service.UsermService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:schema.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class UsermRoleTest
{

    private final UsermService usermService;
    private final RoleService roleService;

    @Autowired
    public UsermRoleTest( UsermService usermService, RoleService roleService) {

        this.usermService = usermService;
        this.roleService = roleService;
    }
    @Test
    public void createUsermWithNewRole()
    {
        usermService.create("ProAngler","Proangler1234R","Maksim","Ivanov");
        roleService.create("Moderator");
        usermService.getByUsername("ProAngler").setRoles(List.of(roleService.getByName("Moderator")));
        assertEquals(Set.of("Moderator"),usermService.getByUsername("ProAngler").getRoles().stream().map(Role::getName).collect(Collectors.toSet()));

    }


}
