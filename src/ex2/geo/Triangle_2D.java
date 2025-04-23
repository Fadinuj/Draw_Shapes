package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape {
	private Point_2D p1;
	private Point_2D p2;
	private Point_2D p3;

	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;

	}

	public Triangle_2D(Triangle_2D t1) {
		this.p1 = new Point_2D(t1.p1);
		this.p2 = new Point_2D(t1.p2);
		this.p3 = new Point_2D(t1.p3);
	}

	/**
	 * Checks if this triangle is equal to another object.
	 *
	 * @param o The object to compare.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triangle_2D that = (Triangle_2D) o;
		return Objects.equals(p1, that.p1) && Objects.equals(p2, that.p2) && Objects.equals(p3, that.p3);
	}
	public Point_2D[] getAllPoints() {
		return new Point_2D[]{p1, p2, p3};
	}
	/**
	 * Checks if this triangle contains a given point.
	 *
	 * @param ot The point to check.
	 * @return True if the point is inside the triangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double denominator = ((p2.y() - p3.y()) * (p1.x() - p3.x()) + (p3.x() - p2.x()) * (p1.y() - p3.y()));
		double alpha = ((p2.y() - p3.y()) * (ot.x() - p3.x()) + (p3.x() - p2.x()) * (ot.y() - p3.y())) / denominator;
		double beta = ((p3.y() - p1.y()) * (ot.x() - p3.x()) + (p1.x() - p3.x()) * (ot.y() - p3.y())) / denominator;
		double gamma = 1.0 - alpha - beta;

		return alpha >= 0 && alpha <= 1 && beta >= 0 && beta <= 1 && gamma >= 0 && gamma <= 1;

	}
	/**
	 * Calculates the area of this triangle.
	 *
	 * @return The area of the triangle.
	 */
	@Override
	public double area() {
		double a = Math.sqrt(Math.pow(p2.x() - p1.x(), 2) + Math.pow(p2.y() - p1.y(), 2));
		double b = Math.sqrt(Math.pow(p3.x() - p2.x(), 2) + Math.pow(p3.y() - p2.y(), 2));
		double c = Math.sqrt(Math.pow(p1.x() - p3.x(), 2) + Math.pow(p1.y() - p3.y(), 2));
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area;
	}
	/**
	 * Calculates the perimeter of this triangle.
	 *
	 * @return The perimeter of the triangle.
	 */
	@Override
	public double perimeter() {
		// Calculate the lengths of the sides using the distance formula
		double side1 = Math.sqrt(Math.pow(p2.x() - p1.x(), 2) + Math.pow(p2.y() - p1.y(), 2));
		double side2 = Math.sqrt(Math.pow(p3.x() - p2.x(), 2) + Math.pow(p3.y() - p2.y(), 2));
		double side3 = Math.sqrt(Math.pow(p1.x() - p3.x(), 2) + Math.pow(p1.y() - p3.y(), 2));

		// Calculate the perimeter by summing the lengths of the sides
		double perimeter = side1 + side2 + side3;

		return perimeter;
	}
	/**
	 * Translates this triangle by the specified vector.
	 *
	 * @param vec The vector to translate by.
	 */
	@Override
	public void translate(Point_2D vec) {
		p1.move(vec);
		p2.move(vec);
		p3.move(vec);
	}
	/**
	 * Creates a copy of this triangle.
	 *
	 * @return A copy of this triangle.
	 */
	@Override
	public GeoShape copy() {
		// Create new Point_2D objects as copies of the vertices of the triangle
		Point_2D copiedP1 = new Point_2D(p1.x(), p1.y());
		Point_2D copiedP2 = new Point_2D(p2.x(), p2.y());
		Point_2D copiedP3 = new Point_2D(p3.x(), p3.y());

		// Create and return a new Triangle_2D object with the copied points
		return new Triangle_2D(copiedP1, copiedP2, copiedP3);
	}
	/**
	 * Scales this triangle around the specified center point by the given ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		p1.scale(center, ratio);
		p2.scale(center, ratio);
		p3.scale(center, ratio);
	}
	/**
	 * Rotates this triangle around the specified center point by the given angle in degrees.
	 *
	 * @param center       The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		p1.rotate(center,angleDegrees);
		p2.rotate(center,angleDegrees);
		p3.rotate(center, angleDegrees);
	}
	/**
	 * Returns a string representation of this triangle.
	 *
	 * @return A string representation of the triangle.
	 */
	@Override
	public String toString() {
		return p1.toString()+","+p2.toString()+","+p3.toString();
	}
}
