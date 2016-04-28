package com.skpcp.elista.utils.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


/**
 * Created by Tomasz Komoszeski on 2016-04-28.
 */
public class MyServerException extends Exception{
    HttpStatus status;
    HttpHeaders headers;

    public MyServerException(String message, HttpStatus status, HttpHeaders headers) {
        super(message);
        this.status = status;
        headers.add("stan",message);
        this.headers = headers;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }


}
