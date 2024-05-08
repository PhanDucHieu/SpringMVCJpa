package com.hieupd.springmvcjpa.controller;

import com.hieupd.springmvcjpa.models.Event;
import com.hieupd.springmvcjpa.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events/{clubId}/new")
    public String createEvent(@PathVariable("clubId") Long id, Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("clubId", id);
        return "events-create";
    }
}
