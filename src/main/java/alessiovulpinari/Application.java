package alessiovulpinari;

import alessiovulpinari.dao.EventDao;
import alessiovulpinari.dao.InviteDao;
import alessiovulpinari.dao.LocationDao;
import alessiovulpinari.dao.PersonDao;
import alessiovulpinari.entities.Gender;
import alessiovulpinari.entities.Location;
import alessiovulpinari.entities.Person;
import alessiovulpinari.entities.events.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1-w3-d3-Java");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        PersonDao personDao = new PersonDao(em);
        LocationDao locationDao = new LocationDao(em);
        InviteDao inviteDao = new InviteDao(em);
        EventDao eventDao = new EventDao(em);


        Person davide = new Person(Gender.M, LocalDate.now(), "davideABBA@gmail.com,", "Abadessa", "Davide");
//        personDao.save(davide);

        Location arenaDiVerona = new Location("Arena di Verona", "Verona");
//        locationDao.save(arenaDiVerona);
        Location arenaDiVeronaDaDb = locationDao.getEventById(UUID.fromString("e8e16734-d5b4-4ac3-8b1d-0f65fe9e0df8"));

        Event luccaComixAndGames = new Event(arenaDiVeronaDaDb, "Lucca Comix and Games 2024", LocalDate.now(), "Bella fiera piena di belle persone in cosplay",
                EventTypes.PUBBLIC, 20000000);
        FootballMatch milanJuve = new FootballMatch(arenaDiVeronaDaDb, "Juve vs Milan", LocalDate.now(), "Ehohooo", EventTypes.PUBBLIC, 200000,
                "Milan", "Juventus", "Milan", 3, 1);

        Concert pippoBaudoInTour = new Concert(arenaDiVeronaDaDb, "pippo Baudo in Tour", LocalDate.now(), "Bel concerto",
                EventTypes.PUBBLIC, 200000, ConcertGenre.CLASSIC, false);

//        eventDao.save(pippoBaudoInTour);
        List<Concert> concertList = eventDao.getAllConcertsInStreaming(false);
        List<Concert> concertsForGenre = eventDao.getAllConcertForGenre(ConcertGenre.CLASSIC);
        concertsForGenre.forEach(System.out::println);

        
//        Event lucca = eventDao.getEventById(UUID.fromString("0148a7f3-8315-4a29-b990-094622adc674"));

//        Invite invite = new Invite(State.CONFIRMED, lucca, davideFromDb);
////        inviteDao.save(invite);
//        System.out.println(inviteDao.getEventById(UUID.fromString("7d347980-d3fc-4b9a-bdb8-b0cf4819f9b3")));
    }
}
