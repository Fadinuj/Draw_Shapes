package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */
import ex2.geo.*;
import java.awt.*;
import java.util.Objects;


public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}

	/**
	 ** Constructs a GUIShape object from a string representation.
	 *  * The string representation should follow the format:
	 *  * "ClassName,color,fill,tag,ShapeType,ShapeData"
	 *  *
	 *  * @param s the string representation of the GUIShape object.
	 *  *        It should include information about the class name, color, fill status, tag, shape type, and shape data.
	 *  *        For example: "GUIShape,16711680,true,1,Circle_2D,100.0,100.0,50.0"
	 *  *        Here, "GUIShape" is the class name, "16711680" is the color encoded as an integer, "true" indicates filled, "1" is the tag,
	 *  *        "Circle_2D" is the type of shape, and "100.0,100.0,50.0" represents the shape data.
	 *  *        The shape data format depends on the shape type.
	 */
	public GUIShape(String s) {
		String[] parts = s.split(",");
		_color = Color.decode(parts[1]);
		_fill = Boolean.parseBoolean(parts[2]);
		_tag = Integer.parseInt(parts[3]);
		String shape = parts[4];
		if (shape.equals("Circle_2D"));
		{
			Point_2D center = new Point_2D(Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
			double radios = Double.parseDouble(parts[7]);
			_g = new Circle_2D(center, radios);

		}
		if (shape.equals("Segment_2D"))
		{
			Point_2D _p1 = new Point_2D(Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
			Point_2D _p2 =new Point_2D(Double.parseDouble(parts[7]), Double.parseDouble(parts[8]));
			_g = new Segment_2D(_p1,_p2);

		}
		if (shape.equals("Triangle_2D"))
		{
			Point_2D _p1 = new Point_2D(Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
			Point_2D _p2 =new Point_2D(Double.parseDouble(parts[7]), Double.parseDouble(parts[8]));
			Point_2D _p3 =new Point_2D(Double.parseDouble(parts[9]), Double.parseDouble(parts[10]));
			_g = new Triangle_2D(_p1,_p2,_p3);

		}
		if (shape.equals("Rect_2D"))
		{
			// Extract relevant information from the string parts
			Point_2D p1 = new Point_2D(Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
			Point_2D p2 = new Point_2D(Double.parseDouble(parts[7]), Double.parseDouble(parts[8]));
			Point_2D p3 = new Point_2D(Double.parseDouble(parts[9]), Double.parseDouble(parts[10]));
			Point_2D p4 = new Point_2D(Double.parseDouble(parts[11]), Double.parseDouble(parts[12]));



			// Create a Rect_2D object using the extracted information
			_g = new Rect_2D(p1, p3, p2 , p4);


		}
		if (shape.equals("Polygon_2D"))
		{
			// Extract relevant information for creating a Polygon_2D object
			int numPoints = (parts.length - 5) / 2; // Calculate the number of points

			// Create an array to store the points
			Point_2D[] polygonPoints = new Point_2D[numPoints];

			// Loop through the parts array to extract the points
			int index = 5; // Start index for points in the parts array
			for (int i = 0; i < numPoints; i++) {
				double x = Double.parseDouble(parts[index]);
				double y = Double.parseDouble(parts[index + 1]);
				polygonPoints[i] = new Point_2D(x, y);
				index += 2; // Move to the next pair of coordinates
			}

			// Create a Polygon_2D object using the extracted points
			_g = new Polygon_2D();

			// Add the points to the Polygon_2D object
			for (Point_2D point : polygonPoints) {
				((Polygon_2D) _g).add(point);
			}


		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GUIShape guiShape = (GUIShape) o;
		return _fill == guiShape._fill && _tag == guiShape._tag && _isSelected == guiShape._isSelected && Objects.equals(_g, guiShape._g) && Objects.equals(_color, guiShape._color);
	}


	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		return new GUIShape(this); // Create a new GUIShape object with the copy constructor
	}
	@Override
	public String toString() {
		String ans = ""+this.getClass().getSimpleName()+","+colorEncoding(_color)+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	public static int colorEncoding(Color c) {
		int r = c.getRed();
		int b = c.getBlue();
		int g = c.getGreen();
		int ce = r*256*256 + g*256 + b;
		return ce;
	}

	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
}
