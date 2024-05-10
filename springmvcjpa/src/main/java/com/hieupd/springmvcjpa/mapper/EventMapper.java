package com.hieupd.springmvcjpa.mapper;

import com.hieupd.springmvcjpa.dto.EventDto;
import com.hieupd.springmvcjpa.models.Event;

import static com.hieupd.springmvcjpa.mapper.ClubMapper.mapToClub;
import static com.hieupd.springmvcjpa.mapper.ClubMapper.mapToClubDto;

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
                .clubId(eventDto.getClubId())
                .build();
        return event;
    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .createAt(event.getCreateAt())
                .updateAt(event.getUpdateAt())
                .clubId(event.getClubId())
                .build();
    }
}
