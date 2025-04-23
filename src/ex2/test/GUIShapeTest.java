package ex2.test;

import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GUIShapeTest {

    @Test
    void getShape() {
        // Create a known GeoShape
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(4, 4));

        // Create a GUIShape with the known GeoShape
        GUIShape guiShape = new GUIShape(rect, true, Color.RED, 0);

        // Retrieve the GeoShape from the GUIShape
        //Rect_2D retrievedShape = (Rect_2D) guiShape.getShape();

        // Verify if the retrieved shape matches the expected shape
        assertEquals(rect.toString(), guiShape.getShape().toString());
    }

    @Test
    void setShape() {
        // Create a GeoShape object
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        Circle_2D circle = new Circle_2D(new Point_2D(0, 0), 1);

        // Create a GUIShape object
        GUIShape guiShape = new GUIShape(rect, true, Color.RED, 0);

        // Set a new shape
        guiShape.setShape(circle);

        // Test the setShape() method
        assertEquals(circle, guiShape.getShape());
    }

    @Test
    void isFilled() {
        // Create a GUIShape object with fill status true
        GUIShape filledShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);

        // Test isFilled() method for true
        assertTrue(filledShape.isFilled());

        // Create a GUIShape object with fill status false
        GUIShape notFilledShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), false, Color.RED, 0);

        // Test isFilled() method for false
        assertFalse(notFilledShape.isFilled());
    }

    @Test
    void setFilled() {
        // Create a GUIShape object with fill status true
        GUIShape guiShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);

        // Set fill status to false
        guiShape.setFilled(false);

        // Test the setFilled() method
        assertFalse(guiShape.isFilled());
    }

    @Test
    void getColor() {
        // Create a GUIShape object with a specific color
        Color color = Color.RED;
        GUIShape guiShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, color, 0);

        // Test the getColor() method
        assertEquals(color, guiShape.getColor());
    }

    @Test
    void setColor() {
        // Create a GUIShape object with an initial color
        GUIShape guiShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);

        // Set a new color
        Color newColor = Color.BLUE;
        guiShape.setColor(newColor);

        // Test the setColor() method
        assertEquals(newColor, guiShape.getColor());
    }

    @Test
    void getTag() {
        // Create a GUIShape object with a specific tag
        int tag = 5;
        GUIShape guiShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, tag);

        // Test the getTag() method
        assertEquals(tag, guiShape.getTag());
    }

    @Test
    void setTag() {
        // Create a GUIShape object with an initial tag
        GUIShape guiShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);

        // Set a new tag
        int newTag = 10;
        guiShape.setTag(newTag);

        // Test the setTag() method
        assertEquals(newTag, guiShape.getTag());
    }

    @Test
    void copy() {
        // Create a GUIShape object
        GUIShape original = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);

        // Create a copy of the GUIShape object
        GUIShape copy = (GUIShape) original.copy();

        // Test the copy() method
        assertNotSame(original, copy); // Ensure they are not the same object
    }

    @Test
    void isSelected() {
        // Create a GUIShape object with isSelected set to true
        GUIShape selectedShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);
        selectedShape.setSelected(true);

        // Test isSelected() method when isSelected is true
        assertTrue(selectedShape.isSelected());

        // Create a GUIShape object with isSelected set to false
        GUIShape notSelectedShape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);
        notSelectedShape.setSelected(false);

        // Test isSelected() method when isSelected is false
        assertFalse(notSelectedShape.isSelected());
    }

    @Test
    void setSelected() {
        // Create a GUIShape object
        GUIShape shape = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, Color.RED, 0);

        // Initially, the shape should not be selected
        assertFalse(shape.isSelected());

        // Set the shape as selected
        shape.setSelected(true);

        // Verify that the shape is now selected
        assertTrue(shape.isSelected());

        // Set the shape as not selected
        shape.setSelected(false);

        // Verify that the shape is now not selected
        assertFalse(shape.isSelected());
    }
}