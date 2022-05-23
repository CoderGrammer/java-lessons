package com.formatting;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

public class CreateVideoFolders {

    public static void main(String[] args) {
        new CreateVideoFolders().run();
    }

    private static final String OUTPUT_FOLDER = "";

    private static final String TOPICS = """
            """;


    void run() {
        String nextNumber = getFormattedNextNumber(getLastNumber());
        List<String> topics = getTopics();
        List<String> numberedTopicNames = new ArrayList<>();
        for (String topic : topics) {
            String newName = nextNumber + " " + topic;
            numberedTopicNames.add(newName);
            nextNumber = getFormattedNextNumber(nextNumber);
        }
        numberedTopicNames
                .stream()
                .peek(System.out::println)
                .forEach(this::createDir);
    }

    private void createDir(String directory) {
        boolean mkdirs = Paths.get(OUTPUT_FOLDER, directory).toFile().mkdirs();
        if (!mkdirs) {
            throw new RuntimeException("Could not create directory " + directory);
        }
    }

    private List<String> getTopics() {
        return Stream.of(TOPICS.split("\n"))
                .collect(toList());
    }

    private String getFormattedNextNumber(String number) {
        return getFormattedNextNumber(Long.parseLong(number));
    }

    private String getFormattedNextNumber(Long currentHighestNumber) {
        long l = currentHighestNumber + 3;
        return String.format("%07d", l);
    }

    private Long getLastNumber() {
        return Stream.of(requireNonNull(new File(OUTPUT_FOLDER)
                .listFiles(File::isDirectory)))
                .map(File::getName)
                .filter(s -> s.matches("[0-9]{7}.*"))
                .map(s -> s.substring(0, 7))
                .mapToLong(Long::parseLong)
                .max()
                .orElseThrow(() -> new RuntimeException("Could not find the highest number"));
    }

}
