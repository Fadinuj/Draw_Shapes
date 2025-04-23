package ex2.geo;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {
	private Point_2D _p1;
	private Point_2D _p2;
	private Point_2D _p3;
	private Point_2D _p4;
	public Rect_2D(Point_2D p1, Point_2D p2) {
		// Assign top left and bottom right corners
		_p1 = new Point_2D(Math.min(p1.x(), p2.x()), Math.max(p1.y(), p2.y()));
		_p2 = new Point_2D(Math.max(p1.x(), p2.x()), Math.min(p1.y(), p2.y()));

		_p4 =new Point_2D(_p2.x(), _p1.y());
		_p3 =new Point_2D(_p1.x(), _p2.y());
	}
	public Rect_2D(Point_2D p1,Point_2D p2,Point_2D p3,Point_2D p4)
	{
		_p1=p1;
		_p2=p2;
		_p3=p3;
		_p4=p4;
	}
	public Rect_2D(Rect_2D rect) {
		// Copy constructor
		this._p1 = new Point_2D(rect._p1);
		this._p2 = new Point_2D(rect._p2);
		this._p3=new Point_2D(rect._p3);
		this._p4=new Point_2D(rect._p4);
	}
	public Point_2D get_p1()
	{return _p1;}
	public Point_2D get_p2()
	{return _p2;}

	/**
	 * Checks if this rectangle is equal to another object.
	 *
	 * @param o The object to compare this rectangle to.
	 * @return true if the given object is a rectangle with the same corner points as this rectangle, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rect_2D rect2D = (Rect_2D) o;
		return Objects.equals(_p1, rect2D._p1) && Objects.equals(_p2, rect2D._p2) && Objects.equals(_p3, rect2D._p3) && Objects.equals(_p4, rect2D._p4);
	}


	public Point_2D get_p3() {
		return _p3;
	}

	public Point_2D get_p4() {
		return _p4;
	}
	public Point_2D[] getAllPoints() {
		return new Point_2D[]{_p1, _p3, _p2, _p4};
	}
	/**
	 * Checks if a given point is contained within this rectangle.
	 *
	 * @param ot The point to check for containment.
	 * @return true if the point is inside or on the boundary of this rectangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		return ot.x() >= _p1.x() &&
				ot.x() <= _p2.x() &&
				ot.y() >= _p2.y() &&
				ot.y() <= _p1.y();
	}
	/**
	 * Calculates the area of this rectangle.
	 *
	 * @return The area of the rectangle.
	 */
	@Override
	public double area() {
		double width = (Math.abs(_p2.x() - _p1.x()));
		double height = (Math.abs(_p1.y() - _p2.y()));
		return width * height;
	}
	/**
	 * Calculates the perimeter of this rectangle.
	 *
	 * @return The perimeter of the rectangle.
	 */
	@Override
	public double perimeter() {
		double width = _p2.x() - _p1.x();
		double height = _p1.y() - _p2.y();
		return 2 * (width + height);
	}
	/**
	 * Translates this rectangle by a specified vector.
	 *
	 * @param vec The vector by which to translate the rectangle.
	 */
	@Override
	public void translate(Point_2D vec) {

		_p1 .move(vec);

		_p2 .move(vec);
		_p3.move(vec);
		_p4.move(vec);

	}
	/**
	 * Returns a string representation of this rectangle.
	 *
	 * @return A string representing the rectangle's coordinates.
	 */
	@Override
	public String toString() {
		return _p1.toString()+","+_p3.toString()+","+_p2.toString()+","+_p4.toString();
	}
	/**
	 * Creates and returns a copy of this rectangle.
	 *
	 * @return A copy of this rectangle.
	 */
	@Override
	public GeoShape copy() {
		return new Rect_2D(this);
	}
	/**
	 * Scales this rectangle relative to the specified center point and ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center, ratio);
		_p2.scale(center, ratio);
		_p3.scale(center, ratio);
		_p4.scale(center, ratio);
	}
	/**
	 * Rotates this rectangle around the specified center point by the given angle in degrees.
	 *
	 * @param center        The center point for rotation.
	 * @param angleDegrees  The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center, angleDegrees);
		_p2.rotate(center, angleDegrees);
		_p3.rotate(center, angleDegrees);
		_p4.rotate(center, angleDegrees);
	}
}
