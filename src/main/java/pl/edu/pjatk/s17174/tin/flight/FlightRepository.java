package pl.edu.pjatk.s17174.tin.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    //CREATE & UPDATE
    <S extends Flight> S save(S s);

    //READ & UPDATE
    List<Flight> findAll();
    Optional<Flight> findById(Integer id);
    Optional<Flight> findByFlightNumberContains(String flightNumber);



    //DELETE
    void deleteById(Integer id);

}
