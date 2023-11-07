package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface museumServiceInterface;

  @Autowired
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  private Museum createMuseum(MuseumCreationDto newMuseum) {
    Museum museum = new Museum();

    museum.setName(newMuseum.name());
    museum.setAddress(newMuseum.address());
    museum.setDescription(newMuseum.description());
    museum.setCollectionType(newMuseum.collectionType());
    museum.setSubject(newMuseum.subject());
    museum.setUrl(newMuseum.url());
    museum.setCoordinate(newMuseum.coordinate());

    return museum;
  }

  @PostMapping
  public ResponseEntity<MuseumCreationDto> newMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum museum = createMuseum(newMuseum);

    museumServiceInterface.createMuseum(museum);

    MuseumCreationDto museumCreationDto = new MuseumCreationDto(
        museum.getName(),
        museum.getDescription(),
        museum.getAddress(),
        museum.getCollectionType(),
        museum.getSubject(),
        museum.getUrl(),
        museum.getCoordinate());

    return ResponseEntity.status(HttpStatus.CREATED).body(museumCreationDto);
  }

  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam(name = "lat") Double lat,
      @RequestParam(name = "lng") Double lgn,
      @RequestParam(name = "max_dist_km") Double maxDistance){

    Coordinate coordinate = new Coordinate(lat, lgn);

    Museum museum = museumServiceInterface.getClosestMuseum(coordinate, maxDistance);

    MuseumDto museumDto = new MuseumDto(
        museum.getId(),
        museum.getName(),
        museum.getDescription(),
        museum.getAddress(),
        museum.getCollectionType(),
        museum.getSubject(),
        museum.getUrl(),
        museum.getCoordinate());

    return ResponseEntity.ok(museumDto);
  }
}
