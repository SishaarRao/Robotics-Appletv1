import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppletV1
{
   private static JFrame frame = new JFrame("Frame Test");
   private static void createFrame()
   {
      //pack frame
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      frame.pack();

      //create confirmation pane for exit
      frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent arg0) {
            int result = JOptionPane.showConfirmDialog((Component) null, "Confirm Exit","Confirmation", JOptionPane.YES_NO_OPTION);
	    //Safe exit, no thrown error
            if (result == 0) {
                System.exit(0);
            } else {
		//Cancel operation
		
            }
        }
      });

      //determine size of screen, create frame accordingly
      GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
      //Set width and height to frame
      int width = gd.getDisplayMode().getWidth();
      int height = gd.getDisplayMode().getHeight();
      frame.setSize(width,height);

      //Create Main Content Pane
      JLabel contentPane = new JLabel();
      contentPane.setIcon( backgroundImage );
      contentPane.setLayout( new BorderLayout() );
      frame.setContentPane( contentPane );

      //set visible
      frame.setVisible(true);
   }
   public static void main(String[] args)
   {
      javax.swing.SwingUtilities.invokeLater(new Runnable(){
         public void run()
         {
            createFrame();
         }
      });
   }
}
