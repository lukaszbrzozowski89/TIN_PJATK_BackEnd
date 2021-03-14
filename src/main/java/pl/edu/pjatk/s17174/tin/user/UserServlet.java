package pl.edu.pjatk.s17174.tin.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/")
class UserServlet {
    private final Logger logger = LoggerFactory.getLogger(UserServlet.class);

    private UserService service;

    UserServlet(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    ResponseEntity<List<User>> findAll() {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/user/{id}")
    ResponseEntity<User> findById(@PathVariable Integer id) {
        logger.info("Got request");
        return ResponseEntity.ok(Optional.of(service.findById(id).orElse(new User())).get());
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<User> deleteById(@PathVariable Integer id) {
        logger.info("Got request");
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/user")
    ResponseEntity<User> createUser(@RequestBody User user) {
        User as = service.save(user);
        return ResponseEntity.ok(as);
    }

    @PostMapping("/user/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {

        Optional<User> userOptional = service.getById(id);

        if (userOptional.isEmpty()) return ResponseEntity.notFound().build();

        userOptional.get().setAdmin(user.isAdmin());
        userOptional.get().setFirstName(user.getFirstName());
        userOptional.get().setLastName(user.getLastName());

        service.save(user);

        return ResponseEntity.ok(user);
    }
}
