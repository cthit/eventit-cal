package it.chalmers.eventItCal.db.repository;

import it.chalmers.eventItCal.db.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
