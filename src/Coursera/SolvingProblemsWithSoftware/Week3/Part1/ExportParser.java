package Coursera.SolvingProblemsWithSoftware.Week3.Part1;

import Coursera.SolvingProblemsWithSoftware.edu.duke.FileResource;
import Coursera.SolvingProblemsWithSoftware.org.apache.commons.csv.CSVParser;
import Coursera.SolvingProblemsWithSoftware.org.apache.commons.csv.CSVRecord;

public class ExportParser {
    void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Malaysia"));
        System.out.println(countryInfo(parser, "Nauru"));
        listExportersTwoProducts(parser, "gold", "diamonds");
        listExportersTwoProducts(parser, "fish", "nuts");
        System.out.println("Number of exporters: "+ numberOfExporters(parser, "gold"));
        bigExporters(parser, "$999,999,999");
    }

    String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record: parser){
            String countryName = record.get("Country");
            if(countryName.equals(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                return country + ": " + exports + ": " + value;
            }
        }
        return "NOT FOUND";
    }

    void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record: parser) {
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    int numberOfExporters(CSVParser parser, String exportItem) {
        int count =0;
        for(CSVRecord record: parser) {
            if(record.get("Exports").contains(exportItem))
                count++;
        }
        return count;
    }

    void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record: parser) {
            String value = record.get("Value (dollars)");
            if(value.length()>amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + value);
            }
        }
    }

    public static void main(String args[]) {
        new ExportParser().tester();
    }
}
