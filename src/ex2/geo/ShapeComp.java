package ex2.geo;

import java.util.Comparator;

import ex2.ex2.Ex2_Const;
import ex2.gui.GUI_Shape;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS
 *The ShapeComp class provides functionality to compare GUI shapes based on various sorting flags.
 *  * Each instance of ShapeComp is associated with a specific sorting flag, indicating the type of comparison to perform.
 *  * The compare method compares two GUI shapes based on the specified flag and returns 1 if the first shape is greater than the second,
 *  * -1 if the first shape is smaller than the second, and 0 if the two shapes are equal.
 */
public class ShapeComp implements Comparator<GUI_Shape>{

	public static final ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final ShapeComp CompByToString = new ShapeComp(Ex2_Const.Sort_By_toString);


	public int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
	}

	/**
	 * Make sure you implement the basic code below
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return 1 iff o1 is grater than o1, -1 iff o1 is smaller than o2,
	 * and 0 iff o1 and o2 are equals.
	 */
	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		double a1=-1, a2 = -1;
		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans =0;
		/**
		 *- Sort_By_Area: Sorts shapes based on their area in ascending order.
		 */
		if(_flag == Ex2_Const.Sort_By_Area) {
			a1 = s1.area();
			a2 = s2.area();
			if(a1>a2) {ans=1;}
			if(a1<a2) {ans=-1;}
		}
		/**
		 * - Sort_By_toString: Sorts shapes based on their string representation in lexicographical order.
		 */
		if(_flag == Ex2_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		/**
		 * - Sort_By_Anti_Area: Sorts shapes based on their area in descending order.
		 */
		if (_flag==Ex2_Const.Sort_By_Anti_Area)
		{
			a1 = s1.area();
			a2 = s2.area();
			if(a1<a2) {ans=1;}
			if(a1>a2) {ans=-1;}
		}
		/**
		 * - Sort_By_Perimeter: Sorts shapes based on their perimeter in ascending order.
		 */
		if (_flag==Ex2_Const.Sort_By_Perimeter)
		{
			double perimeter1 = s1.perimeter();
			double perimeter2 = s2.perimeter();

			// Compare Perimeters
			if (perimeter1 > perimeter2) {
				ans = 1;
			} else if (perimeter1 < perimeter2) {
				ans = -1;
			}
		}
		/**
		 * - Sort_By_Anti_Perimeter: Sorts shapes based on their perimeter in descending order.
		 */
		if (_flag==Ex2_Const.Sort_By_Anti_Perimeter)
		{
			double perimeter1 = s1.perimeter();
			double perimeter2 = s2.perimeter();

			// Compare Perimeters
			if (perimeter1 < perimeter2) {
				ans = 1;
			} else if (perimeter1 > perimeter2) {
				ans = -1;
			}
		}
		/**
		 * - Sort_By_Anti_toString: Sorts shapes based on their string representation in reverse lexicographical order.
		 */
		if (_flag==Ex2_Const.Sort_By_Anti_toString)
		{
			ans = -o1.toString().compareTo(o2.toString());
		}
		/**
		 * - Sort_By_Tag: Sorts shapes based on their tag in lexicographical order.
		 */
		if (_flag==Ex2_Const.Sort_By_Tag)
		{
			// Get the tags of each shape
			String tag1 = String.valueOf(o1.getTag());
			String tag2 = String.valueOf(o2.getTag());

			// Compare tags lexicographically
			ans = tag1.compareTo(tag2);
		}
		/**
		 * - Sort_By_Anti_Tag: Sorts shapes based on their tag in reverse lexicographical order.
		 */
		if (_flag==Ex2_Const.Sort_By_Anti_Tag)
		{
			// Get the tags of each shape and convert them to integers
			int tag1 = Integer.parseInt(String.valueOf(o1.getTag()));
			int tag2 = Integer.parseInt(String.valueOf(o2.getTag()));
			// Compare tags in reverse order
			ans = Integer.compare(tag2, tag1);
		}
		return ans;
	}

}
