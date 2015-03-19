package FootballDashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class DashboardFrame {

	private JFrame Dashboard;
	private JTextField input;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFrame window = new DashboardFrame();
					window.Dashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DashboardFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		DashboardRecord record = new DashboardRecord();
		
		Dashboard = new JFrame();
		Dashboard.setTitle("Football Scoring Dashboard");
		Dashboard.setResizable(false);
		Dashboard.setBounds(300, 300, 700, 350);
		Dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dashboard.getContentPane().setLayout(null);
		
		JTextPane Screen = new JTextPane();
		Screen.setFont(new Font("Times New Roman", Font.BOLD, 33));
		Screen.setBackground(new Color(100, 149, 237));
		Screen.setForeground(new Color(220, 20, 60));
		Screen.setEditable(false);
		Screen.setBounds(50, 35, 600, 150);
		
		StyledDocument doc = Screen.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		Screen.setText("Welcome! The game is not started yet!");
		
		// TextField to input command
		input = new JTextField();
		input.setBounds(100, 225, 337, 37);
		Dashboard.getContentPane().add(input);
		input.setColumns(10);
		
		JButton SUBMIT = new JButton("Submit");
		SUBMIT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		SUBMIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Screen.setText(record.run(input.getText()));
				input.setText("");
			}
			
		});
		SUBMIT.setBounds(500, 228, 111, 30);
		Dashboard.getContentPane().add(SUBMIT);
		
		Dashboard.getContentPane().add(Screen);
		
	}
}
