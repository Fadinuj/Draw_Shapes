package ex2.ex2;

import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import java.io.*;
import java.util.*;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;

	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}

	/**
	 * Checks if this ShapeCollection is equal to another object.
	 * Two ShapeCollection objects are considered equal if they contain the same sequence of GUI_Shape objects.
	 *
	 * @param o the object to compare this ShapeCollection with
	 * @return true if the specified object is equal to this ShapeCollection, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ShapeCollection that = (ShapeCollection) o;
		return Objects.equals(_shapes, that._shapes);
	}
	/**
	 * Gets the GUI_Shape object at the specified index in this ShapeCollection.
	 *
	 * @param i the index of the GUI_Shape to retrieve
	 * @return the GUI_Shape object at the specified index
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}
	/**
	 * Returns the number of GUI_Shape objects in this ShapeCollection.
	 *
	 * @return the number of GUI_Shape objects
	 */
	@Override
	public int size() {
		return _shapes.size();
	}
	/**
	 * Removes the GUI_Shape element at the specified index in this ShapeCollection.
	 *
	 * @param i the index of the GUI_Shape to be removed
	 * @return the GUI_Shape previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (i < 0 || i >= size())
	 */
	@Override
	public GUI_Shape removeElementAt(int i) {
		if (i < 0 || i >= _shapes.size()) {
			throw new IndexOutOfBoundsException("Index " + i + " is out of bounds");
		}
		return _shapes.remove(i);
	}
	/**
	 * Inserts the specified GUI_Shape element at the specified position in this ShapeCollection.
	 *
	 * @param s the GUI_Shape to insert
	 * @param i the index at which the specified element is to be inserted
	 */
	@Override
	public void addAt(GUI_Shape s, int i) {
		if (i >= 0 && i <= _shapes.size() && s != null) {
			_shapes.add(i, s);
		}
	}

	/**
	 * Adds the specified GUI_Shape to the end of this ShapeCollection.
	 *
	 * @param s the GUI_Shape to add
	 */
	@Override
	public void add(GUI_Shape s) {
		if (s != null && s.getShape() != null) {
			_shapes.add(s);
		}
	}
	/**
	 * Creates a deep copy of this ShapeCollection.
	 *
	 * @return a new ShapeCollection containing copies of all GUI_Shape objects in this collection
	 */
	@Override
	public GUI_Shape_Collection copy() {
		ShapeCollection copyCollection = new ShapeCollection();

		for (GUI_Shape shape : _shapes) {

			GUI_Shape copiedShape = new GUIShape(shape.toString());
			copyCollection.add(copiedShape);
		}

		return copyCollection;
	}
	/**
	 * Sorts the shapes in this collection using the specified comparator.
	 *
	 * @param comp the comparator to determine the order of the shapes
	 */
	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}
	/**
	 * Removes all shapes from this collection.
	 */
	@Override
	public void removeAll() {
		_shapes.clear();
	}
	/**
	 * Saves the shapes in this collection to a file.
	 * @param file The file path where the shapes will be saved.
	 */
	@Override
	public void save(String file) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (GUI_Shape shape : _shapes) {
				writer.write(shape.toString()); // Write the string representation of each shape
				writer.newLine(); // Add a newline character to separate shapes
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Loads shapes from a file and adds them to this collection.
	 * @param file The file path from which shapes will be loaded.
	 */
	@Override
	public void load(String file)
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			_shapes.clear();
			String line;
			while ((line = reader.readLine()) != null)
			{
				_shapes.add(new GUIShape(line));
			}
		}catch (IOException e)
		{
			e.printStackTrace();
		}


	}

	/**
	 * Returns a string representation of this shape collection.
	 * @return A string representing all the shapes in this collection.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (GUI_Shape shape : _shapes) {
			stringBuilder.append(shape.toString()).append("\n");
		}
		return stringBuilder.toString();
	}
}
	


