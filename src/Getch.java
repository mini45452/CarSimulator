import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Getch
{
    private static char c;
    private static final JFrame frame = new JFrame();
    public static char getch()
    {  
        synchronized(frame)
        {  
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