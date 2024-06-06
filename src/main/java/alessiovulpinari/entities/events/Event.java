package alessiovulpinari.entities.events;

import alessiovulpinari.entities.Invite;
import alessiovulpinari.entities.Location;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Event")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_evento")
public class Event {
    @Id
    @GeneratedValue
    protected UUID event_id;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    protected Location location;

    @OneToMany(mappedBy = "event")
    protected List<Invite> inviteList;

    @Column(name = "Title")
    protected String title;

    @Column(name = "eventDate")
    protected LocalDate eventDate;

    @Column(name = "Description")
    protected String description;

    @Column(name = "eventType")
    @Enumerated(EnumType.STRING)
    protected EventTypes eventType;

    @Column(name = "maxParticipants")
    protected int maxParticipants;

    public Event() {
    }

    public Event(Location location, String title, LocalDate eventDate, String description, EventTypes eventType, int maxParticipants) {
        this.location = location;
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
    }

    public UUID getEvent_id() {
        return event_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventTypes getEventType() {
        return eventType;
    }

    public void setEventType(EventTypes eventType) {
        this.eventType = eventType;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "event_id=" + event_id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
