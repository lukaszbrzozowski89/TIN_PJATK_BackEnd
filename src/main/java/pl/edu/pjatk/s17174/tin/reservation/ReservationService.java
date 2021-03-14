package pl.edu.pjatk.s17174.tin.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class ReservationService {
    private final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    private ReservationRepository repository;

    @Autowired
    ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    List<Reservation> findAll() {
        logger.info(String.valueOf(repository.findAll()));
        return new ArrayList<>(repository.findAll());
    }

    Optional<Reservation> findById(Integer id) {
        logger.info(String.valueOf(repository.findById(id)));
        return repository.findById(id);
    }

    Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    void deleteById(Integer id) {
        repository.deleteById(id);
    }

    List<Reservation> findAllReservationByUser_Id(Integer id) {
        logger.info(String.valueOf(repository.findAllReservationByUser_Id(id)));
        return repository.findAllReservationByUser_Id(id);
    }

    List<Reservation> findAllReservationByFlight_Id(Integer id) {
        logger.info(String.valueOf(repository.findAllReservationByFlight_Id(id)));
        return repository.findAllReservationByFlight_Id(id);
    }

    List<Reservation> findAllByFlightAirportFromContains(String code) {
        logger.info(String.valueOf(repository.findAllByFlightAirportFromContains(code)));
        return repository.findAllByFlightAirportFromContains(code);
    }

    List<Reservation> findAllByFlightAirportToContains(String code) {
        logger.info(String.valueOf(repository.findAllByFlightAirportToContains(code)));
        return repository.findAllByFlightAirportToContains(code);
    }
}


