package com.hieupd.springmvcjpa.service.impl;

import com.hieupd.springmvcjpa.dto.ClubDto;
import com.hieupd.springmvcjpa.models.Club;
import com.hieupd.springmvcjpa.repository.ClubRepository;
import com.hieupd.springmvcjpa.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<com.hieupd.springmvcjpa.dto.ClubDto> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public void save(Club club) {
        clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(Long id) {
        Club club = clubRepository.findById(id).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club clubOld = clubRepository.findById(clubDto.getId()).get();
        Club club = mapToClub(clubDto);
        club.setCreatedAt(clubOld.getCreatedAt());
        clubRepository.save(club);
    }

    private ClubDto mapToClubDto(Club club) {
        com.hieupd.springmvcjpa.dto.ClubDto clubDto = com.hieupd.springmvcjpa.dto.ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createdAt(club.getCreatedAt())
                .updatedAt(club.getUpdatedAt())
                .build();
        return clubDto;
    }

    private Club mapToClub(ClubDto clubDto) {
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
