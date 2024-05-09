package com.hieupd.springmvcjpa.mapper;

import com.hieupd.springmvcjpa.dto.EventDto;
import com.hieupd.springmvcjpa.models.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto) {
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

    public static EventDto mapToEventDto(Event event) {
        EventDto eventDto = EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .createAt(event.getCreateAt())
                .updateAt(event.getUpdateAt())
                .build();
        return eventDto;
    }
}
