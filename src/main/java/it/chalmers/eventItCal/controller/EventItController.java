package it.chalmers.eventItCal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.chalmers.eventItCal.db.entity.Event;
import it.chalmers.eventItCal.db.entity.EventFactory;
import it.chalmers.eventItCal.db.repository.EventService;
import it.chalmers.eventItCal.utils.EventParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;

@RestController
public class EventItController {

    @Autowired
    private EventService eventService;

    private EventParser eventParser = new EventParser();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void start() throws InterruptedException {

        //String name, Date startTime, Date endTime, String description, String organizer, String contact

        //eventService.saveEvent(EventFactory.createEvent("Noxs event", date, date, "My event", "Digit", "Aaron"));

    }

    @RequestMapping("/")
    public String index() {
        return "EventIT!";
    }

    @RequestMapping("/calendar")
    public String calendar() {
        return "This is a calendar";
    }

    @RequestMapping("/test")
    public Event testget() throws JsonProcessingException {
        return eventParser.stringToEvent(eventService.getAllEvents().get(0).toString());
    }

    @RequestMapping("/testadd")
    public String testadd() {
        EventFactory ef = new EventFactory();
        Event event = ef.createEvent("Test event", new Date(), new Date(), new Date(), "test desc", "digIT", "Nox", null);
        eventService.saveEvent(event);
        return "I think added";
    }

    @PostMapping("/testevents")
    public Event testevents(@RequestBody String test) {
        System.out.println("THIS IS TEST --- " + test);
        return eventService.getAllEvents().get(0);
    }

    private String iHateMyself() {
        String res = "";
        for (Event event : eventService.getAllEvents()) {
            res += event.toString();
        }
        return res;

    }

}

