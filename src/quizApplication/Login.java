package quizApplication;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	JButton rules;  // JButton defines globally because you want to use it in Action Listener method
	JButton back;
	JTextField tfName;
	Login(){
	getContentPane().setBackground(Color.WHITE);	// for changing the background color by accessing the frame by this object	
	 // image details from line  10 to 15
	setLayout(null); // for setting image with own dimension
	ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg")); // select image	
	JLabel image = new JLabel(i); // make image object
	image.setBounds(0,0,600,500);  // image dimensions
	add(image);  // add image on frame
	
	
	// details of Simple Mind Heading detail
	JLabel heading  = new JLabel("Simple Minds"); // for creating heading
	heading.setBounds(750,60,300,45);  // for display on frame
	heading.setFont(new Font("Viner Hand ITC", Font.BOLD,40));  // font details
	//heading.setForeground(new Color(30,144,254));
	heading.setForeground(Color.BLUE); // text details
	add(heading);  // add on frame
	
	// details of Enter name heading
		JLabel name  = new JLabel("Enter Your Name");
		name.setBounds(810,150,300,20);
		name.setFont(new Font("Viner Hand ITC", Font.BOLD,20));
		//heading.setForeground(new Color(30,144,254));
		name.setForeground(Color.BLUE);
		add(name);
		
		// For making the box of Name
		tfName = new JTextField(); // class object for making box
		tfName.setBounds(735,200,300,25); // Coordinates of Box
		tfName.setFont(new Font("Times New Roman", Font.BOLD,20)); // Font style
		add(tfName); //  for add on frame
		
		
		// Creating the  Rule buttons 
		rules = new JButton("Rules");  // making the object of button class with button name is Rules
		rules.setBounds(735,270,120,25);  // Coordinates
		rules.setBackground(new Color(30,144,254));  // Background color
		rules.setForeground(Color.WHITE);  // ForeGround Color
		rules.addActionListener(this); // for linking with Click button and action listener
		add(rules); // For add on frame
		
		// Creating the  Back buttons 
		 back = new JButton("Back");
		back.setBounds(915,270,120,25);
		back.setBackground(new Color(30,144,254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this); 
		add(back);
		
	
	
	setSize(1200,500); // Firstly set the size of frame by width and height
	setLocation(200,150); // For open the frame to required location
	setVisible(true);  // for making frame visible
	
	}
	
	public static void main(String[] args) {
		
		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

            if(ae.getSource() == rules) {
            	setVisible(false);// For closing the window
            	String name = tfName.getText();  // to get the box text value
            	new Rules(name); // For opening the new  window and pass the name
            	
            } else if (ae.getSource()==back) {
            	setVisible(false);  // For closing the window
            	
            }
           
            
		
	}
	
	
	
}
