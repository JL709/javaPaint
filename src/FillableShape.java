import java.awt.Color;
import java.awt.Graphics;

/* Name: Jimmy Lin
 * 
 * Date: November 7, 2017
 * 
 * Description: FillableShape class containing attributes of a 2D object and accessor and mutator methods.
 */

abstract class FillableShape extends Shape {
    private boolean filled;
    
    public FillableShape(){
        super(0,0,0,0,null);
        setFilled(false);
    }
    
    // Constructor takes 4 int parameters representing coordinates of the shape, 1 Color object representing its colour, and a boolean representing if its a solid shape  
    public FillableShape(int x1, int y1, int x2, int y2, Color color, boolean filled){
        super(x1,y1,x2,y2, color);
        setFilled(filled);
    }
    
    // Mutator for filled instance variable
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    // Accessor for filled instance variable
    public boolean getFilled(){
        return filled;
    }
    
    // Returns the width of the shape as an int
    public int getWidth(){
        return Math.abs(getX1()-getX2());
    }
    
    // Returns the height of the shape as an int
    public int getHeight(){
        return Math.abs(getY1()-getY2());
    }
    
    // Returns the leftmost X of the shape as an int
    public int getUpperLeftX(){
        return Math.min(getX1(),getX2());
    }
    
    // Returns the uppermost Y of the shape as an int
    public int getUpperLeftY(){
        return Math.min(getY1(),getY2());
    }
}