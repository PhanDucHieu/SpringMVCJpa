package com.hieupd.springmvcjpa.service;

import com.hieupd.springmvcjpa.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
}
