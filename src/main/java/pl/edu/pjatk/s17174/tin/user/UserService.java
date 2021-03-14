package pl.edu.pjatk.s17174.tin.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository repository;

    @Autowired
    UserService(UserRepository repository) {
        this.repository = repository;
    }

    List<User> findAll() {
        logger.info(String.valueOf(repository.findAll()));
        return new ArrayList<>(repository.findAll());
    }

    Optional<User> findById(Integer id) {
        logger.info(String.valueOf(repository.findById(id)));
        return repository.findById(id);
    }


    Optional<User> getById(Integer id) {
        logger.info(String.valueOf(repository.getById(id)));
        return repository.getById(id);
    }

    void deleteById(Integer id){
        repository.deleteById(id);
    }

    User save(User user){
        return  repository.save(user);
    }

}

