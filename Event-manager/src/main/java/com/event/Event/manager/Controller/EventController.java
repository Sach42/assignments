package com.event.Event.manager.Controller;

import com.event.Event.manager.Model.Event;
import com.event.Event.manager.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public String addEvent(@Valid @RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/{id}")
    public String updateEvent(@PathVariable Long id, @Valid @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping
    public List<Event> getAllEventsByDate(@RequestParam LocalDate date) {
        return eventService.getAllEventsByDate(date);
    }
}

