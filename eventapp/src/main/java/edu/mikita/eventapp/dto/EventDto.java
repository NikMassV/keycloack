package edu.mikita.eventapp.dto;

public record EventDto(String uid, EventType type, Long createdAt, Long updatedAt, String description) {
}
