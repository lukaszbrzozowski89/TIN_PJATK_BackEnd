//package pl.edu.pjatk.s17174.tin.airport;
//
//import org.hibernate.annotations.GenericGenerator;
//import pl.edu.pjatk.s17174.tin.flight.Flight;
//import java.util.*;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "airport")
//public class Airport {
//    @Id
//    @GeneratedValue(generator = "inc")
//    @GenericGenerator(name = "inc", strategy = "increment")
//    private Integer id;
//
//    private String airportName;
//    private String code;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "airportToId")
//    private List<Flight> flightsTo;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "airportFromId")
//    private List<Flight> flightsFrom;
//
//    public Airport() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getAirportName() {
//        return airportName;
//    }
//
//    public void setAirportName(String airportName) {
//        this.airportName = airportName;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    List<Flight> getFlightsTo() {
//        return flightsTo;
//    }
//
//    List<Flight> getFlightsFrom() {
//        return flightsFrom;
//    }
//
//}
//
