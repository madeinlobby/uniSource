package com.unisource.universitysource.controller;

import com.unisource.universitysource.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Exception> handleInvalidPasswordException(InvalidPasswordException e) {
        return ResponseEntity.status(711).body(e);
    }

    @ExceptionHandler(InvalidUserNameException.class)
    public ResponseEntity<Exception> handleInvalidPasswordException(InvalidUserNameException e) {
        return ResponseEntity.status(712).body(e);
    }

    @ExceptionHandler(NotFoundObjectException.class)
    public ResponseEntity<Exception> handleInvalidPasswordException(NotFoundObjectException e) {
        return ResponseEntity.status(713).body(e);
    }

    @ExceptionHandler(ObjectAlreadyExistException.class)
    public ResponseEntity<Exception> handleInvalidPasswordException(ObjectAlreadyExistException e) {
        return ResponseEntity.status(714).body(e);
    }

    @ExceptionHandler(PermissionDeniedException.class)
    public ResponseEntity<Exception> handleInvalidPasswordException(PermissionDeniedException e) {
        return ResponseEntity.status(715).body(e);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Exception> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        return ResponseEntity.status(716).body(e);
    }
}
