package Assignment3;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) throws IOException {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter host to ping");
          String hostName= sc.nextLine();
          float medianTime = PingHost.computeMedianOfTimeToPing(hostName);
          System.out.println("Median of time taken to ping host "+ hostName + " = "+ medianTime + " ms");

    }
}
