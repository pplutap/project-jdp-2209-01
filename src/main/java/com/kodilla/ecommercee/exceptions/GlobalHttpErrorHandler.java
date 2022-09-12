package com.kodilla.ecommercee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductInCartNotFoundException.class)
    public ResponseEntity<Object> handleProductInCartNotFoundException(ProductInCartNotFoundException exception) {
        return new ResponseEntity<>("Product in cart with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PriceOfProductChangedException.class)
    public ResponseEntity<Object> handlePriceOfProductChanged(PriceOfProductChangedException exception) {
        return new ResponseEntity<>("Complete your cart again, price/s changed", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProdctNotFoundException.class)
    public ResponseEntity<Object> handleProdctNotFoundException(ProdctNotFoundException exception) {
        return new ResponseEntity<>("Product with given ID does not exist", HttpStatus.BAD_REQUEST);
    }
}
