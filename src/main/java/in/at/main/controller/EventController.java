package in.at.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.at.main.entity.Event;
import in.at.main.repository.EventFetchRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventFetchRepository eventRepo;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
