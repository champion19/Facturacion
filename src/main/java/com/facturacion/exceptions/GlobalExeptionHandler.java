package com.facturacion.exceptions;
import com.facturacion.web.ResponseErro;
import org.apache.catalina.connector.Connector;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErro>handleValidateExceptions(MethodArgumentNotValidException ex){
        Map<String,String>errors=new HashMap<String,String>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldname=((FieldError)error).getField();
            String message= error.getDefaultMessage();

            errors.put(fieldname,message);
        });
        return ResponseErro.createResponse(HttpStatus.BAD_REQUEST,"Peticion Erronea",errors);
    }

    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ResponseErro>handleDBExceptions(JDBCConnectionException ex)
    {
        return ResponseErro.createResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Error en la DB","error en la conexion en la DB");

    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseErro>handleResourceNotFoundExceptions(ResourceNotFoundException ex){

        return ResponseErro.createResponse(HttpStatus.CREATED.NOT_FOUND,"No se encontro el recurso",ex.getMessage());
    }



    //DIFERENCIA ENTRE PUT Y PATCH
    //patch: update uno o dos atributos
    // put:  update cualquier cosa
}

