package Assignment1;

import java.util.Scanner;

import Assignment1.SearchFileInDirectory;
import Assignment1.Utils;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Enter any regex or \"exit\" to stop program");
        Scanner scanner = new Scanner(System.in);
        String fileNamePattern = scanner.next();
        String homeDirectory = System.getProperty("user.home");
        System.out.println(homeDirectory+ "dnjnkd");
        while (!Utils.shouldExit(fileNamePattern)) {
            SearchFileInDirectory searchFileInDirectory = new SearchFileInDirectory();
            int filesCount = 0;
            searchFileInDirectory.findAndPrintFiles(fileNamePattern, homeDirectory);
            System.out.println("\nEnter next Regex or \" exit \" to quit");
            fileNamePattern = scanner.next();
        }
    }
}
