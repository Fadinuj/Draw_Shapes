package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle_2D implements GeoShape{
	private Point_2D _center;
	private double _radius;

	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}
	public Circle_2D(Circle_2D c) {
		this(c.getCenter(), c.getRadius());
	}
	public double getRadius() {return this._radius;}
	public Point_2D getCenter(){ return _center;}

	/**
	 * Method to check if two circles are equal.
	 * Two circles are equal if they have the same center and radius.
	 *
	 * @param o The object to compare with.
	 * @return true if the circles are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Circle_2D circle2D = (Circle_2D) o;
		return Double.compare(_radius, circle2D._radius) == 0 && Objects.equals(_center, circle2D._center);
	}


	/**
	 * Method to get a string representation of the circle.
	 *
	 * @return A string representing the center point and radius of the circle.
	 */
	@Override
	    public String toString()
	    {
			return _center.toString()+", "+_radius;
		}
	/**
	 * Method to check if a given point is inside the circle.
	 * @param ot The point to check.
	 *  Calculate distance between center and given point
	 *  Check if distance is less than or equal to radius
	 * @return true if the point is inside the circle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double dist= this._center.distance(ot);
		return dist<=this._radius;
	}
	/**
	 * Method to calculate the area of the circle.
	 *Calculate area using the formula pi * r^2
	 * @return The area of the circle.
	 */
	@Override
	public double area() {
		return Math.PI * _radius * _radius;
	}
	/**
	 * Method to calculate the perimeter (circumference) of the circle.
	 *Calculate perimeter using the formula 2 * pi * r
	 * @return The perimeter of the circle.
	 */
	@Override
	public double perimeter() {
		return 2 * Math.PI * this._radius;
	}
	/**
	 * Method to translate (move) the center of the circle by a specified vector.
	 * Move the center of the circle by adding the components of the vector
	 * @param vec The vector representing the amount to move the center in the x and y directions.
	 */
	@Override
	public void translate(Point_2D vec) {
		_center.move(vec);
	}
	/**
	 * Creates a deep copy of the circle.
	 *
	 * @return A new Circle_2D object with the same center and radius as this circle.
	 */
	@Override
	public GeoShape copy() {
		////// add your code here //////
		return new Circle_2D(this._center,this._radius);
		//return null;
		////////////////////////////////
	}
	/**
	 * Scales the circle relative to a specified center point by a given scaling factor.
	 *
	 * @param center The center point around which the circle is scaled.
	 * @param ratio  The scaling factor.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		double newRadius = _radius * ratio;  // Calculate the new radius after scaling
		_radius = newRadius; // Update the radius
		_center.scale(center, ratio); // Scale the center of the circle
	}
	/**
	 * Rotates the circle around a specified center point by a given angle in degrees.
	 *
	 * @param center        The center point around which the circle is rotated.
	 * @param angleDegrees  The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_center.rotate(center, angleDegrees);
	}
}
