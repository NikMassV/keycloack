package edu.mikita.eventapp.rest;

import edu.mikita.eventapp.dto.EventDto;
import edu.mikita.eventapp.dto.EventPageDto;
import edu.mikita.eventapp.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/events")
public class EventRestControllerV1 {

    private final EventService eventService;

    @GetMapping
    public EventPageDto getEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return eventService.getEvents(page, size);
    }

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto dto) {
        return eventService.save(dto);
    }
}
