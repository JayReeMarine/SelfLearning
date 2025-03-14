import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setTitle("JFrame title goes here"); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false); // prevent frame from being resized
        this.setSize(420,420); // sets the dimensions of the frame
        this.setVisible(true); // makes frame visible

        ImageIcon image = new ImageIcon("for upload.png"); // create an ImageIcon

        this.setIconImage(image.getImage()); // change icon of frame

        this.getContentPane().setBackground(new Color(123,50,250)); // change color of background
    }
}