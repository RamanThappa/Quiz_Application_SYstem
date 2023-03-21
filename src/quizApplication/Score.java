package quizApplication;
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;
 public class Score extends JFrame implements ActionListener{
	JButton submit;
	Score(String name, int score){
		//SetBounds is used to select the location of the object or image or text or heading or button
				setBounds(400,150,750,550); // frame width distance from left, height distance from top, width dimension, height dimension respectively 		
				getContentPane().setBackground(Color.WHITE); // setting background color of frame
				setLayout(null); // for creating own layout
				
				ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpeg")); // select image	
				 Image i2 = i.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
				 ImageIcon i3 = new ImageIcon(i2);
				JLabel image = new JLabel(i3); // make image object
				image.setBounds(0,200,300,250);  // image dimensions
				add(image);  // add image on frame
				
				
				//JLabel is used to make headings
				 JLabel heading = new JLabel("Thankyou " + name + " for playing Simple Minds");
				 heading.setBounds(45,30,700,30);
				 heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
				add(heading);
				
				//JLabel is used to make headings
				 JLabel lblscore = new JLabel("Your score is "+ score);
				 lblscore.setBounds(350,200,300,30);
				 lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
				add(lblscore);
				
				//Making the Submit button and its details
				 submit = new JButton("Play Again");
				submit.setBounds(380,270,120,30);
			//	submit.setFont(new Font("Tahoma", Font.PLAIN,22));
				submit.setBackground(new Color(30,144,255));
				submit.setForeground(Color.WHITE);
				submit.addActionListener(this);  // For performing the click operation
				add(submit);
				
				
				
				setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
		setVisible(false);
		new Login();
		}
	}
	public static void main(String[] args) {
		new Score("User" , 0);
	}

}
