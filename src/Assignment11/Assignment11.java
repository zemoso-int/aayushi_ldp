package Assignment11;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Assignment11 {

    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        File f = new File("/home/aayushi/IdeaProjects/aayushi_ldp/src/Assignment11/characters.txt");
        FileReader fr = new FileReader(f);
        int i;
        while ((i = fr.read()) != -1) {
            Character c = (char) i;
            System.out.println(c);
            if (myMap.containsKey(c))
                myMap.put(c, myMap.get(c) + 1);
            else
                myMap.put(c, 1);
        }
        FileWriter resultsFile=new FileWriter("results.txt");
        for(Map.Entry<Character, Integer> entry:myMap.entrySet())
            resultsFile.write(entry.getKey() +" "+ entry.getValue() +"\n");
        resultsFile.close();
    }
}