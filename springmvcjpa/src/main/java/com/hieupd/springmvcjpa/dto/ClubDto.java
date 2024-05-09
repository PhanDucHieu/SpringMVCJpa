package com.hieupd.springmvcjpa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Content link should not be empty")
    private String content;
    @NotEmpty(message = "Photo link should not be empty")
    private String photoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<EventDto> events;
}
