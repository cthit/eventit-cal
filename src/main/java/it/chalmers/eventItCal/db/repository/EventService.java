package it.chalmers.eventItCal.db.repository;

import it.chalmers.eventItCal.db.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EventService {

    @Autowired
    EventRepository eventRepository;


    public List<Event> getAllEvents(){
       return eventRepository.findAll();
    }

    public Event getEvent(UUID id){
        return eventRepository.getOne(id);
    }

    public void deleteEvent(UUID id){
        eventRepository.delete(getEvent(id));
    }

    public void deleteEvent(Event e){
        eventRepository.delete(e);
    }

    public void updateEvent(Event e){
        eventRepository.save(e);
    }

    public void saveEvent(Event e){
        eventRepository.save(e);
    }

    public void saveEvents(List<Event> events){
        eventRepository.saveAll(events);
    }
}
