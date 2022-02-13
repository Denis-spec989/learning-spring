package denisspec.spring.service;


import denisspec.spring.entity.Role;
import denisspec.spring.repository.RoleRepository;
import denisspec.spring.repository.UsermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService
{
private final RoleRepository roleRepository;
private final UsermRepository usermRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, UsermRepository usermRepository) {
        this.roleRepository = roleRepository;
        this.usermRepository = usermRepository;
    }

    public void create(String name)
    {
        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
    }
    public void delete(Long roleId)
    {
        roleRepository.deleteById(roleId);
    }
    public Role getByName(String name)
    {
        return roleRepository.findByName(name).get();
    }
    public Role getById(Long roleId)
    {
        return roleRepository.findById(roleId).get();
    }
    public List<Role> getAll()
    {
        return roleRepository.findAll();
    }
    public List<Role> getAllUsersRoles(String username)
    {
        return usermRepository.findByUsername(username).get().getRoles();
    }




}
