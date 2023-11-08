package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type General controller advice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handler bad request response entity.
   *
   * @param e the e
   * @return the response entity
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handlerBadRequest(RuntimeException e) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Coordenada inválida!");
  }

  /**
   * Handler not found response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handlerNotFound(MuseumNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Museu não encontrado!");
  }

  /**
   * Handle exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno!");
  }
}
