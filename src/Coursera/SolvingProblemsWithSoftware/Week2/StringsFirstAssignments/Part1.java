package Coursera.SolvingProblemsWithSoftware.Week2.StringsFirstAssignments;
import java.util.List;
import java.util.Arrays;
public class Part1 {
        public String findSimpleGene(String dna)
        {
            int start = dna.indexOf("ATG");
            int end = dna.indexOf("TAA",start+3);
            if(start!=-1 && end!=-1)
            {
                String match = dna.substring(start,end+3);
                return match.length()%3==0?match:"";
            }
            return "";
        }

        public void testSimpleGene()
        {
            List<String> tests = Arrays.asList(
                    "ATGTAA", //DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
                    "ATGGTATAA", //DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
                    "AAATGCCCTAACTAGATTAAGAAACC", //DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
                    "AGTCAA", //DNA with no “ATG” or “TAA”
                    "ATGAGCCGTAATCGAC", //DNA with ATG, TAA and the substring between them is not a multiple of 3
                    "ATGGCTCCATAA", //DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
                    "ATGCCCCTACGTAATCTA", //DNA with ATG, TAA and the substring between them is not a multiple of 3
                    "AGTGATTCGGCTCTGTAA", //DNA with no “TAA”
                    "AG",  //DNA with no “ATG” or “TAA”
                    "TAA", //DNA with no “ATG”
                    "AGT",  //DNA with no “ATG” or “TAA”
                    "ATGCCTAAYTAA"  //DNA with ATG, TAA and the substring between them is not a multiple of 3
            );
            for(String test:tests)
            {
                System.out.println(test+" dna: "+findSimpleGene(test));
            }

        }

        public static void main(String[] args)
        {
            new Part1().testSimpleGene();
        }
}

