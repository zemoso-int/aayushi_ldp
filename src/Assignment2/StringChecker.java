package Assignment2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringChecker {
    /* Time Complexity - O(n)
    Space complexity -  O(1)
    */
    protected boolean areAllAlphabetsPresent(String inputString) {
        if (inputString == null || inputString == "")
            return false;
        inputString = inputString.toLowerCase();
        Set<Character> alphabets = new HashSet<Character>();
        for (char ch : inputString.toCharArray()) {
            if(Character.isLetter(ch))
            alphabets.add(ch);
        }
        return alphabets.size()==26;
    }
}
