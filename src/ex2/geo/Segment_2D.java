package ex2.geo;

import ex2.ex2.Ex2_Const;

import java.util.Objects;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{
	private Point_2D _p1,_p2;
	public Segment_2D(Point_2D a, Point_2D b) {
		_p1=new Point_2D(a);
		_p2=b;
	}
	public Segment_2D(Segment_2D t1) {
		_p1=new Point_2D(t1.get_p1());
		_p2=new Point_2D(t1.get_p2());
	}

	public Point_2D get_p1() {
		return new Point_2D(_p1);
	}
	public Point_2D get_p2() {
		return _p2;
	}

	/**
	 * Checks if this segment is equal to another object.
	 *
	 * @param o The object to compare.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Segment_2D segment2D = (Segment_2D) o;
		return Objects.equals(_p1, segment2D._p1) && Objects.equals(_p2, segment2D._p2);
	}


	private boolean isVertical()
	{
		return _p1.x()==_p2.x();
	}
	/**
	 * Checks if this segment contains a given point.
	 *
	 * @param ot The point to check.
	 * @return True if the point is contained within the segment, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double dist=_p1.distance(_p2);
		double d1=_p1.distance(ot);
		double d2=ot.distance(_p2);
		boolean ans = d1+d2<dist+ Ex2_Const.EPS;
		return ans;
	}
	/**
	 * Calculates the area of this segment.
	 *
	 * @return The area of the segment is 0.
	 */
	@Override
	public double area() {
		return 0;
	}
	/**
	 * Calculates the perimeter of this segment.
	 *
	 * @return The perimeter of the segment is the distance from point1 to point2.
	 */
	@Override
	public double perimeter() {
		return _p1.distance(_p2);
	}
	/**
	 * Translates this segment by the specified vector.
	 *
	 * @param vec The vector to translate by.
	 */
	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);

	}
	/**
	 * Creates a copy of this segment.
	 *
	 * @return A copy of this segment.
	 */
	@Override
	public GeoShape copy() {
		return new Segment_2D(_p1,_p2);
	}
	/**
	 * Scales this segment around the specified center point by the given ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center, ratio);
		_p2.scale(center,ratio);
	}
	/**
	 * Rotates this segment around the specified center point by the given angle in degrees.
	 *
	 * @param center       The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center, angleDegrees);
		_p2.rotate(center, angleDegrees);

	}
	/**
	 * Returns a string representation of this segment.
	 *
	 * @return A string representation of the segment.
	 */
	@Override
	public String toString()
	{
		return _p1.toString()+","+_p2.toString();
	}
}