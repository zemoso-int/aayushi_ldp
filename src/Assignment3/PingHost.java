package Assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingHost {

    static float computeMedianOfTimeToPing(String host) throws IOException {
        int pingCount = 2, index = 0;
        String line;

        //array to store time taken to ping each time
        float pingTimeArray[] = new float[pingCount];
        String numPings = String.valueOf(pingCount);
        ProcessBuilder process = new ProcessBuilder("ping", "-c", numPings, host);
        Process pingProcess = process.start();

        //reading the output of command after running
        BufferedReader commandOutput = new BufferedReader(new InputStreamReader(pingProcess.getInputStream()));

        //forming the RegEx to find time from output line
        Pattern pattern = Pattern.compile("time=([0-9]+[.]?[0-9]*)");

        while ((line = commandOutput.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                //extract the time value in string format
                String pingTime = matcher.group();
                float time = Float.parseFloat(pingTime);
                pingTimeArray[index++] = time;
            }
        }
        //sort the array having ping time
        Arrays.sort(pingTimeArray);
        int length = pingTimeArray.length;
        int midIndex = length / 2;
        if (length % 2 == 0) {
            return (pingTimeArray[midIndex] + pingTimeArray[midIndex - 1]) / 2;
            //finding median in case of odd no of terms (midTerm)
        } else {
            return pingTimeArray[midIndex];
        }
    }
}
