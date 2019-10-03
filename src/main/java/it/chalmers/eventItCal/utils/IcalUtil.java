package it.chalmers.eventItCal.utils;

import it.chalmers.eventItCal.db.entity.Event;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class IcalUtil {
    public static String getICal(List<Event> events) {
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//EventIT//Event Calendar//SV"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);
        for (Event event : events) {
            VEvent vEvent = new VEvent(new DateTime(event.getStartTime()), new DateTime(event.getEndTime()), event.getName());
            vEvent.getProperties().add(new Uid(event.getId().toString()));
            vEvent.getProperties().add(new Description(event.getDescription()));
            vEvent.getProperties().add(new Created(new DateTime(event.getCreateDate())));
            try {
                vEvent.getProperties().add(new Organizer(event.getOrganizer()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            vEvent.getProperties().add(new Contact(event.getContact()));
            calendar.getComponents().add(vEvent);
        }
        return calendar.toString();
    }

    public static void toFile(FileOutputStream fout, Calendar calendar) {
        try {
            CalendarOutputter outputter = new CalendarOutputter();
            outputter.output(calendar, fout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
