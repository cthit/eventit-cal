package it.chalmers.eventItCal.utils;

import it.chalmers.eventItCal.db.entity.Event;
import it.chalmers.eventItCal.db.entity.EventFactory;
import org.junit.Test;

import java.util.*;

public class IcalUtilTest {
    @Test
    public void getICalTest() {
        String name;
        Calendar javaCalendar;
        Date startTime;
        Date endTime;
        String description;
        String organizer;
        String contact;
        Event event;
        List<Event> events = new ArrayList<>();
        //Creates test event
        name = "EventIT release party";
        javaCalendar = new GregorianCalendar(2020, Calendar.APRIL, 20, 13, 37);
        startTime = javaCalendar.getTime();
        javaCalendar.set(2020, Calendar.APRIL, 20, 15, 0);
        endTime = javaCalendar.getTime();
        description = "The greatest event ever known to man";
        organizer = "digIT";
        contact = "Håll aka root";
        event = EventFactory.createEvent(name, startTime, endTime, description, organizer, contact);
        events.add(event);

        //Creates test event
        name = "Vem vet";
        javaCalendar = new GregorianCalendar(2019, Calendar.OCTOBER, 3, 23, 30);
        startTime = javaCalendar.getTime();
        javaCalendar.set(2019, Calendar.OCTOBER, 3, 23, 59);
        endTime = javaCalendar.getTime();
        description = "Ett spicey testevent";
        organizer = "HMK_Carl_Gustaf_XVI";
        contact = "Kontaktinfo";
        event = EventFactory.createEvent(name, startTime, endTime, description, organizer, contact);
        events.add(event);

        String iCalString = IcalUtil.getICal(events);
    }
}
