package it.chalmers.eventItCal.db.repository;

import it.chalmers.eventItCal.db.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IEventRepository extends JpaRepository<Event, UUID> {
    @Override
    List<Event> findAll();

    @Override
    Event getOne(UUID uuid);

    @Override
    void delete(Event event);

    @Override
    <S extends Event> S save(S s);

    @Override
    <S extends Event> List<S> saveAll(Iterable<S> iterable);
}
