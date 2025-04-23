package ex2.test;

import ex2.ex2.Ex2_Const;
import ex2.ex2.ShapeCollection;
import ex2.geo.*;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCompTest {

    @Test
    void byArea() {
        // Create two triangles with different dimensions
        Triangle_2D triangle1 = new Triangle_2D(
                new Point_2D(0, 0), new Point_2D(3, 0), new Point_2D(0, 4));
        Triangle_2D triangle2 = new Triangle_2D(
                new Point_2D(0, 0), new Point_2D(5, 0), new Point_2D(0, 3));

        // Create GUIShape instances for the triangles
        GUIShape guiShape1 = new GUIShape(triangle2, true, Color.RED, 0);
        GUIShape guiShape2 = new GUIShape(triangle1, true, Color.BLUE, 1);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);

        // Sort the collection by area
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_Area));

        // Check if the shapes are sorted in ascending order of area
        assertEquals(guiShape2, collection.get(0)); // The triangle with smaller area should be first
        assertEquals(guiShape1, collection.get(1));





    }
    @Test
    void byAntiArea()
    {
        // Create two circles with different radii
        Circle_2D circle1 = new Circle_2D(new Point_2D(0, 0), 3);
        Circle_2D circle2 = new Circle_2D(new Point_2D(0, 0), 5);

        // Create GUIShape instances for the circles
        GUIShape guiShape1 = new GUIShape(circle1, true, Color.RED, 0);
        GUIShape guiShape2 = new GUIShape(circle2, true, Color.BLUE, 1);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);

        // Sort the collection by anti-area
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_Area));

        // Check if the shapes are sorted in descending order of anti-area
        assertEquals(guiShape2, collection.get(0));
        assertEquals(guiShape1, collection.get(1));
    }
    @Test
    void ByPerimeter()
    {
        // Create two circles with different radii
        Circle_2D circle1 = new Circle_2D(new Point_2D(0, 0), 5);
        Circle_2D circle2 = new Circle_2D(new Point_2D(0, 0), 3);

        // Create GUIShape instances for the circles
        GUIShape guiShape1 = new GUIShape(circle1, true, Color.RED, 0);
        GUIShape guiShape2 = new GUIShape(circle2, true, Color.BLUE, 1);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);

        // Sort the collection by perimeter
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_Perimeter));

        assertEquals(guiShape2, collection.get(0));
        assertEquals(guiShape1, collection.get(1));
    }
    @Test
    void ByAntiPerimeter()
    {
        // Create two triangles with different dimensions
        Triangle_2D triangle1 = new Triangle_2D(new Point_2D(0, 0), new Point_2D(3, 0), new Point_2D(0, 4));
        Triangle_2D triangle2 = new Triangle_2D(new Point_2D(0, 0), new Point_2D(5, 0), new Point_2D(0, 6));

        // Create GUIShape instances for the triangles
        GUIShape guiShape1 = new GUIShape(triangle1, true, Color.RED, 0);
        GUIShape guiShape2 = new GUIShape(triangle2, true, Color.BLUE, 1);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);

        // Sort the collection by anti-perimeter
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter));

        // Check if the shapes are sorted in descending order of anti-perimeter
        assertEquals(guiShape2, collection.get(0));
        assertEquals(guiShape1, collection.get(1));
    }
    @Test
    void ByToString()
    {
        // Create a circle and a polygon
        Circle_2D circle = new Circle_2D(new Point_2D(0, 0), 5);
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(5, 0));
        polygon.add(new Point_2D(5, 5));

        // Create GUIShape instances for the circle and the polygon
        GUIShape guiShape1 = new GUIShape(circle, true, Color.BLUE, 1);
        GUIShape guiShape2 = new GUIShape(polygon, true, Color.RED, 0);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);

        // Sort the collection by toString representation
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_toString));

        // Check if the shapes are sorted based on their toString representations
        assertEquals(guiShape2, collection.get(0)); // because the color is blue and when we do sort is going first
        assertEquals(guiShape1, collection.get(1));
    }
    @Test
    void ByAntiToString()
    {
        // Create a circle and a triangle
        Circle_2D circle = new Circle_2D(new Point_2D(0, 0), 5);
        Triangle_2D triangle = new Triangle_2D(new Point_2D(0, 0), new Point_2D(5, 0), new Point_2D(2.5, 5));

        // Create GUIShape instances for the circle and the triangle
        GUIShape guiShape1 = new GUIShape(circle, true, Color.RED, 0);
        GUIShape guiShape2 = new GUIShape(triangle, true, Color.BLUE, 1);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);

        // Sort the collection by anti-toString representation
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_toString));

        // Check if the shapes are sorted based on their anti-toString representations
        assertEquals(guiShape2, collection.get(0)); // Triangle should come first
        assertEquals(guiShape1, collection.get(1)); // Circle should come second
    }
    @Test
    void ByTag()
    {
        // Create three circles with different tags
        Circle_2D circle1 = new Circle_2D(new Point_2D(0, 0), 5);
        Circle_2D circle2 = new Circle_2D(new Point_2D(0, 0), 7);
        Circle_2D circle3 = new Circle_2D(new Point_2D(0, 0), 10);

        // Create GUIShape instances for the circles with different tags
        GUIShape guiShape1 = new GUIShape(circle1, true, Color.RED, 2);
        GUIShape guiShape2 = new GUIShape(circle2, true, Color.BLUE, 1);
        GUIShape guiShape3 = new GUIShape(circle3, true, Color.GREEN, 0);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);
        collection.add(guiShape3);

        // Sort the collection by tag
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_Tag));

        // Check if the shapes are sorted based on their tags
        assertEquals(guiShape3, collection.get(0)); // Circle with tag 0 should come first
        assertEquals(guiShape2, collection.get(1)); // Circle with tag 1 should come second
        assertEquals(guiShape1, collection.get(2)); // Circle with tag 2 should come third
    }
    @Test
    void ByAntiTag()
    {
        // Create three circles with different tags
        Circle_2D circle1 = new Circle_2D(new Point_2D(0, 0), 5);
        Circle_2D circle2 = new Circle_2D(new Point_2D(0, 0), 7);
        Circle_2D circle3 = new Circle_2D(new Point_2D(0, 0), 10);

        // Create GUIShape instances for the circles with different tags
        GUIShape guiShape1 = new GUIShape(circle1, true, Color.RED, 1);
        GUIShape guiShape2 = new GUIShape(circle2, true, Color.BLUE, 2);
        GUIShape guiShape3 = new GUIShape(circle3, true, Color.GREEN, 3);

        // Add the GUIShape instances to a ShapeCollection
        ShapeCollection collection = new ShapeCollection();
        collection.add(guiShape1);
        collection.add(guiShape2);
        collection.add(guiShape3);

        // Sort the collection by tag
        collection.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_Tag));

        // Check if the shapes are sorted based on their tags
        assertEquals(guiShape3, collection.get(0)); // Circle with tag 0 should come first
        assertEquals(guiShape2, collection.get(1)); // Circle with tag 1 should come second
        assertEquals(guiShape1, collection.get(2)); // Circle with tag 2 should come third

    }


}