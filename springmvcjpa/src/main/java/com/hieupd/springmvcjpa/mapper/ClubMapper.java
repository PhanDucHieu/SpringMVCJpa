package com.hieupd.springmvcjpa.mapper;

import com.hieupd.springmvcjpa.dto.ClubDto;
import com.hieupd.springmvcjpa.models.Club;

import java.util.stream.Collectors;

import static com.hieupd.springmvcjpa.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createdAt(club.getCreatedAt())
                .updatedAt(club.getUpdatedAt())
                .events(club.getEvents().stream().map(EventMapper::mapToEventDto).collect(Collectors.toList()))
                .build();
        return clubDto;
    }

    public static Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .content(clubDto.getContent())
                .photoUrl(clubDto.getPhotoUrl())
                .updatedAt(clubDto.getUpdatedAt())
                .build();
        return club;
    }
}
