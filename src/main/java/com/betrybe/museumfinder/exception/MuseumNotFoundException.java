package com.betrybe.museumfinder.exception;

public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException(String message) {
    super(message);
  }
}