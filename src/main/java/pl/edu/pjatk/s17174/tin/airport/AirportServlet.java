//package pl.edu.pjatk.s17174.tin.airport;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//class AirportServlet {
//    private final Logger logger = LoggerFactory.getLogger(AirportServlet.class);
//
//    private AirportService service;
//
//    AirportServlet(AirportService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/airports")
//    ResponseEntity<List<Airport>> findAll() {
//        logger.info("Got request");
//        return ResponseEntity.ok(service.findAll());
//    }
//
//    @GetMapping("/airports/id={id}")
//    ResponseEntity<Airport> findById(@PathVariable Integer id) {
//        logger.info("Got request");
//        return ResponseEntity.ok(Optional.of(service.findById(id).orElse(new Airport())).get());
//    }
//
//    @GetMapping("/airports/code={code}")
//    ResponseEntity<Airport> getByCode(@PathVariable String code) {
//        logger.info("Got request");
//        return ResponseEntity.ok(Optional.of(service.getByCode(code).orElse(new Airport())).get());
//    }
//
//    @DeleteMapping("/airports/id={id}")
//    ResponseEntity<Airport> deleteById(@PathVariable Integer id) {
//        logger.info("Got request");
//        service.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping("/airports")
//    ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
//        Airport as = service.save(airport);
//        return ResponseEntity.ok(as);
//    }
//
//    @PostMapping("/airports/id={id}")
//    ResponseEntity<Airport> updateAirport(@RequestBody Airport airport, @PathVariable Integer id) {
//
//        Optional<Airport> optionalAirportCode = service.getById(id);
//
//        if (optionalAirportCode.isEmpty()) return ResponseEntity.notFound().build();
//
//        optionalAirportCode.get().setCode(airport.getCode());
//        optionalAirportCode.get().setAirportName(airport.getAirportName());
//
//        service.save(airport);
//
//        return ResponseEntity.ok(airport);
//    }
//}
