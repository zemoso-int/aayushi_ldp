package Coursera.SolvingProblemsWithSoftware.Week3.Part2;

import Coursera.SolvingProblemsWithSoftware.edu.duke.DirectoryResource;
import Coursera.SolvingProblemsWithSoftware.edu.duke.FileResource;
import Coursera.SolvingProblemsWithSoftware.org.apache.commons.csv.CSVParser;
import Coursera.SolvingProblemsWithSoftware.org.apache.commons.csv.CSVRecord;

import java.io.File;

public class WeatherParser {
    CSVRecord coldestHourInFile(CSVParser parser) {
      CSVRecord smallestSoFar = null;
      double minTemp = Double.MAX_VALUE;
      for(CSVRecord currentRow: parser) {
              smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "TemperatureF");
      }
      return smallestSoFar;
    }


    void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
    }

    public void testColdestHourInFile(String filename)
    {
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        CSVRecord rec=coldestHourInFile(parser);
        System.out.println("Coldest hour is :"+rec.get("TimeEST")+" on "+rec.get("DateUTC")+" and temp is :"+rec.get("TemperatureF"));
    }

    CSVRecord coldestInManyDays() {
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "TemperatureF");
        }

        return smallestSoFar;
    }

    void testColdestInManyDays() {
        CSVRecord smallest = coldestInManyDays();
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));

    }

    String fileWithColdestTemperature() {
        CSVRecord smallestSoFar = null;
        File minTempFile = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(smallestSoFar == null) {
                smallestSoFar = currentRow;
                minTempFile = f;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                if(currentTemp<smallestTemp && currentTemp!=-9999) {
                    smallestSoFar = currentRow;
                    minTempFile = f;
                }
            }
        }

        return minTempFile.toString();
    }

    void testFileWithColdestTemperature() {
        String fileName = fileWithColdestTemperature();
        System.out.println("coldest temperature was found in file" + fileName);
        testColdestHourInFile(fileName);

    }

    CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar, String columnName) {
        if(smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        else {
            double currentTemp = !currentRow.get(columnName).equals("N/A")?Double.parseDouble(currentRow.get(columnName)): Integer.MAX_VALUE;
            double smallestTemp = Double.parseDouble(smallestSoFar.get(columnName));
            if(currentTemp<smallestTemp&& currentTemp!=-9999) {
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }

    CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord smallestSoFar = null;
        double minTemp = Double.MAX_VALUE;
        for(CSVRecord currentRow: parser) {
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "Humidity");
        }
        return smallestSoFar;

    }

    void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    CSVRecord lowestHumidityInManyFiles() {
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "Humidity");
        }

        return smallestSoFar;

    }

    void testLowestHumidityInManyFiles() {
        CSVRecord smallest = lowestHumidityInManyFiles();
        System.out.println("Lowest humidity was " + smallest.get("Humidity") + " at " + smallest.get("DateUTC"));
    }

    double averageTemperatureInFile(CSVParser parser) {
      double sum = 0.0;
      double numberOfLines = 0;
      for(CSVRecord currentRecord: parser) {
          sum += Double.parseDouble(currentRecord.get("TemperatureF"));
          numberOfLines++;
      }
      return sum/numberOfLines;
    }

    void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average temperature in file is" + averageTemperatureInFile(parser));
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double totalTemperature = 0;
        int recordCount = 0;
        for (CSVRecord record : parser) {
            int currentHumidity = Integer.parseInt(record.get("Humidity"));
            if (currentHumidity >= value) {
                double currentTemperature = Double.parseDouble(record.get("TemperatureF"));
                if (currentTemperature != -9999) {
                    totalTemperature += currentTemperature;
                    recordCount++;
                }
            }
        }
        if (recordCount == 0) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return totalTemperature / recordCount;
        }
    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        double averageTemperature = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        if (averageTemperature == Double.NEGATIVE_INFINITY) {
            System.out.println("No temperature with that humidity");
        } else {
            System.out.println("Average temperature when high humidity is " + averageTemperature);
        }
    }

    public static void main(String args[]) {
        WeatherParser parser = new WeatherParser();
        parser.testColdestHourInFile();
        parser.testColdestInManyDays();
        parser.testFileWithColdestTemperature();
        parser.testLowestHumidityInFile();
        parser.testLowestHumidityInManyFiles();
        parser.testAverageTemperatureInFile();
        parser.testAverageTemperatureWithHighHumidityInFile();
    }

}
