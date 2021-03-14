package pl.edu.pjatk.s17174.tin.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    //CREATE & UPDATE
    <S extends Reservation> S save(S s);

    //READ & UPDATE
    List<Reservation> findAll();
    Optional<Reservation> findById(Integer id);
    List<Reservation> findAllReservationByUser_Id(Integer id);

    List<Reservation> findAllReservationByFlight_Id(Integer id);

    List<Reservation> findAllByFlightAirportFromContains(String flight);

    List<Reservation> findAllByFlightAirportToContains (String flight);
    //DELETE
    void deleteById(Integer id);

}
