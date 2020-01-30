import java.awt.Color;
import java.awt.Graphics;

/* Name: Jimmy Lin
 * 
 * Date: November 7, 2017
 * 
 * Description: Abstract class containing basic attributes of a shape and its accessor and mutator methods.
 */

abstract public class Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    
    public Shape(){
        this(0,0,0,0,Color.WHITE);
    }
    
    
    // Constructor takes 4 int parameters representing coordinates of the shape
    public Shape(int x1, int y1, int x2, int y2, Color color){
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setColor(color);
    }
    
    // Mutator for x2 instance variable
    public void setX1(int newInt){
        // Sanity checking ensures a more than zero coordinate
        if (newInt < 0) {
            System.err.println( "Attempt to set x1 to <0 ignored, setting to 0 by default." );
            x1 = 0;
        }
        else {
            x1 = newInt;
        }
    }
    
    // Mutator for x2 instance variable
    public void setX2(int newInt){
        // Sanity checking ensures a more than zero coordinate
        if (newInt < 0) {
            System.err.println( "Attempt to set x2 to <0 ignored, setting to 0 by default." );
            x2 = 0;
        }
        else {
            x2 = newInt;
        }
    }
    
    // Mutator for y1 instance variable
    public void setY1(int newInt){
        // Sanity checking ensures a more than zero coordinate
        if (newInt < 0) {
            System.err.println( "Attempt to set y1 to <0 ignored, setting to 0 by default." );
            y1 = 0;
        }
        else {
            y1 = newInt;
        }
    }
    
    // Mutator for y2 instance variable
    public void setY2(int newInt){
        // Sanity checking ensures a more than zero coordinate
        if (newInt < 0) {
            System.err.println( "Attempt to set y2 to <0 ignored, setting to 0 by default." );
            y2 = 0;
        }
        else {
            y2 = newInt;
        }
    }
    
    // Mutator for filled instance variable
    public void setColor(Color color){
        this.color = color;
    }
    
    // Accessor for x1 instance variable
    public int getX1(){
        return x1;
    }
    
    // Accessor for x2 instance variable
    public int getX2(){
        return x2;
    }
    
    // Accessor for y1 instance variable
    public int getY1(){
        return y1;
    }
    
    // Accessor for y2 instance variable
    public int getY2(){
        return y2;
    }
    
    // Accessor for filled instance variable
    public Color getColor(){
        return color;
    }
    
    // Abstract method for shape drawing
    public abstract void draw(Graphics g);
}