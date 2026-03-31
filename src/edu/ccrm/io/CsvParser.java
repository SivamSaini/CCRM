package edu.ccrm.io;

import java.io.*;
import java.nio.file.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class CsvParser<T> {
    private final Path filePath;
    private final Function<String[], T> mapper;
    private final String delimiter;
    private final boolean hasHeader;

    public CsvParser(Path filePath, Function<String[], T> mapper, String delimiter, boolean hasHeader) {
        this.filePath = filePath;
        this.mapper = mapper;
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
    }

    public Stream<T> parse() throws IOException {
        Stream<String> lines = Files.lines(filePath);
        if (hasHeader) lines = lines.skip(1);
        return lines.map(line -> line.split(delimiter)).map(mapper);
    }
}