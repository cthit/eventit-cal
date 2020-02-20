package it.chalmers.eventItCal.utils;

import it.chalmers.eventItCal.db.entity.Event;
import it.chalmers.eventItCal.db.entity.EventFactory;

import java.util.Date;
import java.util.UUID;

public class EventJSONClass {

    public EventFactory eventFactory = new EventFactory();

    public UUID id;
    public String name;
    public Date createDate;
    public Date startTime;
    public Date endTime;
    public String description;
    public String organizer;
    public String contact;
    public String[] relevantGroups;


    public EventJSONClass(UUID id, String name, Date createDate, Date startTime, Date endTime, String description, String organizer, String contact, String[] relevantGroups) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.organizer = organizer;
        this.contact = contact;
        this.relevantGroups = relevantGroups;
    }

    public Event thisToEvent(){
        return eventFactory.updateEventCreator(id, name, createDate, startTime, endTime, description, organizer, contact, relevantGroups);
    }
}
