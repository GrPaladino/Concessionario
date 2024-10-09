package com.app.concessionario.exeptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


public class RestResponseEntity extends ResponseEntity {
    public RestResponseEntity(HttpStatusCode status) {
        super(status);
    }

    public RestResponseEntity(Object body, HttpStatusCode status) {
        super(body, status);
    }

    public RestResponseEntity(MultiValueMap headers, HttpStatusCode status) {
        super(headers, status);
    }

    public RestResponseEntity(Object body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public RestResponseEntity(Object body, MultiValueMap headers, HttpStatusCode statusCode) {
        super(body, headers, statusCode);
    }
}
