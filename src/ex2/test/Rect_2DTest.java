package ex2.test;

import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {

    @Test
    void contains() {
        // Create a rectangle
        Rect_2D rectangle = new Rect_2D(new Point_2D(1, 3), new Point_2D(4, 1));

        // Test points inside and outside the rectangle
        assertTrue(rectangle.contains(new Point_2D(2, 2))); // Inside
        assertFalse(rectangle.contains(new Point_2D(5, 4))); // Outside
    }

    @Test
    void area() {
        // Create a rectangle
        Rect_2D rectangle = new Rect_2D(new Point_2D(1, 3), new Point_2D(4, 1));

        // Test the area calculation
        assertEquals(6.0, rectangle.area());
    }

    @Test
    void perimeter() {
        // Create a rectangle
        Rect_2D rectangle = new Rect_2D(new Point_2D(1, 3), new Point_2D(4, 1));

        // Test the perimeter calculation
        assertEquals(10.0, rectangle.perimeter());
    }

    @Test
    void translate() {
        // Create a rectangle
        Rect_2D rectangle = new Rect_2D(new Point_2D(1, 3), new Point_2D(4, 1));

        // Translate the rectangle
        rectangle.translate(new Point_2D(2, 2));

        // Check if the translation is correct
        assertTrue(rectangle.contains(new Point_2D(3, 5))); // Check if the translated rectangle contains the expected point
        assertTrue(rectangle.contains(new Point_2D(6, 3))); // Check if the translated rectangle contains the expected point
    }

    @Test
    void copy() {
        // Create a rectangle
        Rect_2D rectangle = new Rect_2D(new Point_2D(1, 3), new Point_2D(4, 1));

        // Create a copy of the rectangle
        Rect_2D copiedRectangle = (Rect_2D) rectangle.copy();

        // Ensure the copied rectangle contains the same points as the original
        assertTrue(copiedRectangle.contains(new Point_2D(1, 3))); // Check if the copied rectangle contains the top-left point of the original
        assertTrue(copiedRectangle.contains(new Point_2D(4, 1))); // Check if the copied rectangle contains the bottom-right point of the original
    }

    @Test
    void scale() {
        // Create a rectangle
        Rect_2D rectangle = new Rect_2D(new Point_2D(1, 3), new Point_2D(4, 1));

        // Scale the rectangle
        rectangle.scale(new Point_2D(2, 2), 2.0);

        // Check if the scaling is correct
        assertTrue(rectangle.contains(new Point_2D(0, 4))); // Check if the scaled rectangle contains the expected point
        assertTrue(rectangle.contains(new Point_2D(6, 0))); // Check if the scaled rectangle contains the expected point

    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(1, 0);
        Point_2D p2 = new Point_2D(1,1);
        Rect_2D rect2D = new Rect_2D(p1,p2);
        Point_2D center = new Point_2D(0.5, 0.5);
        rect2D.rotate(center,90);
        Point_2D[] point2DS = rect2D.getAllPoints();
        Point_2D expectedP1 = new Point_2D(0, 1);
        Point_2D expectedP2 = new Point_2D(1, 1);
        Point_2D expectedP3 = new Point_2D(1, 1);
        Point_2D expectedP4 = new Point_2D(0, 1);
        Point_2D[] expectedArr = new Point_2D[]{expectedP1,expectedP2,expectedP3,expectedP4};
        assertArrayEquals(expectedArr,point2DS);
    }
}