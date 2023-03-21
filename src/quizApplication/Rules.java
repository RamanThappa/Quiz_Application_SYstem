package quizApplication;
 import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class Rules extends JFrame implements ActionListener{
	 String name;
	 JButton start;
	 JButton back;
	Rules(String name){
		 this.name = name;
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		
		// details of Welcome to Quiz heading
		JLabel heading  = new JLabel("welcome " + name + " to Simple Minds"); // for creating heading
		heading.setBounds(50,20,700,30);  // for display on frame
		heading.setFont(new Font("Viner Hand ITC", Font.BOLD,28));  // font details
		//heading.setForeground(new Color(30,144,254));
		heading.setForeground(Color.BLUE); // text details
		add(heading);  // add on frame
		
		// details of rules which will shown to the user
		JLabel rules  = new JLabel(); // for creating heading
		rules.setBounds(20,90,700,350);  // for display on frame		
		rules.setFont(new Font("Tahoma", Font.PLAIN,16));  // font details
		// For creating own text
		rules.setText("<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>");
		add(rules);  // add on frame
	
		// Creating the  Back button 
				 back = new JButton("Back");
				back.setBounds(250,500,100,30);
				back.setBackground(new Color(30,144,254));
				back.setForeground(Color.WHITE);
				back.addActionListener(this); 
				add(back);
				
				// Creating the  Start button 
				start = new JButton("Start");  // making the object of button class with button name is Rules
				start.setBounds(400,500,100,30);  // Coordinates
				start.setBackground(new Color(30,144,254));  // Backgrond color
				start.setForeground(Color.WHITE);  // ForeGround Color
				start.addActionListener(this); // for linking with Click button and action listener
				add(start); // For add on frame
		
		setSize(800,650);
		setLocation(350,100);
		setVisible(true);
	}
	
public static void main(String[] args) {
	
	 new Rules("User");
  }

@Override
  public void actionPerformed(ActionEvent ae) {
  if(ae.getSource()==start) {
	 setVisible(false);
	 new Quiz(name);
   } else {
	setVisible(false);
	new Login();
	
}
	
  }
}
