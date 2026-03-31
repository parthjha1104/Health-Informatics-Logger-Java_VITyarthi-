# Health-Informatics-Logger-Java_VITyarthi-
Basic Health Informatics Logger  A lightweight system designed to record, categorize, and calculate basic patient or personal health metrics.

# 🏥 Health Informatics Logger (Java)

## 📌 Overview
The **Health Informatics Logger** is a lightweight Java-based system designed to transform raw biometric data into structured, clinically meaningful insights. It addresses the problem of unorganized health data by applying object-oriented design, validated medical logic, and statistical processing.

This project demonstrates how software engineering principles can be applied to real-world healthcare monitoring, enabling users to track, categorize, and analyze physiological metrics over time.

---

## 🎯 Key Features

- 📊 Structured logging of biometric data (BP, Heart Rate, BMI, Glucose)
- 🧠 Clinical categorization based on modern medical standards (AHA/ACC 2025, WHO)
- 📈 Baseline analysis (7-day averages, trends)
- ⚙️ Object-Oriented Architecture using Java 21 features
- 🔒 Data validation with custom exceptions
- 💾 Lightweight persistence using CSV & JSON
- 🧪 Unit testing with JUnit 5

---

## 🛠️ Tech Stack

- **Language:** Java 21  
- **Build Tool:** Maven / Gradle (optional)  
- **Testing:** JUnit 5  
- **Data Handling:** BufferedReader / BufferedWriter, JSON (manual/Jackson optional)  

---

## 🧱 System Architecture

### Core Components

| Component | Description |
|----------|------------|
| `Patient` | Stores demographic data |
| `HealthRecord` | Sealed interface for all health metrics |
| `BloodPressureRecord` | Stores systolic & diastolic readings |
| `HeartRateRecord` | Stores BPM values |
| `BMIRecord` | Stores height, weight, BMI |
| `VitalStatistics` | Manages list of records |

### Design Principles

- Separation of concerns (Patient vs Health Data)
- Immutability using `record`
- Type safety via `sealed interface`
- One-to-many relationship (Patient → Records)

---

## 🧮 Clinical Logic Implemented

### 1. Body Mass Index (BMI)

