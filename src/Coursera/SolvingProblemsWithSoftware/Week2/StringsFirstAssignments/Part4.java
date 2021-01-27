package Coursera.SolvingProblemsWithSoftware.Week2.StringsFirstAssignments;

import Coursera.SolvingProblemsWithSoftware.edu.duke.*;
public class Part4 {
    public static void main(String[] args)
    {
        URLResource url = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        String query = "youtube.com";
        for(String word:url.words())
        {
            int position = word.toLowerCase().indexOf(query);
            if(position!=-1)
            {
                System.out.println(word.substring(word.indexOf("\"")+1, word.lastIndexOf("\"")));
            }
        }
    }
}
