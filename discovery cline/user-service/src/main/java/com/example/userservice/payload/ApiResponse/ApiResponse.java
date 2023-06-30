package com.example.userservice.payload.ApiResponse;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String msg;
    private boolean success;
    private HttpStatus status;
}
