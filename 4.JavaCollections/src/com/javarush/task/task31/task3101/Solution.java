package com.javarush.task.task31.task3101;

/*
Проход по дереву файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<File> targetFiles = new ArrayList<>();

    public void searchFiles(File rootDirectory, List<File> fileList) {
        if (rootDirectory.isDirectory()) {
            File[] directoryFiles = rootDirectory.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getAbsolutePath().toLowerCase().endsWith(".txt") && file.length() <= 50) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        File root = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        String parentPath = resultFileAbsolutePath.getParent();
        File newFileResultName = new File(parentPath + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, newFileResultName);

        Solution sol = new Solution();
        sol.searchFiles(root, sol.targetFiles);

        for (File file : sol.targetFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(newFileResultName, true))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //вариант javarush

//    public static void main(String[] args) {
//        String path = args[0];
//        String resultFileAbsolutePath = args[1];
//        try {
//            File resultFile = new File(resultFileAbsolutePath);
//            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
//            if (FileUtils.isExist(dest)) {
//                FileUtils.deleteFile(dest);
//            }
//            FileUtils.renameFile(resultFile, dest);
//
//            Map<String, byte[]> fileTree = getFileTree(path);
//            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
//                for (byte[] bytes : fileTree.values()) {
//                    fileOutputStream.write(bytes);
//                    fileOutputStream.write("\n".getBytes());
//                }
//            }
//        } catch (IOException ignored) {
//        }
//    }
//
//    public static Map<String, byte[]> getFileTree(String root) throws IOException {
//        Map<String, byte[]> result = new TreeMap<>();
//
//        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
//        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));
//
//        return result;
//    }
//
//    private static class GetFiles extends SimpleFileVisitor<Path> {
//        private Map<String, byte[]> result;
//
//        public GetFiles(Map<String, byte[]> result) {
//            this.result = result;
//        }
//
//        @Override
//        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
//            File file = path.toFile();
//            if (file.isFile() && file.length() <= 50) {
//                result.put(path.getFileName().toString(), Files.readAllBytes(path));
//            }
//            return super.visitFile(path, basicFileAttributes);
//        }
//    }
}
