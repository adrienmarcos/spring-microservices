package com.mycompany.fraud.web.exceptionhandler;

import com.mycompany.fraud.domain.exception.ConflictException;
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

}
