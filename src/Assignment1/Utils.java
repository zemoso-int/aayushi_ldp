package Assignment1;

public class Utils {
    /**
     * Checks whether the input is Exit or not
     * @param input Actual input passed
     * @return true if input is exit (Case insensitive), false otherwise
     */
    public static boolean shouldExit(String input){
        if(input == null){
            return false;
        }
        return input.equalsIgnoreCase("exit");
    }
}
