package Coursera.SolvingProblemsWithSoftware.Week2.StringsThirdAssignments;

import Coursera.SolvingProblemsWithSoftware.edu.duke.StorageResource;

import java.util.Arrays;
import java.util.List;

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = 0;
        while(true) {
            index = dna.indexOf(stopCodon, startIndex + 3);
            if (index == -1 || (index - startIndex) % 3 == 0) {
                break;
            }
            startIndex += 3;
        }
        if (index != -1) {
            return index;
        } else {
            return dna.length();
        }
    }

    public String findGene(String dna, int start) {
        final String START_CODON = "ATG";
        int startIndex = dna.indexOf(START_CODON, start);
        if (startIndex == -1) {
            return "";
        }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if (minIndex == dna.length()) {
            return "";
        } else {
            return dna.substring(startIndex, minIndex + 3);
        }
    }

    public StorageResource getAllGenes(String dna) {
        StorageResource sr=new StorageResource();
        int start = 0;
        while (true) {
            String gene = findGene(dna, start);
            if (gene.isEmpty()) {
                break;
            }
            sr.add(gene);
            start = dna.indexOf(gene, start) + gene.length();
        }
        return sr;
    }

    void testGetAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        StorageResource geneList = getAllGenes(dna);

        System.out.println("Testing getAllGenes on " + dna);
        for(String gene : geneList.data()) {
            System.out.println("Gene: " + gene);
        }
    }

    public static void main(String args[]) {
        new Part1().testGetAllGenes();
    }

}
