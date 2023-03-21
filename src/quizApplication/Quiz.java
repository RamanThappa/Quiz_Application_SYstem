package quizApplication;
import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
  public class Quiz extends JFrame implements ActionListener {
	
	String[][] questions = new String[10][5]; // For storing question so 10 for number of questions and 5 includes the question and the options itself
	String[][] answers = new String[10][2]; // For Storing the answers	
	String[][] userAnswers = new String[10][1]; //For storing the answer given by the user
	
	JLabel qno,question;
	JRadioButton opt1,opt2,opt3,opt4;
	ButtonGroup groupOption;
	JButton next,submit;
	
	public static int timer  = 15;
	public static int ansGiven = 0;
	public static int count = 0;
	public static int score = 0;
	String name;
	Quiz(String name){
		this.name = name;
		//SetBounds is used to set the location of the object or image or text or heading or button
		setBounds(50,0,1440,850); // frame width distance from left, height distance from top, width dimension, height dimension respectively 		
		getContentPane().setBackground(Color.WHITE); // setting background color of frame
		setLayout(null); // for creating own layout
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpeg")); // select image	
		JLabel image = new JLabel(i); // make image object
		image.setBounds(0,0,1440,392);  // image dimensions
		add(image);  // add image on frame
		
		// For question Number text
		//JLabel is used to make headings
		 qno = new JLabel();
		qno.setBounds(100,450,50,30);
		qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(qno);
		//For Question  text
		question = new JLabel();
		question.setBounds(150,450,900,30);
		question.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(question);
		
		questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
     
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
		
        // Radio button is used to make round shape button used for MCQ
		opt1 = new JRadioButton();
		opt1.setBounds(170,520,700,30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt1);
		
		opt2 = new JRadioButton();
		opt2.setBounds(170,560,700,30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt2);
		
		opt3 = new JRadioButton();
		opt3.setBounds(170,600,700,30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt3);
		
		opt4 = new JRadioButton();
		opt4.setBounds(170,640,700,30);
		opt4.setBackground(Color.WHITE);
		opt4.setFont(new Font("Dialog", Font.PLAIN,20));
		add(opt4);
		
		//ButtonGroup  is used to for selecting one option at one time or to avoid select multiple buttons at one time
		groupOption = new ButtonGroup();
		groupOption.add(opt1);
		groupOption.add(opt2);
		groupOption.add(opt3);
		groupOption.add(opt4);
		
		//Making the Next button and its details
		next = new JButton("Next");
		next.setBounds(1100,550,200,40);
		next.setFont(new Font("Tahoma", Font.PLAIN,22));
		next.setBackground(new Color(30,144,255));
		next.setForeground(Color.WHITE);
		next.addActionListener(this);  // For performing the click operation
		add(next);
		//Making the Submit button and its details
		submit = new JButton("Submit");
		submit.setBounds(1100,630,200,40);
		submit.setFont(new Font("Tahoma", Font.PLAIN,22));
		submit.setBackground(new Color(30,144,255));
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);  // For performing the click operation
		add(submit);
		submit.setEnabled(false); // for disabling it
		
		start(count); // for putting questions and answers
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== next) {
			repaint();
			ansGiven = 1; //Suppose  if user ans
			
			if(groupOption.getSelection()==null) {  // It will tell you user selected any option in mcq or not
				userAnswers[count][0] = "";          // if not then add empty in it
			} else {
				userAnswers[count][0] = groupOption.getSelection().getActionCommand(); //is user selected any option then get it 
			} 
			
			if(count == 8) {
				next.setEnabled(false); // For disabling the next button on last question
				submit.setEnabled(true);// For enabling the sumbit button on last question
			}
			count++;
			start(count);
		} else if (ae.getSource() == submit) {
			ansGiven = 1;
			// Check the last answer option
			if(groupOption.getSelection()==null) {  // It will tell you user selected any option in mcq or not
				userAnswers[count][0] = "";          // if not then add empty in it
			} else {
				userAnswers[count][0] = groupOption.getSelection().getActionCommand(); //is user selected any option then get it 
			} 
			// For calculating the score of the user
			for(int i =0; i<userAnswers.length; i++) {
				if(userAnswers[i][0].equals(answers[i][1])) {
					score =score + 10;
				} else {
					score = score + 0;
				}
			}
			//At last close the frame
			setVisible(false);
			//Opening the next frame
			new Score(name, score);
		}
	}
	
	// {Paint function is used for question timer .
	//Paint function works on graphics
	public void paint(Graphics g) {
		super.paint(g);
		String time = "Time left - " + timer + " seconds"; // this will display on Screen
		g.setColor(Color.RED); //Timer color
		g.setFont(new Font("Tahoma", Font.BOLD, 25)); //Timer font style
		
		if(timer>0) {
			g.drawString(time, 1100,500); //If it is in time then it will show you the time
		} else {
			g.drawString("Times up!!", 1100,500); //If it is out of time then it will show you times up
		}
		timer--;
		try {
			Thread.sleep(1000); //For stoping the time for 1 second (1 second == 1000 millisecond)
			repaint();          // then again call on timer which will be decreasing by 1 second
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// it is used to set the timer 
		if(ansGiven == 1) {
			ansGiven = 0;
			timer  = 15;           // Again set the timer 15 sec for nrxt question
		} else if (timer<0) {
			timer = 15;            // Again set the timer 15 sec for nrxt question
			if(count == 8) {
				next.setEnabled(false); // For disabling the next button on last question
				submit.setEnabled(true);// For enabling the sumbit button on last question
			}
			// For autoSubmit by program
			if(count == 9) {  
				//For checking the last selected option
				if(groupOption.getSelection()==null) {  // It will tell you user selected any option in mcq or not
					userAnswers[count][0] = "";          // if not then add empty in it
				} else {
					userAnswers[count][0] = groupOption.getSelection().getActionCommand(); //is user selected any option then get it 
				} 
				// For calculating the score of the user
				for(int i =0; i<userAnswers.length; i++) {
					if(userAnswers[i][0].equals(answers[i][1])) {
						score =score + 10;
					} else {
						score = score + 0;
					}
				}
				//At last close the frame
				setVisible(false);
				new Score(name, score);
				
				
			} else {  //For auto Next Button		
			if(groupOption.getSelection()==null) {  // It will tell you user selected any option in mcq or not
				userAnswers[count][0] = "";          // if not then add empty in it
			} else {
				userAnswers[count][0] = groupOption.getSelection().getActionCommand(); //is user selected any option then get it 
			}                                                                          // getSelection is used to check the selected option       
			count++;         // for next Question details                                                            //getActionCommand is used to get the value of the selected option                                           
			start(count);    // For next question
			  }
		}
			
		
	}
	public void start(int count) {
		
		// complete MCQ details
		qno.setText(""+(count+1)+ ". ");       // for setting the question number
		question.setText(questions[count][0]); // for setting the question 
		
		opt1.setText(questions[count][1]);     // for setting the option 1
		opt1.setActionCommand(questions[count][1]); //For setting the action		
		
		opt2.setText(questions[count][2]);     // for setting the option 2
		opt2.setActionCommand(questions[count][2]);	//For setting the action	
		
		opt3.setText(questions[count][3]);     // for setting the option 3
		opt3.setActionCommand(questions[count][3]);	//For setting the action	
		
		opt4.setText(questions[count][4]);     // for setting the option 4
		opt4.setActionCommand(questions[count][4]);	//For setting the action	
	
		groupOption.clearSelection();  // for clearing the selected option in next question because next question is automatic selected 
	}
	
	public static void main(String[] args) {
		new Quiz("User");
	}

}
