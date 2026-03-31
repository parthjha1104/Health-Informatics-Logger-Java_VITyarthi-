package com.healthlogger.exception;

/**
 * Custom exception for clinically invalid health data.
 */
public class InvalidHealthMetricException extends Exception {
    public InvalidHealthMetricException(String message) {
        super(message);
    }
}