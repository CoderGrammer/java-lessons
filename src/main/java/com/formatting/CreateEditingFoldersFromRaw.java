package com.formatting;

import io.vavr.Tuple2;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CreateEditingFoldersFromRaw {

    final static boolean copyFilesIntoRaw = true;

    final static String root = "/Users/syedasghar/Creative Cloud Files/Courses/JUnit 5/";

    final static String output = root + "Video/";

    final static String input = root + "Raw/";

    public static void main(String[] args) {
        new CreateEditingFoldersFromRaw().doIt();
    }

    private void doIt() {
        val allRequiredFolders = getAllFiles()
                .stream()
                .map(FilenameUtils::removeExtension)
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        val failures = computeFailures(allRequiredFolders);
        System.out.println("Folders not created (already exist):");
        failures
                .forEach(System.out::println);
        val creatableFolders = allRequiredFolders
                .stream()
                .filter(s -> !failures.contains(s))
                .collect(Collectors.toList());
        val couldNotCreate = createFolderGroups(creatableFolders);
        System.out.println("Folders not created (failed):");
        couldNotCreate
                .forEach(System.out::println);
        if (copyFilesIntoRaw) {
            val collect = creatableFolders
                    .stream()
                    .filter(f -> !couldNotCreate.contains(f))
                    .map(s -> {
                        boolean b = new File(input + s + ".mov").renameTo(new File(output + s + File.separator + "Raw" + File.separator + s + ".mov"));
                        return new Tuple2<>(input + s + ".mov", b);
                    })
                    .filter(Predicate.not(Tuple2::_2))
                    .collect(Collectors.toList());
            System.out.println("Raw files which failed to copy:");
            collect
                    .forEach(System.out::println);
        }
    }

    private List<String> createFolderGroups(List<String> creatableFolders) {
        return creatableFolders
                .stream()
                .map(this::createFolderGroup)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * @return failures
     */
    private List<String> createFolderGroup(String s) {
        String x = output + File.separator + s + File.separator;
        List<String> output = List.of(
                "Raw",
                "Editing",
                "Edited");
        return output
                .stream()
                .map(f -> {
                    String file = x + f;
                    boolean mkdirs1 = new File(file).mkdirs();
                    return new Tuple2<>(file, mkdirs1);
                })
                .filter(Predicate.not(Tuple2::_2))
                .map(Tuple2::_1)
                .collect(Collectors.toList());
    }

    private List<String> computeFailures(List<String> foldersToCreate) {
        return foldersToCreate.stream()
                .filter(this::fileExists)
                .collect(Collectors.toList());
    }

    private boolean fileExists(String s) {
        String file = input + File.separator + s;
        return new File(file).exists();
    }

    private List<String> getAllFiles() {
        Set<String> strings = listFilesUsingDirectoryStream(input);
        return new ArrayList<>(strings);
    }

    @SneakyThrows
    private Set<String> listFilesUsingDirectoryStream(String dir) {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName().toString());
                }
            }
        }
        return fileList;
    }

}
