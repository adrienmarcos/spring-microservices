package com.mycompany.customer.api.exceptionhandler;

import com.mycompany.customer.domain.exception.ConflictException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
