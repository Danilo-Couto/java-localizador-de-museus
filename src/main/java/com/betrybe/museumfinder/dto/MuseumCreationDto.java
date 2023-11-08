package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * The type Museum creation dto.
 */
public record MuseumCreationDto(String name, String description, String address,
                                String collectionType, String subject, String url,
                                Coordinate coordinate) {

  /**
   * Instantiates a new Museum creation dto.
   *
   * @param name           the name
   * @param description    the description
   * @param address        the address
   * @param collectionType the collection type
   * @param subject        the subject
   * @param url            the url
   * @param coordinate     the coordinate
   */
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
