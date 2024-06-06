package alessiovulpinari.entities.events;

import alessiovulpinari.entities.Location;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Concert")
public class Concert extends Event {

    @Enumerated(EnumType.STRING)
    private ConcertGenre genre;

    private boolean streaming;

    public Concert() {
    }

    public Concert(Location location, String title, LocalDate eventDate, String description, EventTypes eventType, int maxParticipants, ConcertGenre genre, boolean streaming) {
        super(location, title, eventDate, description, eventType, maxParticipants);
        this.genre = genre;
        this.streaming = streaming;
    }

    public ConcertGenre getGenre() {
        return genre;
    }

    public void setGenre(ConcertGenre genre) {
        this.genre = genre;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                ", event_id=" + event_id +
                "genre=" + genre +
                ", streaming=" + streaming +
                ", location=" + location +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
