package ex2.test;

import ex2.geo.Point_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Triangle_2DTest {

    @Test
    void getAllPoints() {
        // Create a triangle with known vertices
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);

        // Get the vertices of the triangle
        Point_2D[] actualPoints = triangle.getAllPoints();

        // Assert that the actual vertices match the expected vertices
        assertArrayEquals(new Point_2D[]{p1, p2, p3}, actualPoints);

    }

    @Test
    void contains() {
        // Create a triangle with known vertices
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);

        // Create points inside and outside the triangle
        Point_2D insidePoint = new Point_2D(1, 1);
        Point_2D outsidePoint = new Point_2D(5, 5);

        // Check if the triangle contains the inside point
        boolean insideResult = triangle.contains(insidePoint);

        // Check if the triangle contains the outside point
        boolean outsideResult = triangle.contains(outsidePoint);

        // Assert that the inside point is contained within the triangle
        assertTrue(insideResult);

        // Assert that the outside point is not contained within the triangle
        assertFalse(outsideResult);

    }

    @Test
    void area() {
        // Create a triangle with known vertices
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(0, 3);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);

        // Calculate the expected area (you might need to compute this manually)
        double expectedArea = 6.0;

        // Call the area() method to get the actual area
        double actualArea = triangle.area();

        // Assert that the actual area matches the expected area
        assertEquals(expectedArea, actualArea, 0.001); // Provide a delta value for approximate comparison
    }

    @Test
    void perimeter() {
        // Create a triangle with known vertices
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);

        // Calculate the expected perimeter (you might need to compute this manually)
        double expectedPerimeter = 3 + 4 + 5; // For this example, it's a right triangle

        // Call the perimeter() method to get the actual perimeter
        double actualPerimeter = triangle.perimeter();

        // Assert that the actual perimeter matches the expected perimeter
        assertEquals(expectedPerimeter, actualPerimeter, 0.001); // Provide a delta value for approximate comparison

    }

    @Test
    void translate() {
        // Create a triangle with known vertices
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);

        // Define the translation vector
        Point_2D translationVector = new Point_2D(2, 2);

        // Translate the triangle
        triangle.translate(translationVector);

        // Calculate the expected vertices after translation
        Point_2D expectedP1 = new Point_2D(2, 2);
        Point_2D expectedP2 = new Point_2D(5, 2);
        Point_2D expectedP3 = new Point_2D(2, 6);

        // Get the actual vertices of the translated triangle
        Point_2D[] actualPoints = triangle.getAllPoints();

        // Assert that the vertices after translation match the expected vertices
        assertArrayEquals(new Point_2D[]{expectedP1, expectedP2, expectedP3}, actualPoints);
    }

    @Test
    void copy() {
        // Create a triangle with known vertices
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D originalTriangle = new Triangle_2D(p1, p2, p3);

        // Create a copy of the original triangle
        Triangle_2D copiedTriangle = (Triangle_2D) originalTriangle.copy();

        // Assert that the copied triangle is not the same instance as the original triangle
        assertNotSame(originalTriangle, copiedTriangle);

        // Assert that the vertices of the copied triangle have the same coordinates as the vertices of the original triangle
        assertArrayEquals(originalTriangle.getAllPoints(), copiedTriangle.getAllPoints());

    }

    @Test
    void scale() {
        // Create a triangle with known vertices
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);

        // Define the center point for scaling
        Point_2D center = new Point_2D(1, 1);

        // Scale the triangle by a factor of 2
        triangle.scale(center, 2);

        // Calculate the expected vertices after scaling
        Point_2D expectedP1 = new Point_2D(-1, -1);
        Point_2D expectedP2 = new Point_2D(5, -1);
        Point_2D expectedP3 = new Point_2D(-1, 7);

        // Get the actual vertices of the scaled triangle
        Point_2D[] actualPoints = triangle.getAllPoints();

        // Assert that the vertices after scaling match the expected vertices
        assertArrayEquals(new Point_2D[]{expectedP1, expectedP2, expectedP3}, actualPoints);
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(1, 1);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);
        Point_2D center = new Point_2D(1, 1);
        double angleDegrees = 90;
        triangle.rotate(center, angleDegrees);
        Point_2D expectedP1 = new Point_2D(2, 0);
        Point_2D expectedP2 = new Point_2D(2, 3);
        Point_2D expectedP3 = new Point_2D(1, 1);
        Point_2D[] actualPoints = triangle.getAllPoints();
        Point_2D[] point2DS=new Point_2D[]{expectedP1, expectedP2, expectedP3};
        assertArrayEquals(point2DS, actualPoints);
    }
}