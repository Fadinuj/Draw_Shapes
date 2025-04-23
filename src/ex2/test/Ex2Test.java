package ex2.test;

import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import ex2.geo.Triangle_2D;
import ex2.gui.Ex2;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {

    @Test
    void init() {
        Ex2 ex2 = Ex2.getInstance();
        ShapeCollection shapeCollection = new ShapeCollection();
        ShapeCollection shapeCollection1 = new ShapeCollection();

        // Call the init method with a non-null GUI_Shape_Collection parameter
        GUIShape shape1 = new GUIShape(new GUIShape(new Triangle_2D(new Point_2D(0,0),new Point_2D(1,1),new Point_2D(2,2)), true,Color.RED,1));
        GUIShape shape2 = new GUIShape(new GUIShape(new Triangle_2D(new Point_2D(5,5),new Point_2D(7,7),new Point_2D(9,9)), true,Color.BLUE,6));
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);

        ex2.init(shapeCollection);
        // Verify that the internal state is properly set after initialization
        assertNotNull(ex2.getShape_Collection());
        assertEquals(2, ex2.getShape_Collection().size());
        assertEquals(shapeCollection,ex2.getShape_Collection());

        ex2.init(shapeCollection1);
        assertEquals(Color.blue,ex2.get_color());
        assertEquals(null,ex2.get_gs());
        assertEquals(null,ex2.get_pp());
        assertEquals(null,ex2.get_p1());
        assertEquals("",ex2.get_mode());
        assertEquals(false,ex2.is_fill());

    }

    @Test
    void getShape_Collection()
    {
        // Create an instance of Ex2
        Ex2 ex2 = Ex2.getInstance();

        // Initialize the Ex2 instance
        ex2.init(null);

        // Create two rectangles using new Point_2D for corners
        Rect_2D rect1 = new Rect_2D(new Point_2D(0, 0), new Point_2D(2, 2));
        Rect_2D rect2 = new Rect_2D(new Point_2D(3, 3), new Point_2D(5, 5));

        // Create GUI_Shape instances for the rectangles
        GUIShape shape1 = new GUIShape(rect1, false, Color.RED, 0);
        GUIShape shape2 = new GUIShape(rect2, false, Color.BLUE, 0);

        // Get the shape collection
        GUI_Shape_Collection shapeCollection = ex2.getShape_Collection();

        // Add the rectangles to the shape collection
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);

        // Verify the size of the shape collection
        assertEquals(2, shapeCollection.size());
        assertEquals(shapeCollection,ex2.getShape_Collection());
    }

    @Test
    void getInfo()
    {
        Ex2 ex2 = Ex2.getInstance();

        // Create a new shape collection
        GUI_Shape_Collection shapeCollection = new ShapeCollection();

        // Add some shapes to the collection
        shapeCollection.add(new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 1));
        shapeCollection.add(new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(10, 5)), false, Color.BLUE, 2));
        shapeCollection.add(new GUIShape(new Triangle_2D(new Point_2D(0, 0), new Point_2D(5, 0), new Point_2D(0, 5)), true, Color.GREEN, 3));

        // Set the shape collection in the Ex2 instance
        ex2.init(shapeCollection);

        // Expected info string
        String expectedInfo = "GUIShape,16711680,true,1,Circle_2D,0.0,0.0, 5.0\n" +
                "GUIShape,255,false,2,Rect_2D,0.0,5.0,0.0,0.0,10.0,0.0,10.0,5.0\n" +
                "GUIShape,65280,true,3,Triangle_2D,0.0,0.0,5.0,0.0,0.0,5.0\n";

        // Verify that the getInfo method returns the expected info string
        assertEquals(expectedInfo, ex2.getInfo());
    }
}