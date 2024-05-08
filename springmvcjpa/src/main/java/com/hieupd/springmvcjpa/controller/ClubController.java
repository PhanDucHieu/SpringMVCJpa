package com.hieupd.springmvcjpa.controller;

import com.hieupd.springmvcjpa.dto.ClubDto;
import com.hieupd.springmvcjpa.models.Club;
import com.hieupd.springmvcjpa.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<com.hieupd.springmvcjpa.dto.ClubDto> clubDtos = clubService.getAllClubs();
        model.addAttribute("clubDtos", clubDtos);
        return "clubs-list";
    };

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") Long id, Model model){
        ClubDto clubDto = clubService.findClubById(id);
        model.addAttribute("clubDto", clubDto);
        return "club-detail";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long id){
        clubService.deleteSingleClub(id);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClubs(@RequestParam(value = "query") String query, Model model){
        List<ClubDto> clubDtos = clubService.searchClub(query);
        model.addAttribute("clubDtos", clubDtos);
        model.addAttribute("query", query);
        return "clubs-list";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "clubs-create";
        }
        clubService.save(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long id, Model model){
        ClubDto clubDto = clubService.findClubById(id);
        model.addAttribute("clubDto", clubDto);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long id,
                             @Valid @ModelAttribute("clubDto") ClubDto clubDto,
                             BindingResult result){
        if (result.hasErrors()) {
            return "clubs-edit";
        }
        clubDto.setId(id);
        clubService.updateClub(clubDto);
        return "redirect:/clubs";
    }

 }
