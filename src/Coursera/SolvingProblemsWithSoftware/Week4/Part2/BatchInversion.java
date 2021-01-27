package Coursera.SolvingProblemsWithSoftware.Week4.Part2;

import Coursera.SolvingProblemsWithSoftware.edu.duke.DirectoryResource;
import Coursera.SolvingProblemsWithSoftware.edu.duke.ImageResource;
import Coursera.SolvingProblemsWithSoftware.edu.duke.Pixel;

import java.io.File;

public class BatchInversion {
    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage);

        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int r = ((Pixel) inPixel).getRed();
            int g = inPixel.getGreen();
            int b = inPixel.getBlue();

            pixel.setRed(255 - r);
            pixel.setGreen(255 - g);
            pixel.setBlue(255 - b);
        }

        return outImage;
    }

    void testSingle() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeInversion(ir);
        gray.draw();
    }

    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeInversion(inImage);

            String fileName = inImage.getFileName();
            String newFileName = "inverted-" + fileName;

            outImage.setFileName(newFileName);
            outImage.save();
        }
    }

    public static void main(String args[]) {
        BatchInversion obj = new BatchInversion();
        obj.testSingle();
        obj.selectAndConvert();
    }
}
