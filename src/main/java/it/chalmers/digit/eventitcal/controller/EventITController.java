package it.chalmers.digit.eventitcal.controller;

import it.chalmers.digit.eventitcal.db.entity.Event;
import it.chalmers.digit.eventitcal.db.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.*;

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

    @GetMapping("/logintest")
    public String methodName(@RequestBody Map<String, String> body ) throws IOException {
        return checkIfLogin("placeHolderToken");
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

    private String checkIfLogin(String token) throws IOException {
        Map<String, String> request = new HashMap<>();
        URL url = new URL("http://localhost:3040/");
        HttpURLConnection con = null;
        con.setRequestMethod("GET");
        con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);


        /*BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();*/

        return con.getResponseMessage();
    }

    // private void notLoggedIn(){redirect gamma}

}
