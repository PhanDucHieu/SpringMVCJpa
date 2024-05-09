package com.hieupd.springmvcjpa.service.impl;

import com.hieupd.springmvcjpa.dto.EventDto;
import com.hieupd.springmvcjpa.models.Club;
import com.hieupd.springmvcjpa.models.Event;
import com.hieupd.springmvcjpa.repository.ClubRepository;
import com.hieupd.springmvcjpa.repository.EventRepository;
import com.hieupd.springmvcjpa.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.hieupd.springmvcjpa.mapper.EventMapper.mapToEvent;
import static com.hieupd.springmvcjpa.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).orElse(null);
        Event event = mapToEvent(eventDto);
        event.setClubId(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findEventById(Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event eventOld = eventRepository.findById(eventDto.getId()).orElse(null);
        Event event = mapToEvent(eventDto);
        event.setCreateAt(eventOld.getCreateAt());
        eventRepository.save(event);
    }
}
