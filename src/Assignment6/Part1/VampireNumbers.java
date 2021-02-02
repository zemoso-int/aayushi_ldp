package Assignment6.Part1;

import java.util.ArrayList;
import java.util.Arrays;

public class VampireNumbers {
    public static boolean isVampirePair(int a,int b,int num){
        String val1=String.valueOf(a);
        String val2=String.valueOf(b);
        String vampire=String.valueOf(num);
        if((val1.length()!=val2.length()) || (val1.endsWith("0") && val2.endsWith("0")))
            return false;
        String vals=val1+val2;
        char tempArray[] = vals.toCharArray();
        Arrays.sort(tempArray);
        char vamArray[]=vampire.toCharArray();
        Arrays.sort(vamArray);
        vals=new String(tempArray);
        vampire=new String(vamArray);
        if(vals.equals(vampire))
            return true;
        return false;
    }
    public static boolean isDigitCountOdd(int num){
        String s=String.valueOf(num);
        if((s.length()&1)==1)
            return true;
        return false;
    }
    public static boolean isVampire(int num){
        int a,b;
        if(isDigitCountOdd(num))
            return false;
        for(int k=1;k*k<=num;k++){
            if(num%k==0) {
                a = k;
                b = num / a;
                if(isVampirePair(a, b,num))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> vampireNumbers=new ArrayList<>();
        /*starting from 4 digit no. as 1 & 3 digit no. cannot be vampire no. nor any two digit no. can be vampiire as no multiplication of two digit
         give the no. with same digits */
        for(int i=1000;vampireNumbers.size()<100;i++)
            if(isVampire(i))
                vampireNumbers.add(i);
        for(int i=0;i<vampireNumbers.size();i++)
            System.out.println("Vampire number "+(i+1)+" is "+vampireNumbers.get(i));
        System.out.println(isVampire(1390));
    }
}
