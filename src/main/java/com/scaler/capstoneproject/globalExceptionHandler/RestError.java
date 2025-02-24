package com.scaler.capstoneproject.globalExceptionHandler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
public class RestError {
    private Object error;
    private LocalDateTime timeStamp;
    private Object errorCode;
    private Object errorDescription;
}
