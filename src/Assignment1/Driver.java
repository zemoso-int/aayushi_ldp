package Assignment1;

import java.util.Scanner;

import Assignment1.SearchFileInDirectory;
import Assignment1.Utils;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Enter any regex or \"exit\" to stop program");
        Scanner scanner = new Scanner(System.in);
        String inputEntered = scanner.next();
        String homeDirectory = System.getProperty("user.home");
        while (!Utils.shouldExit(inputEntered)) {
            String pattern = inputEntered;
            SearchFileInDirectory.findAndPrintFiles(pattern, homeDirectory);
            System.out.println("\nEnter next Regex or \" exit \" to quit");
            inputEntered = scanner.next();
        }
    }
}
