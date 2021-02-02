package Assignment3;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) throws IOException {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter host to ping");
          String hostName= sc.nextLine();

          System.out.println("Enter the number of times to ping");
          int pingCount = sc.nextInt();
          PingHost pingHost = new PingHost();
          float medianTime = pingHost.computeMedianOfTimeToPing(hostName, pingCount);
          System.out.println("Median of time taken to ping host "+ hostName + " = "+ medianTime + " ms");

    }
}
