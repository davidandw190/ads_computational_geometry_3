package org.cg;

import java.util.List;

public class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Computes the area of a convex polygon defined by its vertices in clockwise order.
     *
     * @param vertices The list of vertices of the convex polygon.
     * @return The area of the convex polygon.
     */
    public static double area(List<Point> vertices) {
        int n = vertices.size();
        if (n < 3) {
            throw new IllegalArgumentException("A convex polygon must have at least 3 vertices.");
        }

        double totalArea = 0.0;

        for (int i = 1; i <= n - 2; i++) {
            double x1 = vertices.get(0).x;
            double y1 = vertices.get(0).y;
            double x2 = vertices.get(i).x;
            double y2 = vertices.get(i).y;
            double x3 = vertices.get(i + 1).x;
            double y3 = vertices.get(i + 1).y;

            double triangleArea = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
            totalArea += triangleArea;
        }

        return totalArea;
    }

    /**
     * Computes the perimeter of a convex polygon defined by its vertices in clockwise order.
     *
     * @param vertices The list of vertices of the convex polygon.
     * @return The perimeter of the convex polygon.
     */
    public static double perimeter(List<Point> vertices) {
        int n = vertices.size();
        if (n < 2) {
            throw new IllegalArgumentException("A convex polygon must have at least 2 vertices.");
        }

        double totalPerimeter = 0.0;

        for (int i = 0; i < n - 1; i++) {
            double x1 = vertices.get(i).x;
            double y1 = vertices.get(i).y;
            double x2 = vertices.get(i + 1).x;
            double y2 = vertices.get(i + 1).y;

            double edgeLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            totalPerimeter += edgeLength;
        }

        // to add the distance between the last and first vertices to close the polygon
        double x1 = vertices.get(n - 1).x;
        double y1 = vertices.get(n - 1).y;
        double x2 = vertices.get(0).x;
        double y2 = vertices.get(0).y;

        double edgeLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        totalPerimeter += edgeLength;

        return totalPerimeter;
    }
}
