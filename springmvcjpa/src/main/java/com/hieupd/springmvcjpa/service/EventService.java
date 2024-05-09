package com.hieupd.springmvcjpa.service;

import com.hieupd.springmvcjpa.dto.EventDto;
import com.hieupd.springmvcjpa.models.Event;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> getAllEvents();

    EventDto findEventById(Long id);

    void updateEvent(EventDto eventDto);
}
