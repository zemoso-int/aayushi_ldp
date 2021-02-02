package Assignment2;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCheckerTest {
    StringChecker stringChecker = new StringChecker();

    @Test
    public void checkNullString() {
        assertFalse(stringChecker.areAllAlphabetsPresent(null));
    }

    @Test
    public void checkEmptyString(){
        String s= "";
        assertFalse(stringChecker.areAllAlphabetsPresent(s));
    }

    @Test
    public void checkerStringWithAllAlphabetsPresentLowerCase() {
        String s="the quick brown fox jumps over the lazy dog";
        assertTrue(stringChecker.areAllAlphabetsPresent(s));
    }
    @Test
    public void checkStringWithAllAlphabetsPresentUpperCase(){
        String s= "PACK MY BOX WITH FIVE DOZEN LIQUOR JUGS";
        assertTrue(stringChecker.areAllAlphabetsPresent(s));
    }

    @Test
    public void checkStringWithAllAlphabetsPresentMixedCase(){
        String s= "Pack my BOX with five dozen liquor jugs";
        assertTrue(stringChecker.areAllAlphabetsPresent(s));
    }


    @Test
    public void checkNumericString() {
        String s="1234567";
        assertFalse(stringChecker.areAllAlphabetsPresent(s));
    }
    @Test
    public void checkerAlphanumericString() {
        String s="I don't contain all 26  characters";
        assertFalse(stringChecker.areAllAlphabetsPresent(s));
    }
}