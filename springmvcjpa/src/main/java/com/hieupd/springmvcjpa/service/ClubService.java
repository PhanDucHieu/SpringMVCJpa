package com.hieupd.springmvcjpa.service;

import com.hieupd.springmvcjpa.dto.ClubDto;
import com.hieupd.springmvcjpa.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> getAllClubs();
    void save(ClubDto clubDto);
    ClubDto findClubById(Long id);

    void updateClub(ClubDto clubDto);

    void deleteSingleClub(Long id);
    List<ClubDto> searchClub(String query);
}
