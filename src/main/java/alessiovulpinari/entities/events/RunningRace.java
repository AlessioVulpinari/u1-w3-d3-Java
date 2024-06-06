package alessiovulpinari.entities.events;

import alessiovulpinari.entities.Location;
import alessiovulpinari.entities.Person;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("Running_race")
public class RunningRace extends Event {

    @ManyToMany(mappedBy = "races")
    List<Person> athletes;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person winner;


    public RunningRace() {
    }

    public RunningRace(Location location, String title, LocalDate eventDate, String description, EventTypes eventType, int maxParticipants, Person winner) {
        super(location, title, eventDate, description, eventType, maxParticipants);
        this.winner = winner;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "RunningRace{" +
                ", eventType=" + eventType +
                ", event_id=" + event_id +
                "winner=" + winner +
                ", location=" + location +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
