import java.awt.Color;
import java.awt.Graphics;

/* Name: Jimmy Lin
 * 
 * Date: November 7, 2017
 * 
 * Description: Rectangle class containing attributes of a rectangle and accessor and mutator methods, inherits from FillableShape class.
 */


public class Rectangle extends FillableShape{
    
    // Constructor takes 4 int parameters representing coordinates of the shape, 1 Color object representing its colour, and a boolean representing if its a solid shape  
    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean filled){
        super(x1,y1,x2,y2,color,filled);
    }
    
    // This method takes a Graphics object as a parameter and draws the shape. Draws filled or unfilled shapes depending on filled variable
    @Override
    public void draw (Graphics g){
        g.setColor(getColor());
        if (getFilled()){
            g.fillRect(getUpperLeftX(),getUpperLeftY(),getWidth(),getHeight());
        }else{
            g.drawRect(getUpperLeftX(),getUpperLeftY(),getWidth(),getHeight());
        }
    }
}