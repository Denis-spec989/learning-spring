package denisspec.spring.service;

import denisspec.spring.entity.Userm;
import denisspec.spring.repository.UsermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsermService {

    private final UsermRepository usermRepository;
    @Autowired
    public UsermService(UsermRepository usermRepository) {
        this.usermRepository = usermRepository;
    }

    public Userm findByUsername(String username)
    {
        Userm userm =usermRepository.findByUsername(username).orElseThrow();
        userm.getPosts().size();

        return userm;
    }

}
