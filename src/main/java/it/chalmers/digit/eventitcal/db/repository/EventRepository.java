package it.chalmers.digit.eventitcal.db.repository;

import it.chalmers.digit.eventitcal.db.entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByDescription(String description);
}
