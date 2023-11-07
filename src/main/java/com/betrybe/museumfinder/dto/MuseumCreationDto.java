package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

public record MuseumCreationDto(String name, String description, String address, String collectionType, String subject, String url, Coordinate coordinate) {

  public MuseumCreationDto(String name, String description, String address, String collectionType,
      String subject, String url, Coordinate coordinate) {
    this.name = name;
    this.description = description;
    this.address = address;
    this.collectionType = collectionType;
    this.subject = subject;
    this.url = url;
    this.coordinate = coordinate;
  }
}
