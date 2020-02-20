package it.chalmers.eventItCal.db.entity;

import java.util.Date;
import java.util.UUID;

public class EventFactory {
    public Event createEvent(String name, Date createTime,Date startTime, Date endTime, String description, String organizer, String contact, String[] relevantGroups) {
        Event event = new Event();
        event.setName(name);
        event.setCreateDate(createTime);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setDescription(description);
        event.setOrganizer(organizer);
        event.setContact(contact);
        event.setCreateDate(new Date());
        event.setRelevantGroups(relevantGroups);
        return event;
    }

    public Event updateEventCreator(UUID id, String name, Date createTime ,Date startTime, Date endTime, String description, String organizer, String contact, String[] relevantGroups) {
        Event event = new Event();

        event.setName(name);
        event.setCreateDate(createTime);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setDescription(description);
        event.setOrganizer(organizer);
        event.setContact(contact);
        event.setCreateDate(new Date());
        event.setRelevantGroups(relevantGroups);
        return event;
    }
}
