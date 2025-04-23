package ex2.geo;

import java.util.ArrayList;
import java.util.Arrays;

public class Polygon_2D implements GeoShape{
	private Point_2D[] points;

	public Polygon_2D() {
		this.points = new Point_2D[0];
	}
	public Polygon_2D(Polygon_2D po)
	{
		this.points = Arrays.copyOf(po.points, po.points.length);
	}
	public Polygon_2D(Point_2D[] points)
	{
		this.points= points;
	}

	/**
	 * Checks if this polygon is equal to another object.
	 *
	 * @param o The object to compare.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Polygon_2D polygon2D = (Polygon_2D) o;
		return Arrays.equals(points, polygon2D.points);
	}


	public Point_2D[] getAllPoints() {
		return Arrays.copyOf(this.points, this.points.length);
	}
	public Point_2D getCenterOfPolygon()
	{
		double totalX = 0.0;
		double totalY = 0.0;
		int numVertices = points.length;

		for (Point_2D point : points) {
			totalX += point.x();
			totalY += point.y();
		}

		double centerX = totalX / numVertices;
		double centerY = totalY / numVertices;

		return new Point_2D(centerX, centerY);
	}


	public void add(Point_2D p) {
		Point_2D[] newPoints = Arrays.copyOf(this.points, this.points.length + 1);
		//if (!Boolean.parseBoolean(String.valueOf(Arrays.binarySearch(newPoints,p)))) {
			newPoints[newPoints.length - 1] = p;
			this.points = newPoints;
		//}
	}
	/**
	 * Returns a string representation of this polygon.
	 *
	 * @return A string representation of the polygon.
	 */
	@Override
	public String toString()
	{
		String str=points[0].toString();
		for (int i = 1; i < points.length; i++) {
			str+=","+points[i].toString();
		}
		return str;
	}
	/**
	 * Checks if this polygon contains a given point.
	 *
	 * @param ot The point to check.
	 * @return True if the point is contained within the polygon, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		int crossings = 0;
		Point_2D[] polyPoints = this.points;

		for (int i = 0; i < polyPoints.length; i++) {
			int j = (i + 1) % polyPoints.length;

			if ((polyPoints[i].y() > ot.y()) != (polyPoints[j].y() > ot.y()) &&
					ot.x() < (polyPoints[j].x() - polyPoints[i].x()) * (ot.y() - polyPoints[i].y()) / (polyPoints[j].y() - polyPoints[i].y()) + polyPoints[i].x()) {
				crossings++;
			}
		}

		return crossings % 2 != 0;
	}
	/**
	 * Calculates the area of this polygon.
	 *
	 * @return The area of the polygon.
	 */
	@Override
	public double area() {
		double area = 0;
		int j = points.length - 1;

		for (int i = 0; i < points.length; i++) {
			area += (points[j].x() + points[i].x()) * (points[j].y() - points[i].y());
			j = i;
		}

		return Math.abs(area) / 2.0;
	}
	/**
	 * Calculates the perimeter of this polygon.
	 *
	 * @return The perimeter of the polygon.
	 */
	@Override
	public double perimeter() {
		double perimeter = 0;

		for (int i = 0; i < points.length; i++) {
			int j = (i + 1) % points.length; // Next vertex index (circular)

			double dx = points[j].x() - points[i].x();
			double dy = points[j].y() - points[i].y();

			perimeter += Math.sqrt(dx * dx + dy * dy); // Distance formula
		}

		return perimeter;
	}
	/**
	 * Translates this polygon by the specified vector.
	 *
	 * @param vec The vector to translate by.
	 */
	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < points.length; i++) {
			points[i].move(vec);
		}
	}
	/**
	 * Creates a copy of this polygon.
	 *
	 * @return A copy of this polygon.
	 */
	@Override
	public GeoShape copy() {
		// Create a new Polygon_2D object
		Point_2D[] copy = new Point_2D[points.length];

		// Copy the points from the current polygon to the new one
		for (int i = 0; i < points.length; i++)
		{
			copy[i]= new Point_2D(points[i]);
		}
		return new Polygon_2D(copy);

	}
	/**
	 * Scales this polygon around the specified center point by the given ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		for (int i = 0; i < points.length; i++) {
			points[i].scale(center, ratio);
		}
	}
	/**
	 * Rotates this polygon around the specified center point by the given angle in degrees.
	 *
	 * @param center       The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < points.length; i++) {
			points[i].rotate(center, angleDegrees);
		}
	}

}
