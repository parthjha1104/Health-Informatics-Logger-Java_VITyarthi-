package com.healthlogger.service;

import com.healthlogger.model.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class LoggerService {
    private final List<HealthRecord> records = new ArrayList<>();
    private static final String FILE_NAME = "health_logs.csv";

    public void addRecord(HealthRecord record) {
        records.add(record);
        saveToCSV(record);
    }

    public List<HealthRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }

    // Stream API for baseline analysis [8, 9]
    public double getAverageHeartRate() {
        return records.stream()
               .filter(r -> r instanceof HeartRateRecord)
               .mapToInt(r -> ((HeartRateRecord) r).bpm())
               .average()
               .orElse(0.0);
    }

    private void saveToCSV(HealthRecord record) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            if (record instanceof HeartRateRecord hr) {
                writer.println("HR," + hr.timestamp() + "," + hr.bpm());
            } else if (record instanceof BloodPressureRecord bp) {
                writer.println("BP," + bp.timestamp() + "," + bp.systolic() + "," + bp.diastolic());
            }
        } catch (IOException e) {
            System.err.println("Persistence error: " + e.getMessage());
        }
    }
}