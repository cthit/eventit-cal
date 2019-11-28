package it.chalmers.digit.eventitcal.db.entity;

import org.apache.tomcat.jni.Time;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(updatable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "description")
    private String description;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "contact")
    private String contact;

    @Column(name = "relevant_groups")
    private String relevantGroups;

    @Column(name = "event_owner")
    private String owner;

    protected Event(){
    }

    public Event(String name,  Instant startTime, Instant endTime, String description, String organizer, String contact, String relevantGroups, String owner) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.createDate = Timestamp.from(Instant.now());
        this.startTime = Timestamp.from(startTime);
        this.endTime = Timestamp.from(endTime);
        this.description = description;
        this.organizer = organizer;
        this.contact = contact;
        this.relevantGroups = relevantGroups;
        this.owner = owner;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Instant date) {
        this.createDate = Timestamp.from(date);
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = Timestamp.from(startTime);
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = Timestamp.from(endTime);
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

    public String getRelevantGroups() {
        return this.relevantGroups;
    }

    public String getOwner() { return owner;}

    public void setOwner(String owner) {this.owner = owner;}

    public void setRelevantGroups(String relevantGroups) {
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
                && Objects.equals(this.createDate, that.createDate)
                && Objects.equals(this.startTime, that.startTime)
                && Objects.equals(this.endTime, that.endTime)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.organizer, that.organizer)
                && Objects.equals(this.contact, that.contact)
                && Objects.equals(this.relevantGroups, that.relevantGroups)
                && Objects.equals(this.owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.createDate, this.startTime, this.endTime, this.description, this.organizer, this.contact, this.relevantGroups);
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\" :\"" + this.id
                + "\", \"name\" : \"" + this.name
                + "\", \"date\" : \"" + this.createDate.toString()
                + "\", \"startTime\" : \"" + this.startTime.toString()
                + "\", \"endTime\" : \"" + this.endTime.toString()
                + "\", \"description\" : \"" + this.description
                + "\", \"organizer\" : \"" + this.organizer
                + "\", \"contact\" : \"" + this.contact
                + "\", \"relevantGroups\" : " + this.relevantGroups
                + "\", \"owner\" : \"" + this.owner
                + "\"}";
    }

    private String relevantGroupsToString(String[] s) {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int i = 0; i < s.length - 1; i++) {
            out.append("\"" + s[i] + "\", ");
        }
        out.append("\"").append(s[s.length - 2]).append("\" ");
        out.append("]");
        return out.toString();
    }
}
