package com.healthlogger;

import com.healthlogger.model.*;
import com.healthlogger.service.LoggerService;
import com.healthlogger.util.HealthCalculators;
import com.healthlogger.exception.InvalidHealthMetricException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String args) {
        LoggerService service = new LoggerService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Basic Health Informatics Logger ---");
        
        while (true) {
            System.out.println("\n1. Log Blood Pressure\n2. Log Heart Rate\n3. View Analysis\n4. Exit");
            System.out.print("Selection: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter Systolic (mmHg): ");
                        int sys = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Diastolic (mmHg): ");
                        int dia = Integer.parseInt(scanner.nextLine());
                        
                        if (sys < 50 |

| sys > 250) throw new InvalidHealthMetricException("Invalid BP range.");
                        
                        service.addRecord(new BloodPressureRecord(LocalDateTime.now(), sys, dia));
                        System.out.println("Category: " + HealthCalculators.categorizeBP(sys, dia));
                    }
                    case "2" -> {
                        System.out.print("Enter Heart Rate (bpm): ");
                        int bpm = Integer.parseInt(scanner.nextLine());
                        service.addRecord(new HeartRateRecord(LocalDateTime.now(), bpm));
                    }
                    case "3" -> {
                        System.out.println("\nBaseline Analysis:");
                        System.out.printf("Avg Heart Rate: %.1f bpm\n", service.getAverageHeartRate());
                        service.getRecords().forEach(r -> System.out.println(r.getSummary()));
                    }
                    case "4" -> System.exit(0);
                    default -> System.out.println("Invalid selection.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter numeric values only.");
            } catch (InvalidHealthMetricException e) {
                System.out.println("Clinical Error: " + e.getMessage());
            }
        }
    }
}