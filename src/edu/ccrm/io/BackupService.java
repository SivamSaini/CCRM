package edu.ccrm.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class BackupService {
    private final Path backupRoot;
    private final DateTimeFormatter timestampFormat;

    public BackupService(Path backupRoot) {
        this.backupRoot = backupRoot;
        this.timestampFormat = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        createDirectoryIfNotExists(backupRoot);
    }

    public Path createBackup(Path sourceDirectory) throws IOException {
        String timestamp = LocalDateTime.now().format(timestampFormat);
        Path backupDir = backupRoot.resolve("backup_" + timestamp);
        Files.createDirectories(backupDir);

        try (Stream<Path> paths = Files.walk(sourceDirectory)) {
            paths.filter(Files::isRegularFile)
                    .forEach(source -> {
                        Path relativePath = sourceDirectory.relativize(source);
                        Path targetPath = backupDir.resolve(relativePath);
                        try {
                            Files.createDirectories(targetPath.getParent());
                            Files.copy(source, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        }

        return backupDir;
    }

    private void createDirectoryIfNotExists(Path directory) {
        try {
            if (!Files.exists(directory)) Files.createDirectories(directory);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}