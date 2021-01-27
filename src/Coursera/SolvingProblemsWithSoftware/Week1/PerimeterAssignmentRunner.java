package Coursera.SolvingProblemsWithSoftware.Week1;

import Coursera.SolvingProblemsWithSoftware.edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    //Assignment 1: Task 1
    public int getNumPoints (Shape s) {
        int numPointsCount=0;
        for(Point p:s.getPoints())
            numPointsCount+=1;
        return numPointsCount;
    }

    //Assignment 1 - Task 2
    public double getAverageLength(Shape s) {
        return getPerimeter(s)/getNumPoints(s);
    }

    //Assignment 1 - Task 3
    public double getLargestSide(Shape s) {
        Point prevPoint=s.getLastPoint();
        double largestSide=Double.MIN_VALUE;
        for(Point currPoint: s.getPoints()){
            double currDist=prevPoint.distance(currPoint);
            largestSide=(largestSide>currDist)?largestSide:currDist;
            prevPoint=currPoint;
        }
        return largestSide;
    }

    //Assignment 1 - Task 4
    public double getLargestX(Shape s) {
        double largestX=Double.MIN_VALUE;
        for(Point p:s.getPoints()){
            largestX=(p.getX()>largestX)?p.getX():largestX;
        }
        return largestX;
    }

    // Assignment 2 - Task 1
    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter=0.0;
        for(File f: dr.selectedFiles()) {
            FileResource fr=new FileResource(f);
            Shape s=new Shape(fr);
            largestPerimeter=getPerimeter(s)>largestPerimeter?getPerimeter(s):largestPerimeter;
        }
        return largestPerimeter;
    }

    //Assignment 2 - Task 2
    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double maxPerimeter = 0;
        File fileReference=null;
        for(File f:dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerimeter = getPerimeter(s);
            if(maxPerimeter<currentPerimeter){
                maxPerimeter = currentPerimeter;
                fileReference = f;
            }
        }
        return fileReference.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints=getNumPoints(s);
        System.out.println("number of points in shape = " + numPoints);
        double averageLength=getAverageLength(s);
        System.out.println("average length of sides in shape = " + averageLength);
        double largestSide=getLargestSide(s);
        System.out.println("largest side in shape = " + largestSide);
        double largestX=getLargestX(s);
        System.out.println("largest x coordinate in shape = " + largestX);
    }

    public void testPerimeterMultipleFiles() {
        double largestPerimeter=getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter out of all files="+largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String fileWithLargestPerimeter=getFileWithLargestPerimeter();
        System.out.println("file with greatest perimeter="+fileWithLargestPerimeter);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}