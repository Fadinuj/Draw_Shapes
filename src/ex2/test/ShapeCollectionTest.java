package ex2.test;

import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import ex2.geo.Triangle_2D;
import ex2.gui.Ex2;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectionTest {

    @Test
    void get() {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();

        // Create some shapes
        GUIShape shape1 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, null, 0);
        GUIShape shape2 = new GUIShape(new Rect_2D(new Point_2D(2, 2), new Point_2D(3, 3)), true, null, 1);
        GUIShape shape3 = new GUIShape(new Rect_2D(new Point_2D(4, 4), new Point_2D(5, 5)), true, null, 2);

        // Add the shapes to the collection
        collection.add(shape1);
        collection.add(shape2);
        collection.add(shape3);

        // Retrieve each shape from the collection using the get() method
        GUIShape retrievedShape1 = (GUIShape) collection.get(0);
        GUIShape retrievedShape2 = (GUIShape) collection.get(1);
        GUIShape retrievedShape3 = (GUIShape) collection.get(2);

        // Verify if each retrieved shape matches the expected shape
        assertEquals(shape1, retrievedShape1);
        assertEquals(shape2, retrievedShape2);
        assertEquals(shape3, retrievedShape3);
    }

    @Test
    void size() {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();

        // Add some shapes to the collection
        collection.add(new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, null, 0));
        collection.add(new GUIShape(new Rect_2D(new Point_2D(2, 2), new Point_2D(3, 3)), true, null, 1));
        collection.add(new GUIShape(new Rect_2D(new Point_2D(4, 4), new Point_2D(5, 5)), true, null, 2));

        // Check if the size method returns the expected size
        assertEquals(3, collection.size());
    }

    @Test
    void removeElementAt() {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();

        // Create some shapes
        GUIShape shape1 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, null, 0);
        GUIShape shape2 = new GUIShape(new Rect_2D(new Point_2D(2, 2), new Point_2D(3, 3)), true, null, 1);
        GUIShape shape3 = new GUIShape(new Rect_2D(new Point_2D(4, 4), new Point_2D(5, 5)), true, null, 2);

        // Add the shapes to the collection
        collection.add(shape1);
        collection.add(shape2);
        collection.add(shape3);

        // Remove the second shape from the collection
        collection.removeElementAt(1);

        // Verify that the size of the collection has decreased by 1
        assertEquals(2, collection.size());

    }

    @Test
    void addAt() {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();

        // Create some shapes
        GUIShape shape1 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, null, 0);
        GUIShape shape2 = new GUIShape(new Rect_2D(new Point_2D(2, 2), new Point_2D(3, 3)), true, null, 1);
        GUIShape shape3 = new GUIShape(new Rect_2D(new Point_2D(4, 4), new Point_2D(5, 5)), true, null, 2);

        // Add the shapes to the collection at specific indices
        collection.addAt(shape1, 0);
        collection.addAt(shape2, 1);
        collection.addAt(shape3, 1); // Insert shape3 at index 1, shifting shape2 to index 2

        // Verify that the size of the collection is as expected
        assertEquals(3, collection.size());

        // Verify that the shapes are added at the correct indices
        assertEquals(shape1, collection.get(0));
        assertEquals(shape3, collection.get(1));
        assertEquals(shape2, collection.get(2));
    }

    @Test
    void add() {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();

        // Create some shapes
        GUIShape shape1 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1)), true, null, 0);
        GUIShape shape2 = new GUIShape(new Rect_2D(new Point_2D(2, 2), new Point_2D(3, 3)), true, null, 1);
        GUIShape shape3 = new GUIShape(new Rect_2D(new Point_2D(4, 4), new Point_2D(5, 5)), true, null, 2);

        // Add the shapes to the collection
        collection.add(shape1);
        collection.add(shape2);
        collection.add(shape3);

        // Verify that the size of the collection is as expected
        assertEquals(3, collection.size());

        // Verify that the shapes are added in the correct order
        assertEquals(shape1, collection.get(0));
        assertEquals(shape2, collection.get(1));
        assertEquals(shape3, collection.get(2));
    }

    @Test
    void copy() {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        Rect_2D rect2D = new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        Rect_2D rect2D1 = new Rect_2D(new Point_2D(2, 2), new Point_2D(3, 3));
        Rect_2D rect2D2 = new Rect_2D(new Point_2D(4, 4), new Point_2D(5, 5));

        // Create some shapes
        GUIShape shape1 = new GUIShape(rect2D, true, null, 0);
        GUIShape shape2 = new GUIShape(rect2D1, true, null, 1);
        GUIShape shape3 = new GUIShape(rect2D2, true, null, 2);

        // Add the shapes to the collection
        collection.add(shape1.copy());
        collection.add(shape2.copy());
        collection.add(shape3.copy());


        assertEquals(shape1, collection.get(0));
        assertEquals(shape2, collection.get(1));
        assertEquals(shape3, collection.get(2));
    }

    @Test
    void sort()
    {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();

        GUIShape shape1 = new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 3);
        GUIShape shape2 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(4, 3)), false, Color.BLUE, 2);
        GUIShape shape3 = new GUIShape(new Triangle_2D(new Point_2D(0, 0), new Point_2D(3, 0), new Point_2D(0, 4)), true, Color.GREEN, 1);
        // Add unsorted shapes to the collection
        collection.add(shape1);
        collection.add(shape2);
        collection.add(shape3);

        // Define a comparator to sort shapes by their tags in ascending order
        Comparator<GUI_Shape> tagComparator = Comparator.comparingInt(GUI_Shape::getTag);

        // Sort the collection using the comparator
        collection.sort(tagComparator);

        // Verify that the shapes are sorted correctly
        assertEquals(shape3, collection.get(0));
        assertEquals(shape2, collection.get(1));
        assertEquals(shape1, collection.get(2));
    }

    @Test
    void removeAll() {
        // Create a ShapeCollection instance and add some shapes
        ShapeCollection collection = new ShapeCollection();
        collection.add(new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 1));
        collection.add(new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(4, 3)), false, Color.BLUE, 2));

        // Call removeAll() to remove all shapes
        collection.removeAll();

        // Assert that the collection is empty
        assertEquals(0, collection.size());
    }

    @Test
    void save() {
        // Create a ShapeCollection instance and add some shapes
        ShapeCollection collection = new ShapeCollection();
        collection.add(new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, java.awt.Color.RED, 1));
        collection.add(new GUIShape(new Rect_2D(new Point_2D(0, 0),new Point_2D(4, 3)), false, java.awt.Color.RED, 2));

        // Define the file name for saving
        String fileName = "test_shapes.txt";

        // Save the shapes to the file
        collection.save(fileName);

        // Read the saved data from the file
        StringBuilder savedData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                savedData.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Expected data to be saved (you may need to adjust this based on the actual format)
        String expectedData = "GUIShape,16711680,true,1,Circle_2D,0.0,0.0, 5.0\n" +
                "GUIShape,16711680,false,2,Rect_2D,0.0,3.0,0.0,0.0,4.0,0.0,4.0,3.0\n";

        collection.load(fileName);
        // Assert that the saved data matches the expected data
        assertEquals(expectedData, savedData.toString());
        assertEquals(expectedData, collection.toString());
    }

    @Test
    void load() {
        // Create a new ShapeCollection
        ShapeCollection collection = new ShapeCollection();

        // Define the file name for loading
        String fileName = "test_shapes.txt";

        collection.load(fileName);

        // Verify that the shapes are correctly loaded and added to the collection
        assertEquals(2, collection.size());

        // Verify the first shape (Circle_2D)
        GUIShape circleShape = (GUIShape) collection.get(0);
        assertEquals(Color.RED, circleShape.getColor());
        assertTrue(circleShape.isFilled());
        assertEquals(1, circleShape.getTag());
        assertTrue(circleShape.getShape() instanceof Circle_2D);

        // Verify the second shape (Rect_2D)
        GUIShape rectShape = (GUIShape) collection.get(1);
        assertEquals(Color.RED, rectShape.getColor());
        assertFalse(rectShape.isFilled());
        assertEquals(2, rectShape.getTag());
        assertTrue(rectShape.getShape() instanceof Rect_2D);

    }

    @Test
    void testToString() {
        // Create some sample shapes
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);
        GUI_Shape guiShape = new GUIShape(triangle, true, java.awt.Color.RED, 1);

        // Add the shape to the collection
        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.add(guiShape);

        // Define the expected string rep        resentation
        String expectedString = "GUIShape,16711680,true,1,Triangle_2D,0.0,0.0,3.0,0.0,0.0,4.0\n";

        // Call the toString() method and compare with the expected string
        assertEquals(expectedString, shapeCollection.toString());
    }
}