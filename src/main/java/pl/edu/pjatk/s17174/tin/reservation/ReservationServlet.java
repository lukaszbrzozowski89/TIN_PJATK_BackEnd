package pl.edu.pjatk.s17174.tin.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/api2")
class ReservationServlet {
    private final Logger logger = LoggerFactory.getLogger(ReservationServlet.class);

    private ReservationService service;

    ReservationServlet(ReservationService service) {
        this.service = service;
    }

    @GetMapping("/reservation")
    ResponseEntity<List<Reservation>> findAllReservations() {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/reservation/{id}")
    ResponseEntity<Reservation> findReservationById(@PathVariable Integer id) {
        logger.info("Got request");
        return ResponseEntity.ok(Optional.of(service.findById(id).orElse(new Reservation())).get());
    }

    @GetMapping("/reservation/user={id}")
    ResponseEntity<List<Reservation>> findAllReservationByUser_Id(@PathVariable Integer id) {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAllReservationByUser_Id(id));
    }

    @GetMapping("/reservation/flight={id}")
    ResponseEntity<List<Reservation>> findAllReservationByFlight_Id(@PathVariable Integer id) {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAllReservationByFlight_Id(id));
    }

    @GetMapping("/reservation/airportfrom={code}")
    ResponseEntity<List<Reservation>> findAllByFlightAirportFromContains(@PathVariable String code) {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAllByFlightAirportFromContains(code));
    }

    @GetMapping("/reservation/airportTo={code}")
    ResponseEntity<List<Reservation>> findAllByFlightAirportToContains(@PathVariable String code) {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAllByFlightAirportToContains(code));
    }

    @PostMapping
    ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(service.save(reservation));

    }

    @DeleteMapping("/reservation/id={id}")
    ResponseEntity<Reservation> deleteById(@PathVariable Integer id) {
        logger.info("Got request");
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reservation")
    ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation sf = service.save(reservation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/user/reservation/{id}")
                .buildAndExpand(sf.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/reservation/{id}")
    ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation, @PathVariable Integer id) {

        Optional<Reservation> optionalRes = service.findById(id);

        if (optionalRes.isEmpty()) return ResponseEntity.notFound().build();

        service.save(reservation);

        return ResponseEntity.ok(reservation);
    }
}
