import javax.swing.JFrame;

/* Name: Jimmy Lin
 * 
 * Date: April 30, 2018
 * 
 * Description: Test class for SuperPaint program
 */

class SuperPaint {
    public static void main(String[] args) {
        DrawFrame application = new DrawFrame();
        application.setSize( 480, 320 );
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setVisible( true );
    }
}