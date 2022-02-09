package denisspec.spring.service;


import denisspec.spring.dao.repository.UsermRepository;
import denisspec.spring.entity.Post;
import denisspec.spring.entity.Userm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsermService {
private final UsermRepository usermRepository;

    @Autowired
    public UsermService(UsermRepository usermRepository) {
        this.usermRepository = usermRepository;
    }

    public void create(String username,String password, String firstName, String lastName)
    {
        Userm userm = new Userm();
        userm.setUsername(username);
        userm.setPassword(password);
        userm.setFirstName(firstName);
        userm.setLastName(lastName);
        userm.setD_created(LocalDateTime.now());
        userm.setActive(true);
        usermRepository.save(userm);

    }
    public void updateUsername(String usernameBefore,String usernameNew)
    {
        Userm userm = usermRepository.findByUsername(usernameBefore).get();
        userm.setUsername(usernameNew);
        usermRepository.save(userm);
    }
    public void updatePassword(String username,String password)
    {
        Userm userm = usermRepository.findByUsername(username).get();
        userm.setPassword(password);
        usermRepository.save(userm);
    }
    public void updateDates(String username,String firstNameNew, String lastNameNew)
    {
        Userm userm = usermRepository.findByUsername(username).get();
        userm.setFirstName(firstNameNew);
        userm.setLastName(lastNameNew);
    }
    public void deleteUser(String username)
    {
        Userm userm = usermRepository.findByUsername(username).get();
        usermRepository.delete(userm);
    }
    public Userm getByUsername(String username)
    {
        return usermRepository.findByUsername(username).get();
    }
    public Userm getById(Long usermId)
    {
        return usermRepository.findById(usermId).get();
    }
    public List<Userm> getAll()
    {
        return usermRepository.findAll();
    }



}
