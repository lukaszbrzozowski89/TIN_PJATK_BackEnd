package pl.edu.pjatk.s17174.tin.flight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/api")
class FlightServlet {
    private final Logger logger = LoggerFactory.getLogger(FlightServlet.class);

    private FlightService service;

    FlightServlet(FlightService service) {
        this.service = service;
    }

    @GetMapping("/flights")
    ResponseEntity<List<Flight>> findAllFlights() {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/flights/{id}")
    ResponseEntity<Flight> findFlightById(@PathVariable Integer id) {
        logger.info("Got request");
        return ResponseEntity.ok(Optional.of(service.findById(id).orElse(new Flight())).get());
    }

    @PostMapping
    ResponseEntity<Flight> save(@RequestBody Flight flight) {
        return ResponseEntity.ok(service.save(flight));

    }

    @DeleteMapping("/flights/{id}")
    ResponseEntity<Flight> deleteById(@PathVariable Integer id) {
        logger.info("Got request");
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/flights/-1")
    ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        if (flight.getId() == -1) {
            flight.setId(service.findAll().get(service.findAll().size() - 1).getId() + 1);
        }
        Flight sf = service.save(flight);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/api/flights/{id}")
                .buildAndExpand(sf.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/flights/{id}")
    ResponseEntity<Flight> updateFlight(@RequestBody Flight flight, @PathVariable Integer id) {

        Optional<Flight> optionalFlight = service.findById(id);

        if (optionalFlight.isEmpty()) return ResponseEntity.notFound().build();

        service.save(flight);

        return ResponseEntity.ok(flight);
    }
}
