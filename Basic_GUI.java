/*
Khoo Zheng Jie, Anthony

I declare that all the following work is mine and have not passed my program to anyone.

Sir, I did not know that I dont have to submit image for zip file. Therefore I resubmit the file without image.
*/

import java.awt.FlowLayout; // specifies how components are arranged
import java.awt.Font;
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.JOptionPane;
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Basic_GUI extends JFrame {

	public static void main(String[] args) {
		
	}
	
	private final JLabel name;
	private final JLabel dob;
	private final JLabel email;
	private final JLabel comment;
	private final JLabel image;
	
	private final JTextField nameFill;
	private final JTextField dobFill;
	private final JTextField emailFill;
	private final JTextField cFill1;
	private final JTextField cFill2;
	
	private JFrame frame;

	
	public Anthony_6354786_Lab_3() {
		
			//message title
			super("Box Title");
			getContentPane().setLayout(new FlowLayout());
			
			//JLabel name & bold
			name = new JLabel("Name");
			name.setFont(name.getFont().deriveFont(Font.BOLD, 10f));
			
			//JTextField name fill
			nameFill = new JTextField("Anthony Khoo", 30);
			nameFill.setEditable(false);
			
		
			//JLabel dob & bold
			dob = new JLabel("Date of birth");
			dob.setFont(dob.getFont().deriveFont(Font.BOLD, 10f));
		
			//JTextField dob fill
			dobFill = new JTextField("20 April 1996", 30);
			dobFill.setEditable(false);
			
			
			//JLabel email & bold
			email = new JLabel("Email");
			email.setFont(email.getFont().deriveFont(Font.BOLD, 10f));
			
			//JTextField email fill
			emailFill = new JTextField("zjakhoo001@mymail.sim.edu.sg", 30);
			emailFill.setEditable(false);
		
			
			Icon cat = new ImageIcon(getClass().getResource("cat1.jpg"));
			image = new JLabel(cat);
			image.setToolTipText("Image");	
			
			
			//JLabel comment & bold
			comment = new JLabel("My comments on GUI");
			comment.setFont(comment.getFont().deriveFont(Font.BOLD, 10f));
			
			
			//JTextField comment fill 1"Summary of important things that we learnt at the end", 35
			cFill1 = new JTextField("Simple interface", 35);
			
			//JTextField comment fill 1, 35
			cFill2 = new JTextField("Effective GUI communicates clear ideas and message", 35);
			
			//add in all 
			getContentPane().add(name);
			getContentPane().add(nameFill);
			getContentPane().add(dob);
			getContentPane().add(dobFill);
			getContentPane().add(email);	
			getContentPane().add(emailFill);
			getContentPane().add(image);
			getContentPane().add(comment);
			getContentPane().add(cFill1);
			getContentPane().add(cFill2);
			
			//   
			TextFieldHandler handler = new TextFieldHandler();
			cFill1.addActionListener(handler);
			cFill2.addActionListener(handler);
			
			setVisible(true);
			setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			setSize (350, 400);
		}		
	
	private class TextFieldHandler implements ActionListener {
	
		public void actionPerformed (ActionEvent event) {
			
			String string1 = "";
			String string2 = "";
			
			//if user pressed Enter in JTextField cFill1
			if(event.getSource() == cFill1)
				string1 = String.format ("1.%s", event.getActionCommand());

			//if user pressed Enter in JTextField cFill2
			else if(event.getSource() == cFill2)
				string2 = String.format ("2.%s", event.getActionCommand());
		
		//display JTextField content
		final JButton btn = new JButton ("OK");	
		
		JOptionPane.showMessageDialog(null,
				"Summary of Changes\n1." + string1 + "\n2." + string2 ,
				"Shows Changes", 
				JOptionPane.WARNING_MESSAGE & JOptionPane.OK_CANCEL_OPTION);
		
		}
	}
}
