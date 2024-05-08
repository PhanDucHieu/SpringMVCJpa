package com.hieupd.springmvcjpa.service.impl;

import com.hieupd.springmvcjpa.dto.EventDto;
import com.hieupd.springmvcjpa.models.Club;
import com.hieupd.springmvcjpa.models.Event;
import com.hieupd.springmvcjpa.repository.ClubRepository;
import com.hieupd.springmvcjpa.repository.EventRepository;
import com.hieupd.springmvcjpa.service.EventService;
import org.springframework.stereotype.Service;

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
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClubId(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto) {
        Event event = Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .createAt(eventDto.getCreateAt())
                .updateAt(eventDto.getUpdateAt())
                .build();
        return event;
    }
}
