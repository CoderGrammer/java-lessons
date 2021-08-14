package com.formatting;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
 - What it does:
     - From the 'start num' it bumps the numbers
 - Issues:
     - Will not bump single digit numbers
*/
public class Rename {

    enum Type {
        INCREMENT, DECREMENT
    }

    static final Type type = Type.DECREMENT;
    static final int START_NUM_INCLUSIVE = 17;

    static final String FILE_NUMBER_FORMAT = "_%02d_";
    static final List<Integer> EXCLUDE_FROM_RENAME = List.of(99);
    static final String START = String.format(FILE_NUMBER_FORMAT, START_NUM_INCLUSIVE);
    static final String BASE_PATH = "/Users/syedasghar/code/courses/java-lessons/";
    static final String BACKUP_PATH = BASE_PATH + ".bak";
    static final String SRC_PATH = BASE_PATH + "src/main/java/com/lessons/interfaces";

    public static void main(String[] args) {
        Rename r = new   Rename();
        r.doIt();
    }

    private void doIt() {
        backup();
        List<String> filesToRename = getAllFiles()
                .stream()
                .filter(Predicate.not(this::isExcluded))
                .filter(this::isFileNameEligible)
                .filter(this::isFileNumberEligible)
                .collect(Collectors.toList());
        rename(filesToRename);
    }

    private List<String> getAllFiles() {
        Set<String> strings = listFilesUsingDirectoryStream(SRC_PATH);
        return new ArrayList<>(strings);
    }

    @SneakyThrows
    private void backup() {
        File source = new File(SRC_PATH);
        File dest = new File(BACKUP_PATH + "/" + System.currentTimeMillis());
        FileUtils.copyDirectory(source, dest);
    }

    private void rename(List<String> filesToRename) {
        filesToRename
                .forEach(this::renameFile);
    }

    @SneakyThrows
    private void replaceContent(String filename, String find, String replace) {
        if (!filename.endsWith(".java")) {
            return;
        }
        Path path = Paths.get(SRC_PATH + "/" + filename);
        Charset charset = StandardCharsets.UTF_8;
        String content = Files.readString(path, charset);
        content = content.replaceAll(find, replace);
        Files.write(path, content.getBytes(charset));
    }

    private int getNewNum(int fileNumber) {
        if (type == Type.INCREMENT) {
            return ++fileNumber;
        }
        return --fileNumber;
    }

    private void renameFile(String fileToRename) {
        int fileNumber = getFileNumber(fileToRename);
        String oldStr = String.format(FILE_NUMBER_FORMAT, fileNumber);
        String newStr = String.format(FILE_NUMBER_FORMAT, getNewNum(fileNumber));
        replaceContent(fileToRename, oldStr, newStr);
        String newFileName = fileToRename.replace(oldStr, newStr);
        System.out.println(fileToRename);
        System.out.println(newFileName);
        renameAFile(fileToRename, newFileName);
    }

    @SneakyThrows
    private void renameAFile(String source, String target) {
        Path sourcePath = Paths.get(Rename.SRC_PATH, source);
        Path targetPath = Paths.get(Rename.SRC_PATH, target);
        Files.move(sourcePath, targetPath);
    }

    private boolean isExcluded(String fileName) {
        return EXCLUDE_FROM_RENAME
                .stream()
                .map(s -> String.format(FILE_NUMBER_FORMAT, s))
                .peek(System.out::println)
                .anyMatch(fileName::contains);
    }

    private boolean isFileNumberEligible(String fileName) {
        Objects.requireNonNull(fileName);
        if (fileName.contains(START)) {
            return true;
        }
        int fileNumber = getFileNumber(fileName);
        return fileNumber >= START_NUM_INCLUSIVE;
    }

    private int getFileNumber(String fileName) {
        Matcher matcher = Pattern.compile("_([0-9]+)_.*").matcher(fileName);
        matcher.matches();
        return Integer.parseInt(matcher.group(1));
    }

    private boolean isFileNameEligible(String fileName) {
        return fileName.matches("_[0-9]+_.*");
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
