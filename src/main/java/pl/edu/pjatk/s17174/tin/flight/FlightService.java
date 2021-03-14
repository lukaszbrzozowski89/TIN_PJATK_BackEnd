package pl.edu.pjatk.s17174.tin.flight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
class FlightService {
    private final Logger logger = LoggerFactory.getLogger(FlightService.class);
    private FlightRepository repository;

    @Autowired
    FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    List<Flight> findAll() {
        logger.info(String.valueOf(repository.findAll()));
        return new ArrayList<>(repository.findAll());
    }

    Optional<Flight> findById(Integer id) {
        logger.info(String.valueOf(repository.findById(id)));
        return repository.findById(id);
    }

    Optional<Flight> findByFlightNumberContains(String flightNumber) {
        logger.info(String.valueOf(repository.findByFlightNumberContains(flightNumber)));
        return repository.findByFlightNumberContains(flightNumber);
    }

    Flight save(Flight flight){
       return  repository.save(flight);
    }

    void deleteById(Integer id){
        repository.deleteById(id);
    }

}

