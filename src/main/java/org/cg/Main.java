package org.cg;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Point> polygonVertices = new ArrayList<>();
        polygonVertices.add(new Point(0, 0));
        polygonVertices.add(new Point(4, 0));
        polygonVertices.add(new Point(4, 3));
        polygonVertices.add(new Point(2, 5));
        polygonVertices.add(new Point(0, 3));

        double area = Point.area(polygonVertices);
        System.out.println("Area of the convex polygon: " + area);

        double perimeter = Point.perimeter(polygonVertices);
        System.out.println("Perimeter of the convex polygon: " + perimeter);

        if (isSquare(area, perimeter)) {
            System.out.println("The convex polygon is a square.");
        } else {
            System.out.println("The convex polygon is not a square.");
        }
    }


    private static boolean isSquare(double area, double perimeter) {
        double sideLength = perimeter / 4.0;
        double expectedArea = sideLength * sideLength;

        double tolerance = 0.0001;
        return Math.abs(area - expectedArea) < tolerance;
    }
}