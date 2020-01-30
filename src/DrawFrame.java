import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JColorChooser;

/* Name: Jimmy Lin
 * 
 * Date: April 30, 2018
 * 
 * Description: Program to draw lines, ovals and rectangles with mouse. Includes ability to undo, redo, clear, choose colors and set filled or unfilled shapes to draw.
 */

public class DrawFrame extends JFrame {
    private String[] shapeList = { "Line", "Oval", "Rectangle" };
    private JComboBox<String> shapeChooser;
    private JButton undoButton;
    private JButton redoButton;
    private JButton clearButton;
    private JButton colorButton;
    private JCheckBox fillBox;
    private DrawPanel drawPanel;
    
    // Constructor sets up widgets and their positioning, and background
    public DrawFrame() {
        setBackground( Color.WHITE );
        getContentPane().setBackground( Color.WHITE);
        
        //Create buttons and check and combo boxes
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        clearButton = new JButton("Clear");
        colorButton = new JButton("Color");
        shapeChooser = new JComboBox<>(shapeList);
        fillBox = new JCheckBox("Filled");

        
        //Create and set listeners for buttons and boxes
        ButtonListener buttonListener = new ButtonListener();
        undoButton.addActionListener(buttonListener);
        redoButton.addActionListener(buttonListener);
        clearButton.addActionListener(buttonListener);
        colorButton.addActionListener(buttonListener);
        shapeChooser.addItemListener(new ShapeChooserListener());
        fillBox.addItemListener(new FilledCheckBoxListener());
        
        // Sets up buttons panel
        JPanel buttons = new JPanel();
        buttons.add(undoButton);
        buttons.add(redoButton);
        buttons.add(clearButton);
        buttons.add(colorButton);
        buttons.add(shapeChooser);
        buttons.add(fillBox);
        buttons.setBackground( Color.LIGHT_GRAY );
        
        // Canvas
        drawPanel = new DrawPanel(statusLabel);
        
        // Mouse position label
        JLabel statusLabel = new JLabel();
        
        // Add all panels and label to the DrawFrame
        add(buttons, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel,BorderLayout.SOUTH );
    }
    
    // Event listener for check box
    class FilledCheckBoxListener implements ItemListener{
        public void itemStateChanged( ItemEvent e ) {
            drawPanel.setFilled(fillBox.isSelected());
        }
    }
    
    // Event listener for combo box
    class ShapeChooserListener implements ItemListener{
        @Override
        public void itemStateChanged( ItemEvent e ) {
            drawPanel.setShape(shapeChooser.getSelectedIndex());
        }
    }
    
    // Event listener for buttons
    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){
            
            if (e.getSource() == undoButton){
                drawPanel.undo();
            }
            else if (e.getSource() == redoButton){
                drawPanel.redo();
            }
            
            else if (e.getSource() == clearButton){
                drawPanel.clear();
            }
            else if (e.getSource() == colorButton){
                // Opens color selector
                drawPanel.setChosenColor(JColorChooser.showDialog( null, "Select a Color!", drawPanel.getChosenColor()));
            }
            drawPanel.repaint();
        }
        
    }
    
} 