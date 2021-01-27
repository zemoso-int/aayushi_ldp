package Coursera.SolvingProblemsWithSoftware.Week2.StringsFirstAssignments;

public class Part3{
    boolean twoOccurrences(String stringa, String stringb){
        System.out.println("\""+stringb+"\" contains \""+ stringa + "\" at least twice: ");
        int one=stringb.indexOf(stringa);
        int two=stringb.lastIndexOf(stringa);
        if(one!=two)
            return true;
        else
            return false;
    }

    String lastPart(String stringa, String stringb) {
        System.out.println("Part in \""+stringb+ "\" after \""+ stringa + "\"");
        int index=stringb.indexOf(stringa);
        if(index==-1){
            return stringb;
        }
        return stringb.substring(index+stringa.length());

    }
    void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println("-----------------------------------------\n\n");
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println("-----------------------------------------\n\n");
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        System.out.println("-----------------------------------------\n\n");
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        System.out.println("-----------------------------------------\n\n");
        System.out.println(twoOccurrences("atg", "ctgtatfgta"));
        System.out.println("-----------------------------------------\n\n");

        System.out.println(lastPart("an", "banana") );
        System.out.println("-----------------------------------------\n\n");
        System.out.println(lastPart("zoo", "forest") );
        System.out.println("-----------------------------------------\n\n");
        System.out.println(lastPart("atg", "bathjatgatg") );
        System.out.println("-----------------------------------------\n\n");
        System.out.println(lastPart("zoo", "zotoozoo") );
        System.out.println("-----------------------------------------\n\n");
    }
    public static void main(String args[])
    {
        new Part3().testing();
    }

}