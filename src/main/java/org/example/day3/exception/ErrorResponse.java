package org.example.day3.exception;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Getter
public class ErrorResponse {

    private int status;
    private String message;
    private Map<String, String> errors;

    public ErrorResponse(int i, String message, Object o) {
    }
}
