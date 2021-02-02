package Assignment1;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFileInDirectory {

    /**
     * This method searches files recursively in directory and its sub-directories
     *
     * @param fileNameRegex         this is regex pattern to be matched with file names.
     * @param directoryAbsolutePath this is the current directory we're searching in.
     */
    protected int fileCount;

    protected void findAndPrintFiles(String fileNameRegex, String directoryAbsolutePath) {
        if (fileNameRegex == "")
            return;
        Pattern pattern = Pattern.compile(fileNameRegex);
        File directoryNode = new File(directoryAbsolutePath);
        File[] files = directoryNode.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                Matcher matcher = pattern.matcher(file.getName());
                if (matcher.find()) {
                    System.out.println(file.getAbsolutePath());
                    fileCount++;
                }
            } else
                findAndPrintFiles(fileNameRegex, file.getAbsolutePath());
        }
    }
}