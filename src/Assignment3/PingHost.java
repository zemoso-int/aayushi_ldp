package Assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingHost {

    /**
     * Method that pings the given hostname. It executes the ping command from the terminal and
     * time is found by reading lines from terminal. It prints the median time.
     * @param host Hostname
     * @param pingCount Number of times to ping, useful in calculating median
     */
     float computeMedianOfTimeToPing(String host, int pingCount) throws IOException {
        int pingTimeArrayIndex = 0;
        String pingOutputLine;
        float pingTimeArray[] = new float[pingCount];
        String numPings = String.valueOf(pingCount);

        ProcessBuilder process = new ProcessBuilder("ping", "-c", numPings, host);
        Process pingProcess = process.start();

        BufferedReader commandOutput = new BufferedReader(new InputStreamReader(pingProcess.getInputStream()));

        Pattern timePatternInCommandLineOutput = Pattern.compile("time=([0-9]+[.]?[0-9]*)");

        while ((pingOutputLine = commandOutput.readLine()) != null) {
            Matcher pingTimeMatcher = timePatternInCommandLineOutput.matcher(pingOutputLine);
            if (pingTimeMatcher.find()) {
                String pingTime = pingTimeMatcher.group(1);
                float time = Float.parseFloat(pingTime);
                pingTimeArray[pingTimeArrayIndex++] = time;
            }
        }
        return medianOfAnArray(pingTimeArray);
    }

    float medianOfAnArray(float numArr[]) {
        Arrays.sort(numArr);
        int length = numArr.length;
        int midIndex = length / 2;
        if (length % 2 == 0) {
            return (numArr[midIndex] + numArr[midIndex - 1]) / 2;
        } else {
            return numArr[midIndex];
        }
    }
}
