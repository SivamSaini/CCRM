# CCRM – College Course Registration & Record Management System

## 📌 Overview
CCRM is a Java-based academic management system designed to handle core college operations such as:

- Student registration
- Course management
- Enrollment processing
- Grade recording
- GPA calculation
- Academic transcript support
- CSV import/export
- Data backup

This project was developed for the **Bring Your Own Project (BYOP)** for the **Programming in Java** course.

The main goal of this project is to use Java to solve  academic management problems using **Object-Oriented Programming (OOP)** and modular software design.

---

## 🎯 Problem Statement
In educational institutions, managing student records, course registrations, enrollments, and academic performance manually can be inefficient and cause errors.

There is a need for a software system that can:
- maintain student and course records
- support enrollments
- validate academic constraints
- record grades
- calculate GPA
- generate academic data in a manageable format

CCRM addresses this problem through a modular Java application.

---

## 🚀 Features

### Core Features
- Add and manage students
- Add and manage courses
- Manage instructors
- Enroll students into courses
- Unenroll students from courses
- Record student grades
- Calculate GPA
- Retrieve enrolled students and courses

### Validation Features
- Duplicate enrollment prevention
- Credit limit validation
- Entity existence validation
- Prerequisite validation support (extendable)

### Data Management Features
- Import students and courses from CSV
- Export students, courses, enrollments, and grades
- Backup project data
- Search and filter using Java Streams API

---

## 🛠 Technologies Used
- **Java**
- **Object-Oriented Programming**
- **Collections Framework**
- **Java Streams API**
- **File Handling**
- **CSV Parsing**
- **Custom Exception Handling**
- **Design Patterns**

---

## 🧠 OOP Concepts Demonstrated

### 1. Classes and Objects
Domain classes such as:
- `Student`
- `Instructor`
- `Course`
- `Person`

### 2. Inheritance
- `Student` extends `Person`
- `Instructor` extends `Person`

### 3. Abstraction
- `Person` is an abstract class

### 4. Polymorphism
- `getRole()` method is overridden in subclasses

### 5. Encapsulation
- Private fields with getters/setters

### 6. Interfaces
Service interfaces for modular design:
- `StudentService`
- `CourseService`
- `EnrollmentService`
- `TranscriptService`

### 7. Design Patterns
- **Singleton Pattern** → `AppConfig`
- **Builder Pattern** → `Course.Builder`

---

## 📂 Project Structure

```text
CCRM-Java-Project/
│
├── README.md
├── .gitignore
├── report.pdf
│
├── data/
│
├── test-data/
│   ├── students.csv
│   └── courses.csv
│
├── screenshots/
│   ├── project_structure.png
│   ├── output1_imported_students.png
│   ├── output2_imported_courses.png
│   ├── output3_enrollment.png
│   ├── output4_gpa.png
│   ├── output5_enrolled_courses.png
│   └── output6_final_success.png
│
└── src/
    └── edu/
        └── ccrm/
            ├── Main.java
            │
            ├── config/
            │   └── AppConfig.java
            │
            ├── domain/
            │   ├── Course.java
            │   ├── Grade.java
            │   ├── Instructor.java
            │   ├── Name.java
            │   ├── Person.java
            │   ├── Semester.java
            │   └── Student.java
            │
            ├── exception/
            │   ├── DuplicateEnrollmentException.java
            │   ├── EntityNotFoundException.java
            │   ├── MaxCreditLimitExceededException.java
            │   └── PrerequisiteNotMetException.java
            │
            ├── io/
            │   ├── BackupService.java
            │   ├── CsvParser.java
            │   └── ImportExportService.java
            │
            ├── service/
            │   ├── CrudService.java
            │   ├── StudentService.java
            │   ├── CourseService.java
            │   ├── EnrollmentService.java
            │   └── TranscriptService.java
            │
            └── service/
                └── impl/
                    ├── CourseServiceImpl.java
                    ├── EnrollmentServiceImpl.java
                    └── StudentServiceImpl.java
```
### Student Details
- **Name:** Shivam Saini
- **Course:** Programming in Java  
- **Project:** College Course Registration & Record Management System(CCRM)