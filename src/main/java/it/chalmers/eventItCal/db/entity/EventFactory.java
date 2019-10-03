package it.chalmers.eventItCal.db.entity;

import java.util.Date;

public class EventFactory {
    public static Event createEvent(String name, Date startTime, Date endTime, String description, String organizer, String contact) {
        Event event = new Event();
        event.setName(name);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setDescription(description);
        event.setOrganizer(organizer);
        event.setContact(contact);
        event.setCreateDate(new Date());
        return event;
    }
}
