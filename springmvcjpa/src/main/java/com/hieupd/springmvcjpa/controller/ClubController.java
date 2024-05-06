package com.hieupd.springmvcjpa.controller;

import com.hieupd.springmvcjpa.dto.ClubDto;
import com.hieupd.springmvcjpa.service.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubDtos = clubService.getAllClubs();
        model.addAttribute("clubDtos", clubDtos);
        return "clubs-list";
    };
}
