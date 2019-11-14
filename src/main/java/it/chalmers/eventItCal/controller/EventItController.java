package it.chalmers.eventItCal.controller;

import it.chalmers.eventItCal.db.entity.Event;
import it.chalmers.eventItCal.db.entity.EventFactory;
import it.chalmers.eventItCal.db.repository.EventService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

@RestController
public class EventItController {

    private EventService eventService;


    @PostConstruct
    public void start(){

        //String name, Date startTime, Date endTime, String description, String organizer, String contact
        eventService = new EventService();
        Date date = new Date();

        eventService.saveEvent(EventFactory.createEvent("Noxs event", date, date, "My event", "Digit", "Aaron"));

    }

    @RequestMapping("/")
    public String index()
    {
        return "EventIT!";
    }

    @RequestMapping("/calendar")
    public String calendar(){return "This is a calendar";}

    @RequestMapping("/test")
    public String test(){return iHateMyself(); }

    private String iHateMyself(){
        String res = "";
        for (Event event : eventService.getAllEvents()){
           res += event.toString();
        }
        return res;

    }

}

