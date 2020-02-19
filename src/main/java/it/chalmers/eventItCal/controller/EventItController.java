package it.chalmers.eventItCal.controller;

import it.chalmers.eventItCal.db.entity.Event;
import it.chalmers.eventItCal.db.entity.EventFactory;
import it.chalmers.eventItCal.db.repository.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

@RestController
public class EventItController {

    @Autowired
    private EventService eventService;

    @PostConstruct
    public void start() throws InterruptedException {

        //String name, Date startTime, Date endTime, String description, String organizer, String contact

        Date date = new Date();


        //eventService.saveEvent(EventFactory.createEvent("Noxs event", date, date, "My event", "Digit", "Aaron"));

    }

    @RequestMapping("/")
    public String index()
    {
        return "EventIT!";
    }

    @RequestMapping("/calendar")
    public String calendar(){return "This is a calendar";}

    @RequestMapping("/testget")
    public String testget(){return iHateMyself(); }

    @RequestMapping("/testadd")
    public String testadd(){
        EventFactory ef = new EventFactory();
        Event event = ef.createEvent("Test event", new Date(), new Date(), "test desc", "digIT", "Nox");
        eventService.saveEvent(event);
        return  "I think added";
    }

    private String iHateMyself(){
        String res = "";
        for (Event event : eventService.getAllEvents()){
           res += event.toString();
        }
        return res;

    }

}

