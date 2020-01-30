import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

/* Name: Jimmy Lin
 * 
 * Date: April 30, 2018
 * 
 * Description: JPanel for drawing shapes.
 */

public class DrawPanel extends JPanel {
    private boolean filled;
    private Color chosenColor;
    private JLabel statusBar;
    private int shapeType;
    private Shape currentDrawing = null;
    private LinkedList<Shape> shapes = new LinkedList<>();
    private LinkedList<Shape> shapesUndone = new LinkedList<>();
    
    // Constructor takes a statusLabel as a parameter to update mouse position, also sets up mouse listeners and defaults drawing settings
    public DrawPanel( JLabel statusLabel ) {
        shapeType = 0;
        chosenColor = Color.RED;
        filled = false;
        statusBar = statusLabel;
        setBackground( Color.WHITE );
        
        MouseEventListener drawPanelListener = new MouseEventListener();
        addMouseListener( drawPanelListener );
        addMouseMotionListener( drawPanelListener );
    }
    
    // Takes a boolean as a parameter to draw filled or unfilled shapes
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    // Takes an int as a paramenter to set the type of shape to draw
    public void setShape(int shapeType){
        this.shapeType = shapeType;
    }
    
    // Returns the color as a Color object
    public Color getChosenColor(){
        return chosenColor;
    }
    
    // Takes a Color object as a parameter and sets the chosen color
    public void setChosenColor(Color chosenColor){
        this.chosenColor = chosenColor;
    }
    
    // Inner class to handle mouse events
    class MouseEventListener extends MouseAdapter {
        // Mouse press indicates a new shape is being drawn
        @Override
        public void mousePressed( MouseEvent event ) {
            // Draws shape depending on what user has set
            switch (shapeType) {
                case 0: currentDrawing = new Line(event.getX(), event.getY(), event.getX(), event.getY(), chosenColor);
                break;
                case 1: currentDrawing = new Oval(event.getX(), event.getY(), event.getX(), event.getY(), chosenColor, filled);
                break;
                case 2: currentDrawing = new Rectangle(event.getX(), event.getY(), event.getX(), event.getY(), chosenColor, filled);
                break;
            }
            repaint();
        }
        
        // Mouse release indicates the new shape is finished
        @Override
        public void mouseReleased( MouseEvent event ) {
            // Update ending coordinates and switch color to user's choice
            currentDrawing.setX2( event.getX() );
            currentDrawing.setY2( event.getY() );
            currentDrawing.setColor( chosenColor );
            
            shapes.addFirst(currentDrawing);
            
            // Get ready for the next shape to be drawn
            currentDrawing = null;
            repaint();
            shapesUndone.clear();
        }
        
        // As mouse is dragged, update ending coordinates of currentDrawing and statusBar
        @Override
        public void mouseDragged( MouseEvent event ) {
            currentDrawing.setX2(event.getX());
            currentDrawing.setY2(event.getY());
            statusBar.setText( String.format("(%d, %d)", event.getX(), event.getY()));
            repaint();
        }
        
        // As mouse is moved, update the statusBar
        @Override
        public void mouseMoved( MouseEvent event ) {
            statusBar.setText(String.format( "(%d, %d)", event.getX(), event.getY()));
        }
    }
    
    // This method is called automatically by the JVM when the window needs to be (re)drawn.
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        // Draw all drawn shapes
        drawShapes(g);
        
        // If a shape is in progress, draw it on top of all others
        if ( currentDrawing != null )
            currentDrawing.draw( g );
    }
    
    // Helper method for drawing all shapes
    private void drawShapes(Graphics g) {
        Shape tempShape;
        for (int i = 0; i < shapes.size(); i++) {
            tempShape = shapes.removeLast();
            tempShape.draw(g);
            shapes.addFirst(tempShape);
        }
    }
    
    // Removes drawn shapes into seperate undone shapes list 
    public void undo(){
        if (shapes.size() > 0){
            shapesUndone.addFirst(shapes.removeFirst());
        }
    }
    
    // Adds undone shapes back with drawn shapes
    public void redo(){
        if (shapesUndone.size() > 0){
            shapes.addFirst(shapesUndone.removeFirst());
        }
    }
    
    // Clears all drawn and undone shapes
    public void clear(){
        shapes.clear();
        shapesUndone.clear();
    }
    
} 