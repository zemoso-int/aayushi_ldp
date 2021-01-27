package Coursera.SolvingProblemsWithSoftware.Week4.Part2;

import Coursera.SolvingProblemsWithSoftware.edu.duke.DirectoryResource;
import Coursera.SolvingProblemsWithSoftware.edu.duke.ImageResource;
import Coursera.SolvingProblemsWithSoftware.edu.duke.Pixel;

import java.io.File;

public class BatchGrayscale {
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage);

        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int r = inPixel.getRed();
            int g = inPixel.getGreen();
            int b = inPixel.getBlue();
            int average = (r + g + b) / 3;

            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }

        return outImage;
    }

    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeGray(inImage);

            String fileName = inImage.getFileName();
            String newFileName = "gray-" + fileName;

            outImage.setFileName(newFileName);
            outImage.save();
        }
    }

    void testSingle() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }

    public static void main(String args[]) {
        BatchGrayscale obj = new BatchGrayscale();
        obj.testSingle();
        obj.selectAndConvert();
    }
}
