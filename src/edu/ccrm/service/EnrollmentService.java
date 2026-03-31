package edu.ccrm.service;

import edu.ccrm.domain.*;
import java.util.List;
import java.util.Map;

public interface EnrollmentService {
    void enrollStudent(String studentId, String courseCode);
    void unenrollStudent(String studentId, String courseCode);
    void recordGrade(String studentId, String courseCode, Grade grade);

    List<Course> getEnrolledCourses(String studentId, Semester semester);
    List<Student> getEnrolledStudents(String courseCode);
    Grade getStudentGrade(String studentId, String courseCode);
    Map<Course, Grade> getStudentGrades(String studentId, Semester semester);

    boolean canEnroll(String studentId, String courseCode);
    int calculateTotalCredits(String studentId, Semester semester);
    boolean hasPrerequisites(String studentId, String courseCode);

    Map<Grade, Long> getGradeDistribution(String courseCode);
    double getAverageGrade(String courseCode);
    List<Student> getTopPerformers(String courseCode, int limit);
}