package com.scaler.capstoneproject.globalExceptionHandler;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
public class RestError implements Serializable {
    private Object error;
    private LocalDateTime timeStamp;
    private Object errorCode;
    private Object errorDescription;
}
