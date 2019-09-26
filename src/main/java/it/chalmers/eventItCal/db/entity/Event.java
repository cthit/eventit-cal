package it.chalmers.eventItCal.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(updatable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "description")
    private String description;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "contact")
    private String contact;

    @Column(name = "relevant_groups")
    private String[] relevantGroups;

    protected Event() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return this.organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String[] getRelevantGroups() {
        return this.relevantGroups;
    }

    public void setRelevantGroups(String[] relevantGroups) {
        this.relevantGroups = relevantGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event that = (Event) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.date, that.date)
                && Objects.equals(this.startTime, that.startTime)
                && Objects.equals(this.endTime, that.endTime)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.organizer, that.organizer)
                && Objects.equals(this.contact, that.contact)
                && Arrays.equals(this.relevantGroups, that.relevantGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.date, this.startTime, this.endTime, this.description, this.organizer, this.contact, this.relevantGroups);
    }

    @Override
    public String toString() {
        return "Event{"
                + "id=" + this.id
                + ", name=" + this.name
                + ", date=" + this.date
                + ", startTime=" + this.startTime
                + ", endTime=" + this.endTime
                + ", description=" + this.description
                + ", organizer=" + this.organizer
                + ", contact=" + this.contact
                + ", relevantGroups=" + Arrays.toString(this.relevantGroups)
                + "}";

    }
}
