import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //  JFrame = a GUI window to add components to
        /*
        JFrame frame = new JFrame(); // creates a frame
        frame.setTitle("JFrame title goes here"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        frame.setResizable(false); // prevent frame from being resized
        frame.setSize(420,420); // sets the dimensions of the frame
        frame.setVisible(true); // makes frame visible

        ImageIcon image = new ImageIcon("for upload.png"); // create an ImageIcon

        frame.setIconImage(image.getImage()); // change icon of frame

        frame.getContentPane().setBackground(new Color(123,50,250)); // change color of background


         */
        //MyFrame myFrame = new MyFrame(); // part one

        //--------------------------------------------------------------------------------
        //part two

        // JLabel = a GUI display area for a string of text, an image, or both

//        ImageIcon image = new ImageIcon("AWS Image.png"); // create an ImageIcon
//
//        Border border = BorderFactory.createLineBorder(Color.green, 3); // create a border
//
//
//        JLabel label = new JLabel(); // create a label
//        label.setText("Hello"); // set text of label
//        label.setIcon(image); // add image to label
//        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
//        label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
//        label.setForeground(Color.green); // set font color of text
//        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // set font of text
//        label.setIconTextGap(100); // set gap of text to image
//        label.setBackground(Color.black); // set background color
//        label.setOpaque(true); // display background color
//        label.setBorder(border); // set border of label
//        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
//        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label
//        //label.setBounds(100,100,500,500); // set x, y position within frame as well as dimensions
//
//        JFrame frame = new JFrame(); // creates a frame
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
//        //frame.setSize(420,420); // sets the dimensions of the frame
//        //frame.setLayout(null); // set layout to null
//
//        frame.setVisible(true);
//        frame.add(label); // add label to frame
//        frame.pack(); // fit size of frame to preferred size of its subcomponents

        //--------------------------------------------------------------------------------
        //part three

        // JPanel = a GUI component that functions as a container to hold other components
//        ImageIcon icon = new ImageIcon("AWS Image.png");
//
//        JLabel label = new JLabel();
//        label.setText("Hello this is Jaeyun");
//        label.setIcon(icon);
//        label.setHorizontalTextPosition(JLabel.CENTER);
//        label.setVerticalTextPosition(JLabel.TOP);
//        label.setBounds(0,0,250,250);
//
//
//        JPanel redPanel = new JPanel(); // create a panel
//        redPanel.setBackground(Color.red); // set background color
//        redPanel.setBounds(0,0,250,250); // set x, y position within frame as well as dimensions
//
//        JPanel bluePanel = new JPanel(); // create a panel
//        bluePanel.setBackground(Color.blue); // set background color
//        bluePanel.setBounds(250,0,250,250); // set x, y position within frame as well as dimensions
//
//        JPanel greenPanel = new JPanel(); // create a panel
//        greenPanel.setBackground(Color.green); // set background color
//        greenPanel.setBounds(0,250,500,250); // set x, y position within frame as well as dimensions
//        greenPanel.setLayout(null); // set layout of panel
//
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(null);
//        frame.setSize(1000,1000);
//        frame.setVisible(true);
//
//        frame.add(redPanel);
//        frame.add(bluePanel);
//        frame.add(greenPanel);
//        greenPanel.add(label);

        //--------------------------------------------------------------------------------
        //part four

        // JButton = a button that performs an action when clicked on

        MyFrame frame = new MyFrame();



    }
}