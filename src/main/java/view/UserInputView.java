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
	private JTextField speciesTextField;
	private JTextField ageTextField;
	
	private JLabel nameLabel;
	
	private JButton submitButton;
	private JButton cancelButton;
	
	
	public UserInputView() {
		setTitle("Add a New Pet Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(200, 50, 96, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		nameLabel = new JLabel("Enter Name: ");
		nameLabel.setBounds(200, 0, 96, 20);
		panel.add(nameLabel);
		
		
		idTextField = new JTextField();
		idTextField.setBounds(200, 80, 96, 20);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		
		
		submitButton = new JButton("Submit New Pet");
		submitButton.setBounds(224, 204, 101, 23);
		panel.add(submitButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(350, 204, 101, 23);
		panel.add(cancelButton);
	}
	
	
	public void addActionListenerToCancelButton (ActionListener listener) {
		cancelButton.addActionListener(listener);
	}
}
