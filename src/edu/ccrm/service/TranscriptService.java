package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Semester;
import java.util.List;
import java.util.Map;

public interface TranscriptService {
    String generateTranscript(String studentId);
    String generateSemesterTranscript(String studentId, Semester semester);
    void exportTranscript(String studentId, String filePath);

    double calculateSemesterGpa(String studentId, Semester semester);
    double calculateCumulativeGpa(String studentId);
    List<Course> getCompletedCourses(String studentId);
    Map<Semester, Double> getGpaProgression(String studentId);

    int getTotalCreditsCompleted(String studentId);
    int getTotalCreditsPending(String studentId);
    Map<Grade, Integer> getGradeDistribution(String studentId);

    boolean isEligibleForGraduation(String studentId);
    boolean isOnProbation(String studentId);
    String getAcademicStanding(String studentId);
}