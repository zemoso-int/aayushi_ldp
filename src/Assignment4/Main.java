package Assignment4;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws ParseException {
        System.out.println("Enter number of inputs to be passed");
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            System.out.println("Enter sign up date and current date in format dd-mm-yyyy dd-mm-yyyy ");
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                LocalDate signUp = LocalDate.parse(sc.next(), format);
                LocalDate currDate = LocalDate.parse(sc.next(), format);
                KYCCalculator kycCalculator = new KYCCalculator();
                String range = kycCalculator.dateRange(signUp, currDate);
                System.out.println(range);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid Date Format -- enter dd-mm-yyyy");
            }

        }
    }
}
