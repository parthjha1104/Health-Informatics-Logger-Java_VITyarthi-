package com.healthlogger.model;

import java.time.LocalDateTime;

// Using a Sealed Interface to restrict record types
public sealed interface HealthRecord permits BloodPressureRecord, HeartRateRecord, BMIRecord {
    LocalDateTime timestamp();
    String getSummary();
}

// Immutable data carriers using Records
public record BloodPressureRecord(LocalDateTime timestamp, int systolic, int diastolic) implements HealthRecord {
    @Override
    public String getSummary() {
        return String.format("[%s] Blood Pressure: %d/%d mmHg", timestamp, systolic, diastolic);
    }
}

public record HeartRateRecord(LocalDateTime timestamp, int bpm) implements HealthRecord {
    @Override
    public String getSummary() {
        return String.format("[%s] Heart Rate: %d bpm", timestamp, bpm);
    }
}

public record BMIRecord(LocalDateTime timestamp, double weightKg, double heightM) implements HealthRecord {
    @Override
    public String getSummary() {
        return String.format("[%s] BMI Entry: %.2f kg, %.2f m", timestamp, weightKg, heightM);
    }
}

public record Patient(String id, String name, int age) {}