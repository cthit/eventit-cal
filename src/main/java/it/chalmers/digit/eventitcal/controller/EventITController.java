package it.chalmers.digit.eventitcal.controller;

import it.chalmers.digit.eventitcal.db.entity.Event;
import it.chalmers.digit.eventitcal.db.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventITController {
    @Autowired
    EventRepository eventRepository;

    @CrossOrigin(origins = "http://localhost:4000")  /// To deal with CORS
    @RequestMapping("/")
    public String index()
    {
        return "EventIT!";
    }

    @RequestMapping("/index")
    public String yeet(){return eventRepository.findAll().toString();}

    @RequestMapping("/add")
    public String add(){
        Event event = new Event("Cool event");
        eventRepository.save(event);
        return "Added";
    }

    @RequestMapping("/test")
    public String test(){return eventRepository.findAll().toString();}


}
