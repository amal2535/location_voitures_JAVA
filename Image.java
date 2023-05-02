import javax.swing.*;
import java.awt.*;
public class Image {

  public static void main(String args[]) 
  {
    JFrame frame = new JFrame("Display an image in the background");
    final ImageIcon icon = new ImageIcon("image.jpg");
    JTextArea text = new JTextArea() 
    {
      java.awt.Image img = icon.getImage();
      // instance initializer
      {setOpaque(false);}
      public void paintComponent(Graphics graphics) 
      {
        graphics.drawImage(img, 0, 0, this);
        super.paintComponent(graphics);
      }
    };
    JScrollPane pane = new JScrollPane(text);
    Container content = frame.getContentPane();
    content.add(pane, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(3);
    frame.setSize(400, 300);
    frame.setVisible(true);
  }
}

