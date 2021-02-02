package Assignment1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchFileInDirectoryTest {
    SearchFileInDirectory searchFileInDirectory = new SearchFileInDirectory();

    @Test
    public void checkEmptyPath() {
        searchFileInDirectory.findAndPrintFiles("Screenshot", "");
        assertEquals(0, searchFileInDirectory.fileCount);

    }

    @Test
    public void checkEmptyRegex() {
        searchFileInDirectory.findAndPrintFiles("", "/home");
        assertEquals(0, searchFileInDirectory.fileCount);

    }

    @Test
    public void checkEmptyPathAndRegex() {
        searchFileInDirectory.findAndPrintFiles("", "");
        assertEquals(0, searchFileInDirectory.fileCount);

    }

    @Test
    public void checkFilesPresentWithRegex() {
        searchFileInDirectory.findAndPrintFiles("Screenshot", "/home");
        assertEquals(14, searchFileInDirectory.fileCount);

    }

    @Test
    public void checkFilesPresentWithRegex1() {
        searchFileInDirectory.findAndPrintFiles("srp", "/home");
        assertEquals(8, searchFileInDirectory.fileCount);

    }

    @Test
    public void checkFilesNotPresentWithRegex() {
        searchFileInDirectory.findAndPrintFiles("axyz", "/home");
        assertEquals(0, searchFileInDirectory.fileCount);

    }

}