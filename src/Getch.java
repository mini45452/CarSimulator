import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Getch
{
    private static char c;
    public static char getch()
    {  
        final JFrame frame = new JFrame();
        synchronized(frame)
        {  
            frame.setUndecorated(true);  
            frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);  
            frame.addKeyListener(new KeyListener()
            {  
                public void keyPressed(KeyEvent e)
                {  
                    synchronized(frame)
                    {  
                        frame.setVisible(false);  
                        frame.dispose();  
                        frame.notify();  
                    }  
                    c = e.getKeyChar();
                }  

                public void keyReleased(KeyEvent e)
                {  
                }  

                public void keyTyped(KeyEvent e)
                {  
                }  
            });
            frame.setVisible(true);  
            try
            {  
                frame.wait();  
            }
            catch(InterruptedException e1)
            {  
            }  
        }  
        return c;
    }
}