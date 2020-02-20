package it.chalmers.eventItCal.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.chalmers.eventItCal.db.entity.Event;
import it.chalmers.eventItCal.db.entity.EventFactory;

import java.util.Date;
import java.util.UUID;


public class EventParser {

    EventFactory eventFactory = new EventFactory();
    ObjectMapper objectMapper = new ObjectMapper();

    public EventParser() {
    }

    public UUID id;
    public String name;
    public Date createDate;
    public Date startTime;
    public Date endTime;
    public String description;
    public String organizer;
    public String contact;
    public String[] relevantGroups;

    public Event stringToEvent(String input) {
        for (int i = 0; i < input.length(); i++) {
            
        }

        return null;
    }
}
