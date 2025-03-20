import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{
    // Part1
//    MyFrame(){
//        this.setTitle("JFrame title goes here"); // sets title of frame
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
//        this.setResizable(false); // prevent frame from being resized
//        this.setSize(420,420); // sets the dimensions of the frame
//        this.setVisible(true); // makes frame visible
//
//        ImageIcon image = new ImageIcon("for upload.png"); // create an ImageIcon
//
//        this.setIconImage(image.getImage()); // change icon of frame
//
//        this.getContentPane().setBackground(new Color(123,50,250)); // change color of background

    // Part4
//    JButton button;
//    JLabel label;
//    MyFrame(){
//
//        ImageIcon icon = new ImageIcon("thumbs up2.jpg");
//        ImageIcon icon2 = new ImageIcon("thumbs up.jpg");
//
//        label = new JLabel();
//        label.setIcon(icon2);
//        label.setBounds(150,250,150,150);
//        label.setVisible(false);
//
//        button = new JButton(); // create a button
//        button.setBounds(200,100,250,100); // set x, y position within frame as well as dimensions
//        button.addActionListener(this); // add action listener
//        button.setText("Click me!"); // set text of button
//        button.setFocusable(false);
//        button.setIcon(icon); // set icon
//        button.setHorizontalTextPosition(JButton.CENTER); // set text LEFT, CENTER, RIGHT of icon
//        button.setVerticalTextPosition(JButton.BOTTOM); // set text TOP, CENTER, BOTTOM of icon
//        button.setFont(new Font("Comic Sans",Font.BOLD,25)); // set font
//        button.setIconTextGap(10); // set gap between text and icon
//        button.setForeground(Color.cyan); // set font color
//        button.setBackground(Color.lightGray); // set background color
//        button.setBorder(BorderFactory.createEtchedBorder()); // set border
//
//
//
//
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
//        this.setLayout(null);
//        this.setSize(500,500);
//        this.setVisible(true);
//        this.add(button);
//        this.add(label);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource()==button){
//            System.out.println("Button Clicked");
//            label.setVisible(true);
//        }
//    }
        //handle button click event

    //------------------
    // Part5
    JButton button;
    JTextField textField;
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));

        textField.setFont(new Font("Consolas",Font.PLAIN,35));
        textField.setForeground(Color.red);
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setText("Username");


        this.add(button);
        this.add(textField);


        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.out.print("Welcome " + textField.getText());
            button.setEnabled(false);
            textField.setEditable(false);

        }
    }


}