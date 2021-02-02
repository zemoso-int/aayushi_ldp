package Assignment2;

import java.util.Scanner;

public class Driver {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        StringChecker stringChecker = new StringChecker();
        boolean present = stringChecker.areAllAlphabetsPresent(inputString);

        if(present)
            System.out.println("All alphabets are present");
        else
            System.out.println("All alphabets are not present");
    }
}
