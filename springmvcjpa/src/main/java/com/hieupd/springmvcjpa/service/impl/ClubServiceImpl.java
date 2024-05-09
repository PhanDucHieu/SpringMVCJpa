package com.hieupd.springmvcjpa.service.impl;

import com.hieupd.springmvcjpa.dto.ClubDto;
import com.hieupd.springmvcjpa.mapper.ClubMapper;
import com.hieupd.springmvcjpa.models.Club;
import com.hieupd.springmvcjpa.repository.ClubRepository;
import com.hieupd.springmvcjpa.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.hieupd.springmvcjpa.mapper.ClubMapper.mapToClub;
import static com.hieupd.springmvcjpa.mapper.ClubMapper.mapToClubDto;

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
    public void save(ClubDto clubDto) {
        clubRepository.save(mapToClub(clubDto));
    }

    @Override
    public ClubDto findClubById(Long id) {
        Club club = clubRepository.findById(id).orElse(null);
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club clubOld = clubRepository.findById(clubDto.getId()).orElse(null);
        Club club = mapToClub(clubDto);
        club.setCreatedAt(clubOld.getCreatedAt());
        clubRepository.save(club);
    }

    @Override
    public void deleteSingleClub(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<ClubDto> searchClub(String query) {
        List<Club> clubs = clubRepository.searchClub(query);
        return clubs.stream().map(ClubMapper::mapToClubDto).collect(Collectors.toList());
//        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

}
