package com.event.Event.manager.Repository;


import com.event.Event.manager.Model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByDate(LocalDate date);
}

