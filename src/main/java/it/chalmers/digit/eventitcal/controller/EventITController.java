package it.chalmers.digit.eventitcal.controller;

import it.chalmers.digit.eventitcal.db.entity.Event;
import it.chalmers.digit.eventitcal.db.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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
        Instant sDate = new GregorianCalendar(2019, 11, 25, 11, 45).toInstant();
        Instant eDate = new GregorianCalendar(2019, 11, 26, 11, 45).toInstant();
        String revGroups = "digIT, P.R.I.T.";
        Event event = new Event("EventIT Release", sDate, eDate, "Cool event", "digIT", "Nox",revGroups, "EG" );
       eventRepository.save(event);
        return "Added";
    }

    @RequestMapping("/test")
    public String test(){
        StringBuilder sb = new StringBuilder();
        for (Event e : eventRepository.findAll()) {
            sb.append(e.toString());
        }
        return sb.toString();
    }

    @RequestMapping("/posttest/{obj}")
    public String post( @PathVariable("obj") String obj) throws JSONException {

        return obj;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String update(@RequestBody Event event) {

        String lul = "Name: ";
        if (event != null) {
           lul += event.getName();
        }

        // TODO: call persistence layer to update
        //return new ResponseEntity<Event>(event, HttpStatus.OK);
        return lul;
    }


}
