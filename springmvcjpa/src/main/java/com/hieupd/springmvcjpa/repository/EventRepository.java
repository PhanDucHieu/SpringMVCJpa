package com.hieupd.springmvcjpa.repository;

import com.hieupd.springmvcjpa.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
