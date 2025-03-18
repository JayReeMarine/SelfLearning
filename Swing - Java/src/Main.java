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

//        MyFrame frame = new MyFrame();

        //--------------------------------------------------------------------------------
        //part five

        // layout managers = define the natural layout for components within a container

        // BorderLayout = a layout manager that manages components in five areas: north, south, west, east, center

//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500,500);
//
//        frame.setLayout(new BorderLayout(10,20));
//        frame.setVisible(true);
//
//        JPanel panel1 = new JPanel();
//        JPanel panel2 = new JPanel();
//        JPanel panel3 = new JPanel();
//        JPanel panel4 = new JPanel();
//        JPanel panel5 = new JPanel();
//
//        panel1.setBackground(Color.red);
//        panel2.setBackground(Color.green);
//        panel3.setBackground(Color.yellow);
//        panel4.setBackground(Color.magenta);
//        panel5.setBackground(Color.blue);
//
//        panel1.setPreferredSize(new Dimension(100,100));
//        panel2.setPreferredSize(new Dimension(100,100));
//        panel3.setPreferredSize(new Dimension(100,100));
//        panel4.setPreferredSize(new Dimension(100,100));
//        panel5.setPreferredSize(new Dimension(100,100));
//
//        //----- sub panels -----
//
//        JPanel panel6 = new JPanel();
//        JPanel panel7 = new JPanel();
//        JPanel panel8 = new JPanel();
//        JPanel panel9 = new JPanel();
//        JPanel panel10 = new JPanel();
//
//        panel6.setBackground(Color.black);
//        panel7.setBackground(Color.darkGray);
//        panel8.setBackground(Color.gray);
//        panel9.setBackground(Color.lightGray);
//        panel10.setBackground(Color.white);
//
//        panel5.setLayout(new BorderLayout());
//
//        panel6.setPreferredSize(new Dimension(50,50));
//        panel7.setPreferredSize(new Dimension(50,50));
//        panel8.setPreferredSize(new Dimension(50,50));
//        panel9.setPreferredSize(new Dimension(50,50));
//        panel10.setPreferredSize(new Dimension(50,50));
//
//        panel5.add(panel6, BorderLayout.NORTH);
//        panel5.add(panel7, BorderLayout.SOUTH);
//        panel5.add(panel8, BorderLayout.WEST);
//        panel5.add(panel9, BorderLayout.EAST);
//        panel5.add(panel10, BorderLayout.CENTER);
//
//        frame.add(panel1, BorderLayout.NORTH);
//        frame.add(panel2, BorderLayout.WEST);
//        frame.add(panel3, BorderLayout.EAST);
//        frame.add(panel4, BorderLayout.SOUTH);
//        frame.add(panel5, BorderLayout.CENTER);

        //--------------------------------------------------------------------------------
        //part six

        // FlowLayout = a layout manager that places components in a row, sized at their preferred size.
        //              If the horizontal space in the container is too small,
        //              the FlowLayout class uses the next available row.

//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500,500);
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//
//        JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(100,250));
//        panel.setBackground(Color.lightGray);
//        panel.setLayout(new FlowLayout());
//
//
//
//        panel.add(new JButton("1"));
//        panel.add(new JButton("2"));
//        panel.add(new JButton("3"));
//        panel.add(new JButton("4"));
//        panel.add(new JButton("5"));
//        panel.add(new JButton("6"));
//        panel.add(new JButton("7"));
//        panel.add(new JButton("8"));
//        panel.add(new JButton("9"));
//
//        frame.add(panel);
//        frame.setVisible(true);

        //--------------------------------------------------------------------------------
        //part seven

        // GridLayout = a layout manager that lays out a container's components in a rectangular grid

//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500,500);
//        frame.setLayout(new GridLayout(3,3,10,10));
//
//        frame.add(new JButton("1"));
//        frame.add(new JButton("2"));
//        frame.add(new JButton("3"));
//        frame.add(new JButton("4"));
//        frame.add(new JButton("5"));
//        frame.add(new JButton("6"));
//        frame.add(new JButton("7"));
//        frame.add(new JButton("8"));
//        frame.add(new JButton("9"));
//
//
//        frame.setVisible(true);

        //--------------------------------------------------------------------------------
        //part eight

        // JLayeredPane = Swing container that provides a third dimension for positioning components

//        JLabel label1 = new JLabel();
//        label1.setOpaque(true);
//        label1.setBackground(Color.red);
//        label1.setBounds(50,50,200,200);
//
//        JLabel label2 = new JLabel();
//        label2.setOpaque(true);
//        label2.setBackground(Color.green);
//        label2.setBounds(100,100,200,200);
//
//        JLabel label3 = new JLabel();
//        label3.setOpaque(true);
//        label3.setBackground(Color.blue);
//        label3.setBounds(150,150,200,200);
//
//        JLayeredPane layeredPane = new JLayeredPane();
//        layeredPane.setBounds(0,0,500,500);
//
//        layeredPane.add(label1, Integer.valueOf(0));
//        layeredPane.add(label2, JLayeredPane.DEFAULT_LAYER);
//        layeredPane.add(label3, JLayeredPane.DRAG_LAYER);
//
//        JFrame frame = new JFrame("JLayeredPane");
//        frame.add(layeredPane);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500,500);
//        frame.setLayout(null);
//        frame.setVisible(true);

        //--------------------------------------------------------------------------------
        //part nine

//        LaunchPage launchPage = new LaunchPage();

        //--------------------------------------------------------------------------------
        //part ten

        //JOptionPane = pop up a standard dialog box that prompts users for a value or informs them of something.

//        JOptionPane.showMessageDialog(null, "This is some useful information.", "Title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is really useful information.", "Title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Really?", "Title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "You've been warned", "Title", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Call tech support!", "Title", JOptionPane.ERROR_MESSAGE);

        //System.out.println(JOptionPane.showConfirmDialog(null, "Bro, do you even code?", "This is my title", JOptionPane.YES_NO_CANCEL_OPTION));

//        String name = JOptionPane.showInputDialog("What is your name?:  ");
//        System.out.println("Hello " + name);

        String[] responses = {"No, you're awesome!", "Thank you!", "*blush*"};
        JOptionPane.showOptionDialog(null,
                "This is my custom dialog",
                "secret message",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                responses,
                0);
    }
}