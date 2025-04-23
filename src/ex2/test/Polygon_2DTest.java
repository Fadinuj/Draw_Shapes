package ex2.test;

import ex2.geo.Point_2D;
import ex2.geo.Polygon_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Polygon_2DTest {

    @Test
    void getAllPoints() {
        // Create a Polygon_2D object with known vertices
        Point_2D[] expectedPoints = {new Point_2D(0, 0), new Point_2D(1, 1), new Point_2D(2, 2)};
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(2, 2));

        // Call getAllPoints() method
        Point_2D[] actualPoints = polygon.getAllPoints();

        // Verify that the returned array of points matches the expected array of points
        assertArrayEquals(expectedPoints, actualPoints);
    }

    @Test
    void add() {
        // Create a Polygon_2D object
        Polygon_2D polygon = new Polygon_2D();

        // Add points to the polygon
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(2, 2));

        // Get all points from the polygon
        Point_2D[] points = polygon.getAllPoints();

        // Verify that the points are correctly added
        assertEquals(3, points.length);
        assertEquals(new Point_2D(0, 0), points[0]);
        assertEquals(new Point_2D(1, 1), points[1]);
        assertEquals(new Point_2D(2, 2), points[2]);
    }
    @Test
    void contains() {
        // Create a Polygon_2D object with known vertices
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 2));
        polygon.add(new Point_2D(2, 2));
        polygon.add(new Point_2D(2, 0));

        // Test points that are inside and outside the polygon
        Point_2D insidePoint = new Point_2D(1, 1);
        Point_2D outsidePoint = new Point_2D(3, 3);

        // Verify that the contains method returns true for the inside point and false for the outside point
        assertTrue(polygon.contains(insidePoint));
        assertFalse(polygon.contains(outsidePoint));
    }

    @Test
    void area() {
        // Create a pentagon
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(6, 3);
        Point_2D p4 = new Point_2D(2, 5);
        Point_2D p5 = new Point_2D(0, 3);
        Point_2D[] point2DS = new Point_2D[]{p1, p2, p3, p4, p5};
        Polygon_2D pentagon = new Polygon_2D(point2DS);

        // Calculate the expected area of the pentagon (using the formula for the area of a general polygon)
        double expectedArea = 0.5 * Math.abs(
                (p1.x() * p2.y() + p2.x() * p3.y() + p3.x() * p4.y() + p4.x() * p5.y() + p5.x() * p1.y()) -
                        (p2.x() * p1.y() + p3.x() * p2.y() + p4.x() * p3.y() + p5.x() * p4.y() + p1.x() * p5.y())
        );

        // Test the area calculation
        assertEquals(expectedArea, pentagon.area(), 0.0001);
    }

    @Test
    void perimeter() {
        // Create a pentagon
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(6, 3);
        Point_2D p4 = new Point_2D(2, 5);
        Point_2D p5 = new Point_2D(0, 3);
        Point_2D[] point2DS = new Point_2D[]{p1, p2, p3, p4, p5};

        Polygon_2D pentagon = new Polygon_2D(point2DS);

        // Calculate the expected perimeter of the pentagon
        double expectedPerimeter = p1.distance(p2) + p2.distance(p3) + p3.distance(p4) + p4.distance(p5) + p5.distance(p1);

        // Test the perimeter calculation
        assertEquals(expectedPerimeter, pentagon.perimeter(), 0.0001); // Use a delta for double comparison

    }

    @Test
    void translate() {
        // Create a pentagon
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(6, 3);
        Point_2D p4 = new Point_2D(2, 5);
        Point_2D p5 = new Point_2D(0, 3);
        Point_2D[] point2DS = new Point_2D[]{p1, p2, p3, p4, p5};

        Polygon_2D pentagon = new Polygon_2D(point2DS);

        // Define the translation vector
        Point_2D translationVector = new Point_2D(2, 3);

        // Translate the pentagon
        pentagon.translate(translationVector);

        // Define the expected coordinates after translation
        Point_2D expectedP1 = new Point_2D(2, 3);
        Point_2D expectedP2 = new Point_2D(6, 3);
        Point_2D expectedP3 = new Point_2D(8, 6);
        Point_2D expectedP4 = new Point_2D(4, 8);
        Point_2D expectedP5 = new Point_2D(2, 6);

        // Get the actual coordinates of the translated pentagon
        Point_2D[] actualPoints = pentagon.getAllPoints();

        // Test each vertex to ensure it has been correctly translated
        assertEquals(expectedP1, actualPoints[0]);
        assertEquals(expectedP2, actualPoints[1]);
        assertEquals(expectedP3, actualPoints[2]);
        assertEquals(expectedP4, actualPoints[3]);
        assertEquals(expectedP5, actualPoints[4]);

    }

    @Test
    void copy() {
        // Create a Polygon_2D object with known vertices
        Polygon_2D originalPolygon = new Polygon_2D();
        originalPolygon.add(new Point_2D(0, 0));
        originalPolygon.add(new Point_2D(0, 2));
        originalPolygon.add(new Point_2D(2, 2));
        originalPolygon.add(new Point_2D(2, 0));

        // Create a copy of the original polygon
        Polygon_2D copiedPolygon = (Polygon_2D) originalPolygon.copy();

        // Verify that the copied polygon is not the same object as the original polygon
        assertNotSame(originalPolygon, copiedPolygon);

        // Verify that the copied polygon has the same vertices as the original polygon
        assertArrayEquals(originalPolygon.getAllPoints(), copiedPolygon.getAllPoints());
    }

    @Test
    void scale() {
        // Create a pentagon
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(6, 3);
        Point_2D p4 = new Point_2D(2, 5);
        Point_2D p5 = new Point_2D(0, 3);
        Point_2D[] point2DS = new Point_2D[]{p1, p2, p3, p4, p5};
        Polygon_2D pentagon = new Polygon_2D(point2DS);

        // Define the center point for scaling
        Point_2D center = new Point_2D(2, 2);

        // Define the scale ratio
        double ratio = 2.0;

        // Scale the pentagon
        pentagon.scale(center, ratio);

        // Define the expected coordinates after scaling
        Point_2D expectedP1 = new Point_2D(-2, -2);
        Point_2D expectedP2 = new Point_2D(6, -2);
        Point_2D expectedP3 = new Point_2D(10, 4);
        Point_2D expectedP4 = new Point_2D(2, 8);
        Point_2D expectedP5 = new Point_2D(-2, 4);

        // Get the actual coordinates of the scaled pentagon
        Point_2D[] actualPoints = pentagon.getAllPoints();

        // Test each vertex to ensure it has been correctly scaled
        assertEquals(expectedP1, actualPoints[0]);
        assertEquals(expectedP2, actualPoints[1]);
        assertEquals(expectedP3, actualPoints[2]);
        assertEquals(expectedP4, actualPoints[3]);
        assertEquals(expectedP5, actualPoints[4]);
    }

    @Test
    void rotate() {
        // Create a pentagon
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(6, 3);
        Point_2D p4 = new Point_2D(2, 3);
        Point_2D p5 = new Point_2D(6, 4);
        Point_2D[] point2DS = new Point_2D[]{p1, p2, p3, p4, p5};
        Polygon_2D pentagon = new Polygon_2D(point2DS);

        // Define the center point for rotation
        Point_2D center = new Point_2D(2, 2);

        // Define the angle of rotation in degrees
        double angleDegrees = 90.0;

        // Rotate the pentagon
        pentagon.rotate(center, angleDegrees);

        // Define the expected coordinates after rotation
        Point_2D expectedP1 = new Point_2D(4, 0);
        Point_2D expectedP2 = new Point_2D(4, 4);
        Point_2D expectedP3 = new Point_2D(1, 6);
        Point_2D expectedP4 = new Point_2D(1, 2);
        Point_2D expectedP5 = new Point_2D(0, 6);

        // Get the actual coordinates of the rotated pentagon
        Point_2D[] actualPoints = pentagon.getAllPoints();

        // Test each vertex to ensure it has been correctly rotated
        assertEquals(expectedP1, actualPoints[0]);
        assertEquals(expectedP2, actualPoints[1]);
        assertEquals(expectedP3, actualPoints[2]);
        assertEquals(expectedP4, actualPoints[3]);
        assertEquals(expectedP5, actualPoints[4]);
    }

}