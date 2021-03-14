//package pl.edu.pjatk.s17174.tin.airport;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pl.edu.pjatk.s17174.tin.flight.Flight;
//import pl.edu.pjatk.s17174.tin.flight.FlightRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//class AirportService {
//    private final Logger logger = LoggerFactory.getLogger(AirportService.class);
//    private AirportRepository repository;
//
//    @Autowired
//    AirportService(AirportRepository repository) {
//        this.repository = repository;
//    }
//
//    List<Airport> findAll() {
//        logger.info(String.valueOf(repository.findAll()));
//        return new ArrayList<>(repository.findAll());
//    }
//
//    Optional<Airport> findById(Integer id) {
//        logger.info(String.valueOf(repository.findById(id)));
//        return repository.findById(id);
//    }
//
//    Optional<Airport> getByCode(String code) {
//        logger.info(String.valueOf(repository.getByCode(code)));
//        return repository.getByCode(code);
//    }
//
//    Optional<Airport> getByAirportName(String name) {
//        logger.info(String.valueOf(repository.getByAirportName(name)));
//        return repository.getByAirportName(name);
//    }
//
//    Optional<Airport> getById(Integer id) {
//        logger.info(String.valueOf(repository.getById(id)));
//        return repository.getById(id);
//    }
//
//    void deleteById(Integer id){
//        repository.deleteById(id);
//    }
//
//    Airport save(Airport flight){
//        return  repository.save(flight);
//    }
//
//}
//
