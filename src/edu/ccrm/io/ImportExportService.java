package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Grade;
import edu.ccrm.domain.Semester;

import java.io.*;
import java.nio.file.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class ImportExportService {
    private static final String CSV_DELIMITER = ",";
    private final Path dataDirectory;
    private final DateTimeFormatter timestampFormat;

    public ImportExportService(Path dataDirectory) {
        this.dataDirectory = dataDirectory;
        this.timestampFormat = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        createDirectoryIfNotExists(dataDirectory);
    }

    public List<Student> importStudents(Path filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath)) {
            Iterator<String> iterator = lines.iterator();
            if (iterator.hasNext()) iterator.next();

            while (iterator.hasNext()) {
                String[] data = iterator.next().split(CSV_DELIMITER);
                if (data.length >= 5) {
                    Student student = new Student(
                            data[0].trim(),
                            data[2].trim() + " " + data[3].trim(),
                            data[4].trim(),
                            data[1].trim()
                    );
                    students.add(student);
                }
            }
        }
        return students;
    }

    public List<Course> importCourses(Path filePath) throws IOException {
        List<Course> courses = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath)) {
            Iterator<String> iterator = lines.iterator();
            if (iterator.hasNext()) iterator.next();

            while (iterator.hasNext()) {
                String[] data = iterator.next().split(CSV_DELIMITER);
                if (data.length >= 6) {
                    Course course = new Course.Builder(data[0].trim())
                            .title(data[1].trim())
                            .credits(Integer.parseInt(data[2].trim()))
                            .semester(Semester.valueOf(data[4].trim()))
                            .department(data[5].trim())
                            .build();
                    courses.add(course);
                }
            }
        }
        return courses;
    }

    private void createDirectoryIfNotExists(Path directory) {
        try {
            if (!Files.exists(directory)) Files.createDirectories(directory);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to create directory: " + directory, e);
        }
    }
}