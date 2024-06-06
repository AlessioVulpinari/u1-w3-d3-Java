package alessiovulpinari.entities.events;

import alessiovulpinari.entities.Location;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Concert")
public class FootballMatch extends Event {
    private String homeTeam;
    private String visitingTeam;
    private String winingTea;
    private int homeTeamGoals;
    private int visitingTeamGoals;

    public FootballMatch() {
    }

    public FootballMatch(Location location, String title, LocalDate eventDate, String description, EventTypes eventType,
                         int maxParticipants, String homeTeam, String visitingTeam, String winingTea, int homeTeamGoals, int visitingTeamGoals) {
        super(location, title, eventDate, description, eventType, maxParticipants);
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.winingTea = winingTea;
        this.homeTeamGoals = homeTeamGoals;
        this.visitingTeamGoals = visitingTeamGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public String getWiningTea() {
        return winingTea;
    }

    public void setWiningTea(String winingTea) {
        this.winingTea = winingTea;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getVisitingTeamGoals() {
        return visitingTeamGoals;
    }

    public void setVisitingTeamGoals(int visitingTeamGoals) {
        this.visitingTeamGoals = visitingTeamGoals;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                ", eventType=" + eventType +
                ", event_id=" + event_id +
                "homeTeam='" + homeTeam + '\'' +
                ", visitingTeam='" + visitingTeam + '\'' +
                ", winingTea='" + winingTea + '\'' +
                ", homeTeamGoals=" + homeTeamGoals +
                ", visitingTeamGoals=" + visitingTeamGoals +
                ", location=" + location +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
