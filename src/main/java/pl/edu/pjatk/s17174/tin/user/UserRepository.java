package pl.edu.pjatk.s17174.tin.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //CREATE & UPDATE
    <S extends User> S save(S s);

    //READ & UPDATE
    Optional<User> getById(Integer id);

    List<User> findAll();

    //DELETE
    void delete(User user);
}
