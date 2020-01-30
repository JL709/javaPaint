import java.awt.Color;
import java.awt.Graphics;

/* Name: Jimmy Lin
 * 
 * Date: November 7, 2017
 * 
 * Description: Line class containing attributes of a rectangle and accessor and mutator methods, inherits from Shape class.
 */


public class Line extends Shape{
    
    // Constructor takes 4 int parameters representing coordinates of the shape, and 1 Color object representing its colour
    public Line(int x1, int y1, int x2, int y2, Color color){
        super(x1,y1,x2,y2,color);
    }
    
    // This method takes a Graphics object as a parameter and draws the line
    @Override
    public void draw (Graphics g){
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}