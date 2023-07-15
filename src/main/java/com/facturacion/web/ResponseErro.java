package com.facturacion.web;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErro {

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime time;

    private HttpStatus status;
    private String message;
    private Object errors;

    public static ResponseEntity<ResponseErro> createResponse(HttpStatus status, String message, Object errors){
        ResponseErro response = new ResponseErro(LocalDateTime.now(), status, message, errors);
        return  new ResponseEntity<ResponseErro>(response,status);
    }
}