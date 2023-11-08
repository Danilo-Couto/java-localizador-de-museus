package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Museum not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MuseumNotFoundException extends RuntimeException {

}