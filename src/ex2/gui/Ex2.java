package ex2.gui;

import ex2.ex2.Ex2_Const;
import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Objects;

/**
 * This class is a simple "interlayer" connecting (aka simplifying) the
 * StdDraw with the Map class.
 * Written for 101 java course it uses simple static functions to allow a
 * "Singleton-like" implementation.
 * <p>
 * Notes:
 * 1. Make sure to add a detailed explanation of assignment 2 below:
 *  whether two objects are equal based on some defined criteria.
 *  * This assignment includes a relatively complex set of classes and interfaces.
 *  * I was asked to implement a set of geometric shapes (Point2D, Circle2D, Rect2D, Segment2D Triangle2D and Polygon2D).
 *  * we dealt with a basic GUI and file saving capabilities (if we ran the program and created shapes then we would have the ability to save our shapes as a file) we also dealt with loading capabilities, meaning the possibility to load the file we saved.
 *  * Moreover, in this task, we were required to implement a JUnit class - and test all the functions we implemented.
 *  contains(Point_2D ot): Determines if a given point falls inside the shape. Assumes a closed shape, meaning if the point is on the boundary, it's considered inside the shape.
 *  *The functions I implemented in each class are:
 *  (1) 'area()'---> Computes the area of the shape. Returns 0 for points and segments.
 *  (2) 'perimeter()'---> Computes the perimeter of the shape. Returns 0 for points and twice the length for segments.
 *  (3) 'translate(Point_2D vec)' ---> Moves the shape by a given vector.
 *  (4) 'copy()' ---> Creates a deep copy of the shape.
 *  (5) 'toString()' ---> Returns a string representation of the shape that can be used for saving it into a text file.
 *  (7) 'scale(Point_2D center, double ratio)' ---> Rescales the shape with respect to the given center point and ratio. Rescaling with ratio 1 does not change the shape. Rescaling with a ratio less than 1 reduces the size of the shape, and rescaling with a ratio greater than 1 increases the size.
 *  (8) 'rotate(Point_2D center, double angleDegrees)' ---> Rotates the shape with respect to the given center point by a specified angle in degrees. Rotation with an angle of 0 does not change the shape. Positive angles rotate counterclockwise, while negative angles rotate clockwise.
 *  (9) 'equals(Object o)' ---> this method is used to determine if 2 shapes are equal.
 *  * Ex2: This class implements the Ex2_GUI interface and manages a collection of GUI shapes.
 *  (1) 'init()' ---> Initializes the GUI shape collection and other parameters.
 *  (2) 'show()' ---> Displays the shapes with a specified scale.
 *  (3)'getInstance()' ---> Provides a singleton instance of the Ex2 class.
 *  (4) 'drawShapes()'--->  Draws all the shapes stored in the collection.
 *  (5) 'actionPerformed()' --->  Handles various actions triggered by GUI events, such as changing color, filling shapes, removing shapes, saving/loading shapes to/from files, sorting shapes, selecting shapes, etc.
 *  (6) 'save ()'---> Opens a file dialog for saving the shapes to a text file.
 *  (7) 'load()' ---> Opens a file dialog for loading shapes from a text file.
 *  (8) 'mouseClicked()' ---> Handles mouse click events, performing actions based on the current mode (e.g., drawing shapes, moving, copying, rotating, selecting, scaling).
 *  (9) 'scale ()' ---> Scales selected shapes around a specified point.
 *  (10) 'select()' ---> Selects or deselects shapes based on mouse click positions.
 *  (11) 'move()' ---> Moves selected shapes.
 *  (12) 'copy()' ---> Copies selected shapes.
 *  (13) 'rotate()' ---> Rotates selected shapes around a specified point.
 *  (14) 'selectAll()' ---> Selects all shapes.
 *  (15) 'printInfo()' ---> Prints information about selected shapes.
 *  (16) 'selectNone()' ---> Deselects all shapes.
 *  (17) 'selectAnti()' ---> Inverts the selection status of all shapes.
 *  (18) 'mouseRightClicked()' ---> Handles right mouse click events, finalizing the creation of polygons and triangles.
 *  (19) 'mouseMoved()' ---> Handles mouse movement events, updating the preview of shapes being drawn.
 *  (20) 'getShape_Collection()' ---> Returns the collection of GUI shapes.
 *  (21) 'show()' ---> Overloaded method to show shapes with a default scale.
 *  (22) 'getInfo()' ---> Generates and returns information about all shapes in the collection.
 * 2. Your code will be run by our "main" based on the interfaces api given to you.
 *
 * @author boaz.ben-moshe
 */
public class Ex2 implements Ex2_GUI {
    private GUI_Shape_Collection _shapes = new ShapeCollection();
    private GUI_Shape _gs;
    private Polygon_2D _pp;
    private Color _color = Color.blue;
    private boolean _fill = false;
    private String _mode = "";
    private Point_2D _p1;

    private static Ex2 _winEx2 = null;

    private Ex2() {
        init(null);
    }

    public void init(GUI_Shape_Collection s) {
        if (s == null) {
            _shapes = new ShapeCollection();
        } else {
            _shapes = s;
        }
        GUI_Shape _gs = null;
        Polygon_2D _pp = null;
        _color = Color.blue;
        _fill = false;
        _mode = "";
        Point_2D _p1 = null;
    }

    public void show(double d) {
        StdDraw_Ex2.setScale(0, d);
        StdDraw_Ex2.show();
        drawShapes();
    }

    public static Ex2 getInstance() {
        if (_winEx2 == null) {
            _winEx2 = new Ex2();
        }
        return _winEx2;
    }

    /* private static void drawGrid(int x, int y, int delta) {
         for(int i=0;i<x;i+=delta) {
             StdDraw_Ex2.line(i, 0, i, y);
         }
         for(int i=0;i<y;i+=delta) {
             StdDraw_Ex2.line(0, i, x, i);
         }
    } */
    public void drawShapes() {
        StdDraw_Ex2.clear();
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape sh = _shapes.get(i);

            drawShape(sh);
        }
        if (_gs != null) {
            drawShape(_gs);
        }
        StdDraw_Ex2.show();
    }

    /**
     *
     *
     * @param g
     * every time checks the type of shape and draws the shape
     * and check if the color is fill or not fill
     */
    private static void drawShape(GUI_Shape g) {
        StdDraw_Ex2.setPenColor(g.getColor());
        if (g.isSelected()) {
            StdDraw_Ex2.setPenColor(Color.gray);
        }
        GeoShape gs = g.getShape();
        boolean isFill = g.isFilled();
        if (gs instanceof Circle_2D circle2D) {
            Point_2D cen = circle2D.getCenter();
            double rad = circle2D.getRadius();
            if (isFill) {
                StdDraw_Ex2.filledCircle(cen.x(), cen.y(), rad);
            } else {
                StdDraw_Ex2.circle(cen.x(), cen.y(), rad);
            }
        }
        if (gs instanceof Segment_2D segment2D) {
            Point_2D m0 = segment2D.get_p1();
            Point_2D m1 = segment2D.get_p2();
            StdDraw_Ex2.line(m0.x(), m0.y(), m1.x(), m1.y());
        }
        Point_2D[] ps = null;
        if (gs instanceof Rect_2D rect2D) {
            ps = new Point_2D[]{rect2D.get_p1(),rect2D.get_p3(),rect2D.get_p2(),rect2D.get_p4()};
        }
        if (gs instanceof Polygon_2D) {
            ps = ((Polygon_2D) gs).getAllPoints();
        }
        if (gs instanceof Triangle_2D) {
            ps = ((Triangle_2D) gs).getAllPoints();
        }
        if (ps != null) {
            double[] xx = new double[ps.length];
            double[] yy = new double[ps.length];
            for (int i = 0; i < xx.length; i++) {
                xx[i] = ps[i].x();
                yy[i] = ps[i].y();
            }
            if (isFill) {
                StdDraw_Ex2.filledPolygon(xx, yy);
            } else {
                StdDraw_Ex2.polygon(xx, yy);
            }
        }
    }

    private void setColor(Color c) {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected()) {
                s.setColor(c);
            }
        }
    }

    private void setFill() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected()) {
                s.setFilled(_fill);
            }
        }
    }

    public GUI_Shape get_gs() {
        return _gs;
    }

    public Polygon_2D get_pp() {
        return _pp;
    }

    public Color get_color() {
        return _color;
    }

    public boolean is_fill() {
        return _fill;
    }

    public String get_mode() {
        return _mode;
    }

    public Point_2D get_p1() {
        return _p1;
    }

    private void remove() {
        for (int i = _shapes.size() - 1; i >= 0; i--) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected()) {
                _shapes.removeElementAt(i);
            }
        }
    }

    public void actionPerformed(String p) {
        _mode = p;
        if (p.equals("Blue")) {
            _color = Color.BLUE;
            setColor(_color);
        }
        if (p.equals("Red")) {
            _color = Color.RED;
            setColor(_color);
        }
        if (p.equals("Green")) {
            _color = Color.GREEN;
            setColor(_color);
        }
        if (p.equals("White")) {
            _color = Color.WHITE;
            setColor(_color);
        }
        if (p.equals("Black")) {
            _color = Color.BLACK;
            setColor(_color);
        }
        if (p.equals("Yellow")) {
            _color = Color.YELLOW;
            setColor(_color);
        }
        if (p.equals("Fill")) {
            _fill = true;
            setFill();
        }
        if (p.equals("Empty")) {
            _fill = false;
            setFill();
        }
        if (p.equals("Save")) {
            _mode="Save";
            save();
        }
        if (p.equals("Remove"))
        {
            remove();
        }
        if (p.equals("Load")) {
            load();
        }
        if (p.equals("ByArea")) {
            // Sort the shapes based on their areas
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_Area));
        }
        if (p.equals("ByAntiArea"))
        {
            // Sort the shapes based on their areas
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_Area));
        }
        if (p.equals("ByPerimeter"))
        {
            // Sort the shapes based on their perimeter
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_Perimeter));
        }
        if (p.equals("ByAntiPerimeter"))
        {
            // Sort the shapes based on their anti perimeter
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter));
        }
        if (p.equals("ByAntiToString"))
        {
            // Sort the shapes based on their anti string
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_toString));
        }
        if (p.equals("ByTag"))
        {
            // Sort the shapes based on their tag
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_Tag));
        }
        if (p.equals("ByAntiTag"))
        {
            // Sort the shapes based on their anti tag
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_Anti_Tag));
        }
        if (p.equals("ByToString")) {
            // Sort the shapes based on their string
            _shapes.sort(new ShapeComp(Ex2_Const.Sort_By_toString));
        }
        if (p.equals("Clear")) {
            _shapes.removeAll();
        }
        if (p.equals("None")) {
            selectNone();
        }
        if (p.equals("All")) {
            selectAll();
        }
        if (p.equals("Anti")) {
            selectAnti();
        }
        if (p.equals("Info")) {
            System.out.println(getInfo());
        }
        drawShapes();
    }

    private void save() {
        FileDialog chooser = new FileDialog(StdDraw_Ex2.getFrame(), "Save to Text file", FileDialog.SAVE);
        chooser.setVisible(true);
        String filename = chooser.getFile();
        if (filename != null) {
            _shapes.save(chooser.getDirectory() + File.separator + chooser.getFile());
        }
    }

    private void load() {
        FileDialog chooser = new FileDialog(StdDraw_Ex2.getFrame(), "Load from Text file", FileDialog.LOAD);
        chooser.setVisible(true);
        String filename = chooser.getFile();
        if (filename != null) {
            _shapes.load(chooser.getDirectory() + File.separator + chooser.getFile());
        }
    }

    public void mouseClicked(Point_2D p) {
        System.out.println("Mode: " + _mode + "  " + p);
        if (_mode.equals("Rect") || _mode.equals("Circle") || _mode.equals("Segment")) {
            if (_gs == null) {
                _p1 = new Point_2D(p);
            } else {
                _gs.setColor(_color);
                _gs.setFilled(_fill);
                _shapes.add(_gs);
                _gs = null;
                _p1 = null;
            }
        }
        if (_mode.equals("Move")) {
            if (_p1 == null) {
                _p1 = new Point_2D(p);
            } else {
                _p1 = new Point_2D(p.x() - _p1.x(), p.y() - _p1.y());
                move();
                _p1 = null;
            }
        }
        if (_mode.equals("Copy")) {
            if (_p1 == null) {
                _p1 = new Point_2D(p);
            } else {
                _p1 = new Point_2D(p.x() - _p1.x(), p.y() - _p1.y());
                copy();
                _p1 = null;
            }
        }
        if (_mode.equals("Rotate")) {
            if (_p1 == null) {
                _p1 = new Point_2D(p);
            } else {
                rotate(p);
                _p1 = null;
            }
        }
        if (_mode.equals("Polygon")) {
            if (_pp == null) {
                _pp = new Polygon_2D();
            }
            _p1 = new Point_2D(p);
            _pp.add(p);
        }

        if (_mode.equals("Triangle")) {
            if (_pp == null) {
                _pp = new Polygon_2D();
            }
            _p1 = new Point_2D(p);
            _pp.add(p);
            if (_pp.getAllPoints().length == 3) {
                Point_2D[] pp = _pp.getAllPoints();
                Triangle_2D tt = new Triangle_2D(pp[0], pp[1], pp[2]);
                GUI_Shape s = new GUIShape(tt, _fill, _color, 0);
                _shapes.add(s);
                _pp = null;
                _p1 = null;
                _gs = null;
            }
        }
        if (_mode.equals("Point")) {
            select(p);
        }
        //
        if (_mode.equals("Scale_90%")) {
            scale(p, 0.9);
        }
        if (_mode.equals("Scale_110%")) {
            scale(p, 1.10);
        }
        drawShapes();
    }
    private void removeSelectedShapes() {
        for (int i = _shapes.size() - 1; i >= 0; i--) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected()) {
                _shapes.removeElementAt(i);
            }
        }
    }
    private void scale(Point_2D p, double ratio) {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            GeoShape g = s.getShape();
            if (s.isSelected() && g != null) {
                g.scale(p, ratio);
            }
        }
    }

    private void select(Point_2D p) {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            GeoShape g = s.getShape();
            if (g != null && g.contains(p)) {
                s.setSelected(!s.isSelected());
            }
        }
    }

    private void move() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            GeoShape g = s.getShape();
            if (s.isSelected() && g != null) {
                g.translate(_p1);
            }
        }
    }

    private void copy() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected()) {
                GUI_Shape s1 = s.copy();
                GeoShape g = s1.getShape();
                g.translate(_p1);
                _shapes.add(s1);
            }
        }
    }

    private void rotate(Point_2D ang) {
        double dx = ang.x() - _p1.x();
        double dy = ang.y() - _p1.y();
        double da = Math.atan2(dy, dx);
        da = Math.toDegrees(da);
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            GeoShape g = s.getShape();
            if (s.isSelected()) {
                g.rotate(_p1, da);
            }
        }
    }

    private void selectAll() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            s.setSelected(true);
        }
    }

    //printInfo
    private void printInfo() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            if (s.isSelected()) {
                System.out.println(i + ") " + s.toString());
            }
        }
    }

    private void selectNone() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            s.setSelected(false);
        }
    }

    private void selectAnti() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            s.setSelected(!s.isSelected());
        }
    }

    public void mouseRightClicked(Point_2D p) {
        if (_mode.equals("Polygon") && _pp != null) {
            GUIShape s = new GUIShape(_pp, _fill, _color, 0);
            _shapes.add(s);
        }
        _pp = null;
        _gs = null;
        _p1 = null;
        drawShapes();


    }

    public void mouseMoved(MouseEvent e) {
        if (_p1 != null) {
            double x1 = StdDraw_Ex2.mouseX();
            double y1 = StdDraw_Ex2.mouseY();
            GeoShape gs = null;
            //	System.out.println("M: "+x1+","+y1);
            Point_2D p = new Point_2D(x1, y1);
            if (_mode.equals("Circle")) {
                double r = _p1.distance(p);
                gs = new Circle_2D(_p1, r);
            }
            if (_mode.equals("Rect")) {
                gs = new Rect_2D(_p1, p);
            }
            if (_mode.equals("Segment")) {
                gs = new Segment_2D(_p1, p);
            }

            if (_mode.equals("Polygon") || _mode.equals("Triangle")) {
                if (_pp == null) {
                    _pp = new Polygon_2D();
                    _pp.add(_p1);
                }
                Polygon_2D gg = new Polygon_2D(_pp);
                gg.add(p);
                gs = gg;
            }
            _gs = new GUIShape(gs, false, Color.pink, 0);
            drawShapes();
        }
    }

    @Override
    public GUI_Shape_Collection getShape_Collection() {
        // TODO Auto-generated method stub
        return this._shapes;
    }

    @Override
    public void show() {
        show(Ex2_Const.DIM_SIZE);
    }

    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        String ans = "";
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shape s = _shapes.get(i);
            ans += s.toString() + "\n";
            //	ans +=s.toString()+"  area: "+s.getShape().area()+"  per: "+s.getShape().perimeter()+"\n";
        }
        return ans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ex2 ex2 = (Ex2) o;
        return _fill == ex2._fill && Objects.equals(_shapes, ex2._shapes) && Objects.equals(_gs, ex2._gs) && Objects.equals(_pp, ex2._pp) && Objects.equals(_color, ex2._color) && Objects.equals(_mode, ex2._mode) && Objects.equals(_p1, ex2._p1);
    }
}
