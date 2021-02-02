package Assignment4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KYCCalculator {
    public  String dateRange(LocalDate signUp, LocalDate currDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String result = "";
        if (signUp.isAfter(currDate)) {
            result = "No range";
            return result;
        } else {
            int yearBetweenSignupAndCurrentDate = currDate.getYear() - signUp.getYear();
            if (yearBetweenSignupAndCurrentDate<1) {
                result = "No range";
                return result;
            }
            LocalDate anniversaryInCurrentYear = signUp.plusYears(yearBetweenSignupAndCurrentDate);
            LocalDate rangeStart = anniversaryInCurrentYear.minusDays(30);
            LocalDate rangeEnd = anniversaryInCurrentYear.plusDays(30);
            if (rangeStart.compareTo(currDate) > 0){
                anniversaryInCurrentYear = anniversaryInCurrentYear.minusYears(1);
                rangeStart = anniversaryInCurrentYear.minusDays(30);
                rangeEnd = anniversaryInCurrentYear.plusDays(30);
                result = rangeStart.format(format) +" "+ rangeEnd.format(format);
            }
            else if (rangeStart.compareTo(currDate) <= 0 && rangeEnd.compareTo(currDate) >= 0){
                result = rangeStart.format(format) +" "+ currDate.format(format);
            }
            else if (rangeStart.compareTo(currDate) < 0 && rangeEnd.compareTo(currDate) < 0){
                result = rangeStart.format(format) +" "+ rangeEnd.format(format);
            }
            return result;
        }

    }
}
