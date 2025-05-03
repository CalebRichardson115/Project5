package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class UserInputView extends JFrame {
	private JPanel panel;
	private JTextField nameTextField;
	private JTextField idTextField;
	private JTextField typeTextField;
	private JButton addPetButton;
	
	
	public UserInputView() {
		setTitle("Actions Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
	}
}
