package ex2.test;

import ex2.ex2.Ex2_Const;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;

import static org.junit.jupiter.api.Assertions.*;

class Segment_2DTest {
    private Segment_2D s1=new Segment_2D(Point_2D.ORIGIN,new Point_2D(0,1));
    private Point_2D p1=new Point_2D(1,0);
    private Point_2D p2=new Point_2D(5,3);
    private Segment_2D s2=new Segment_2D(p1,p2);

    @org.junit.jupiter.api.Test
    void get_p1() {
        Segment_2D segment1 = new Segment_2D(new Point_2D(2, 3), new Point_2D(5, 7));
        assertEquals(new Point_2D(2, 3), segment1.get_p1());
    }

    @org.junit.jupiter.api.Test
    void get_p2() {
        Segment_2D segment1 = new Segment_2D(new Point_2D(2, 3), new Point_2D(5, 7));
        assertEquals(new Point_2D(5, 7), segment1.get_p2());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        Point_2D q0=new Point_2D(0,0.4);
        boolean b1=s1.contains(q0);
        assertTrue(b1);

        q0=new Point_2D(0,1.3);
        b1=s1.contains(q0);
        assertFalse(b1);

         q0=new Point_2D(3,1.5);
         b1=s2.contains(q0);
        assertTrue(b1);

        q0=new Point_2D(2.8,1.5);
        b1=s2.contains(q0);
        assertFalse(b1);
    }

    @org.junit.jupiter.api.Test
    void area() {
    }

    @org.junit.jupiter.api.Test
    void perimeter() {
        // Test for a horizontal segment
        Segment_2D horizontalSegment = new Segment_2D(new Point_2D(0, 0), new Point_2D(5, 0));
        assertEquals(5, horizontalSegment.perimeter());

        // Test for a vertical segment
        Segment_2D verticalSegment = new Segment_2D(new Point_2D(0, 0), new Point_2D(0, 8));
        assertEquals(8, verticalSegment.perimeter());

        // Test for a diagonal segment
        Segment_2D diagonalSegment = new Segment_2D(new Point_2D(0, 0), new Point_2D(3, 4));
        assertEquals(5, diagonalSegment.perimeter());
    }

    @org.junit.jupiter.api.Test
    void translate() {
        s1.translate(new Point_2D(1, 1)); // Translate by (1, 1)
        assertEquals(s1.get_p1(), new Point_2D(1, 1)); // (0, 1) translated by (1, 1) = (1, 2)
        assertEquals(s1.get_p2(), new Point_2D(1, 2)); // (0, 2) translated by (1, 1) = (1, 3)

        s2.translate(new Point_2D(-2, -2)); // Translate by (-2, -2)
        assertEquals(s2.get_p1(), new Point_2D(-1, -2)); // (1, 0) translated by (-2, -2) = (-1, -2)
        assertEquals(s2.get_p2(), new Point_2D(3, 1)); // (5, 3) translated by (-2, -2) = (3, 1)

    }

    @org.junit.jupiter.api.Test
    void copy() {
        Segment_2D s1_copy = (Segment_2D) s1.copy();
        assertNotSame(s1, s1_copy); // Not the same object reference
        assertEquals(s1.get_p1(), s1_copy.get_p1()); // Equal starting points
        assertEquals(s1.get_p2(), s1_copy.get_p2()); // Equal ending points

        Segment_2D s2_copy = (Segment_2D) s2.copy();
        assertNotSame(s2, s2_copy); // Not the same object reference
        assertEquals(s2.get_p1(), s2_copy.get_p1()); // Equal starting points
        assertEquals(s2.get_p2(), s2_copy.get_p2()); // Equal ending points

    }

    @org.junit.jupiter.api.Test
    void scale() {
        Segment_2D s1 = new Segment_2D(new Point_2D(0, 0), new Point_2D(4, 0));
        s1.scale(new Point_2D(2, 0), 2);
        assertEquals(new Point_2D(-2, 0), s1.get_p1());
        assertEquals(new Point_2D(6, 0), s1.get_p2());

        Segment_2D s2 = new Segment_2D(new Point_2D(1, 1), new Point_2D(3, 3));
        s2.scale(new Point_2D(3, 3), 0.5);
        assertEquals(new Point_2D(2, 2), s2.get_p1());
        assertEquals(new Point_2D(3, 3), s2.get_p2());
    }

    @org.junit.jupiter.api.Test
    void rotate() {
        Segment_2D s1 = new Segment_2D(new Point_2D(6, 1), new Point_2D(4, 0));
        s1.rotate(new Point_2D(2, 0), 90);
        assertEquals(new Point_2D(1,4),s1.get_p1());
        assertEquals(new Point_2D(2,2),s1.get_p2());
    }
}