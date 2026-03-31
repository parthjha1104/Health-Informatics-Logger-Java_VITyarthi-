package com.healthlogger.util;

public class HealthCalculators {

    public static String categorizeBP(int systolic, int diastolic) {
        // Based on 2025 AHA/ACC Guidelines [1, 2, 3]
        if (systolic >= 180 |

| diastolic >= 120) return "SEVERE HYPERTENSION";
        if (systolic >= 140 |

| diastolic >= 90) return "STAGE 2 HYPERTENSION";
        if (systolic >= 130 |

| diastolic >= 80) return "STAGE 1 HYPERTENSION";
        if (systolic >= 120 && diastolic < 80) return "ELEVATED";
        return "NORMAL";
    }

    public static double calculateBMI(double weightKg, double heightM) {
        // Formula: weight(kg) / height(m)^2 [4, 5]
        return weightKg / Math.pow(heightM, 2);
    }

    public static String categorizeBMI(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static int calculateTargetHeartRate(int age, int restingHR, double intensity) {
        // Karvonen Formula: THR = ((MHR - RHR) * intensity) + RHR [6, 7]
        int maxHR = 220 - age;
        int hrr = maxHR - restingHR;
        return (int) ((hrr * intensity) + restingHR);
    }
}