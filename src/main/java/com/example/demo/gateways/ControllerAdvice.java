package com.example.demo.gateways;

import lombok.extern.slf4j.Slf4j;

@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class ControllerAdvice {

//    @ExceptionHandler(PropertyValueException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public ResponseEntity trataPropertyvalueException(PropertyValueException exception) {
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//    }
//
//
//    @ExceptionHandler(AlunoNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> handleException(ResourceNotFoundException exception) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
//        log.error("Alguma coisa aconteceu", exception);
//        return ResponseEntity.internalServerError().body(new ErrorResponse(exception.getMessage(), "panic"));
//    }
//
//    @AllArgsConstructor
//    class ErrorResponse {
//        private String message;
//        private String code;
//    }


}
