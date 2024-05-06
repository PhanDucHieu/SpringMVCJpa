package com.hieupd.springmvcjpa.service;

import com.hieupd.springmvcjpa.dto.ClubDto;
import com.hieupd.springmvcjpa.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> getAllClubs();
}
