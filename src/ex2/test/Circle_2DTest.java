package ex2.test;

import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Circle_2DTest {

    @Test
    void getRadius() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);
        assertEquals(5, circle.getRadius());
    }

    @Test
    void getCenter() {
        Point_2D center = new Point_2D(3, 4);
        Circle_2D circle = new Circle_2D(center, 5);
        assertEquals(center, circle.getCenter());
    }

    @Test
    void testToString() {

    }

    @Test
    void contains() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);
        Point_2D insidePoint = new Point_2D(3, 4);
        Point_2D outsidePoint = new Point_2D(6, 7);
        assertTrue(circle.contains(insidePoint));
        assertFalse(circle.contains(outsidePoint));
    }

    @Test
    void area() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);
        assertEquals(78.53981633974483, circle.area());
    }

    @Test
    void perimeter() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);
        assertEquals(31.41592653589793, circle.perimeter());
    }

    @Test
    void translate() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);
        Point_2D translationVector = new Point_2D(1, 1);
        circle.translate(translationVector);
        assertEquals(new Point_2D(1, 1), circle.getCenter());
    }

    @Test
    void copy() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);
        Circle_2D copy = (Circle_2D) circle.copy();
        assertEquals(circle.getCenter(), copy.getCenter());
        assertEquals(circle.getRadius(), copy.getRadius());
        assertNotSame(circle, copy);
    }

    @Test
    void scale() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);

        double ratio = 2;
        circle.scale(center, ratio);

        // After scaling with ratio=2, new radius should be 10
        assertEquals(10, circle.getRadius());
    }

    @Test
    void rotate() {
        Point_2D center = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(center, 5);
        Point_2D rotationCenter = new Point_2D(1, 1);
        double angleDegrees = 90;
        circle.rotate(rotationCenter, angleDegrees);
        assertEquals(new Point_2D(2, 0), circle.getCenter());
    }
}