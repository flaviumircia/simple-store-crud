package com.pibd.orderwebapp.utils;

import com.pibd.orderwebapp.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public ResponseEntity<String> handleException(ObjectNotFoundException e){
        log.error(String.valueOf(e));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("The requested object does not exist in the database!");
    }

}
