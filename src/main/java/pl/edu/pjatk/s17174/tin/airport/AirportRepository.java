//package pl.edu.pjatk.s17174.tin.airport;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface AirportRepository extends JpaRepository<Airport, Integer> {
//
//    //CREATE & UPDATE
//    <S extends Airport> S save(S s);
//
//    //READ & UPDATE
//    Optional<Airport> getByCode(String code);
//    Optional<Airport> getByAirportName(String name);
//    Optional<Airport> getById(Integer id);
//    List<Airport> findAll();
//
//    //DELETE
//    void delete(Airport airport);
//}
