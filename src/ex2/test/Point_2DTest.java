package ex2.test;

import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {

    @Test
    void x()
    {
        Point_2D point = new Point_2D(3,5);
        assertEquals(3,point.x());
    }

    @Test
    void y()
    {
        Point_2D point = new Point_2D(3,5);
        assertEquals(5,point.y());
    }

    @Test
    void ix()
    {
        Point_2D point = new Point_2D(5.444,6);
        assertEquals(5,point.ix());
    }

    @Test
    void iy()
    {
        Point_2D point = new Point_2D(5.444,6.666);
        assertEquals(6,point.iy());
    }

    @Test
    void add()
    {
        Point_2D point = new Point_2D(3,5);
        point = point.add(new Point_2D(4,7));
        assertEquals(7, point.x());
        assertEquals(12, point.y());
    }

    @Test
    void testToString()
    {
        Point_2D point = new Point_2D(3.0, 4.0);
        assertEquals(3.0+","+4.0, point.toString());
    }

    @Test
    void distance()
    {
        Point_2D point1 = new Point_2D(0.0, 0.0);
        Point_2D point2 = new Point_2D(3.0, 4.0);
        assertEquals(5.0, point1.distance(point2));
    }

    @Test
    void testDistance()
    {
        Point_2D point1 = new Point_2D(7, 9);
        Point_2D point2 = new Point_2D(7, 4.0);
        assertEquals(5,point1.distance(point2));
    }

    @Test
    void testEquals()
    {
        Point_2D point1 = new Point_2D(3.0, 4.0);
        Point_2D point2 = new Point_2D(3.0, 4.0);

        assertTrue(point1.equals(point2));
    }

    @Test
    void close2equals()
    {
        Point_2D point1 = new Point_2D(1.0, 2.0);
        Point_2D point2 = new Point_2D(1.001, 2.001);

        assertTrue(point1.close2equals(point2, 0.01));

        Point_2D point3 = new Point_2D(1.0, 2.0);
        Point_2D point4 = new Point_2D(1.1, 2.1);

        assertFalse(point3.close2equals(point4, 0.01));
    }

    @Test
    void vector()
    {
        Point_2D point1 = new Point_2D(1.0, 2.0);
        Point_2D point2 = new Point_2D(3.0, 4.0);

        Point_2D vector = point1.vector(point2);

        assertEquals(2.0, vector.x());
        assertEquals(2.0, vector.y());
    }

    @Test
    void move()
    {
        Point_2D point = new Point_2D(1.0, 2.0);

        Point_2D displacement = new Point_2D(3.0, 4.0);

        point.move(displacement);

        assertEquals(4.0, point.x());
        assertEquals(6.0, point.y());
    }

    @Test
    void scale()
    {
        Point_2D center = new Point_2D(2.0, 3.0);

        Point_2D point = new Point_2D(4.0, 6.0);

        double ratio = 2.0;

        point.scale(center, ratio);

        assertEquals(2,3, center.distance(point));
    }

    @Test
    void rotate()
    {
        Point_2D center = new Point_2D(2.0, 3.0);

        Point_2D point = new Point_2D(4.0, 5.0);

        double angleDegrees = 90.0;

        point.rotate(center, angleDegrees);

        assertEquals(0.0, point.x());
        assertEquals(5.0, point.y());
    }
}