package com.hieupd.springmvcjpa.controller;

import com.hieupd.springmvcjpa.dto.EventDto;
import com.hieupd.springmvcjpa.models.Event;
import com.hieupd.springmvcjpa.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        List<EventDto> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("/events/{clubId}/new")
    public String createEvent(@PathVariable("clubId") Long id, Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("clubId", id);
        return "events-create";
    }

    @GetMapping("/events/{eventId}")
    public String eventDetail(@PathVariable("eventId") Long id, Model model){
        EventDto eventDto = eventService.findEventById(id);
        model.addAttribute("eventDto", eventDto);
        return "events-detail";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long id, Model model){
        EventDto eventDto = eventService.findEventById(id);
        model.addAttribute("eventDto", eventDto);
        return "events-edit";
    }

    @GetMapping("events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long id){
        eventService.deleteEvent(id);
        return "redirect:/events";
    }

    @PostMapping("events/{clubId}/new")
    public String saveEvent(@ModelAttribute("event") EventDto eventDto,
                            @PathVariable("clubId") Long id) {
        eventService.createEvent(id,eventDto);
        return "redirect:/clubs/" + id;
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long id,
                              @ModelAttribute("event") EventDto eventDto,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "events-edit";
        }
        eventDto.setId(id);
        eventDto.setClubId(eventService.findEventById(id).getClubId());
        eventService.updateEvent(eventDto);
        return "redirect:/events";
    }
}
