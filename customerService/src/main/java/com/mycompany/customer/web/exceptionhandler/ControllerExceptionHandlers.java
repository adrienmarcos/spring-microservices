package com.mycompany.customer.web.exceptionhandler;

import com.mycompany.customer.domain.exception.ConflictException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandlers {

    @ExceptionHandler(ConflictException.class)
    private ResponseEntity<ProblemDetail> handleConflictException(ConflictException e) {
        var problem = ProblemDetail.forStatus(HttpStatus.valueOf(409));
        problem.setTitle(e.getMessage());
        problem.setDetail(e.getMessage());
        return ResponseEntity.status(HttpStatus.valueOf(409)).body(problem);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ProblemDetail> handleEntityNotFountException(EntityNotFoundException e) {
        var problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle(e.getMessage());
        problem.setDetail(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<ProblemDetail> handleBadRequestException(BadRequestException e) {
        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle(e.getMessage());
        problem.setDetail(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ProblemDetail> handleMethodArgumentoNotValidException(MethodArgumentNotValidException e) {
        var fieldErrors = e.getBindingResult().getFieldErrors();
        var fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("BAD REQUEST. Invalid fields!");
        problem.setDetail("Invalid fields: " + fields);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

}
