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
	private JLabel idLabel;
	private JLabel typeLabel;
	private JLabel speciesLabel;
	private JLabel ageLabel;
	
	private JButton submitButton;
	private JButton cancelButton;
	
	
	public UserInputView() {
		setTitle("Add a New Pet Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		
		
		idTextField = new JTextField();
		idTextField.setBounds(150, 20, 250, 20);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		idLabel = new JLabel("Enter ID: ");
		idLabel.setBounds(50, 20, 100, 20);
		panel.add(idLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(150, 60, 250, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		nameLabel = new JLabel("Enter Name: ");
		nameLabel.setBounds(50, 60, 100, 20);
		panel.add(nameLabel);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(150, 100, 250, 20);
		panel.add(typeTextField);
		typeTextField.setColumns(10);
		
		typeLabel = new JLabel("Enter Type: ");
		typeLabel.setBounds(50, 100, 100, 20);
		panel.add(typeLabel);
		
		speciesTextField = new JTextField();
		speciesTextField.setBounds(150, 140, 250, 20);
		panel.add(speciesTextField);
		speciesTextField.setColumns(10);
		
		speciesLabel = new JLabel("Enter Species: ");
		speciesLabel.setBounds(50, 140, 100, 20);
		panel.add(speciesLabel);
		
		
		ageTextField = new JTextField();
		ageTextField.setBounds(150, 180, 250, 20);
		panel.add(ageTextField);
		ageTextField.setColumns(10);
		
		ageLabel = new JLabel("Enter Age: ");
		ageLabel.setBounds(50, 180, 100, 20);
		panel.add(ageLabel);
		
		
		
		submitButton = new JButton("Submit New Pet");
		submitButton.setBounds(125, 250, 100, 25);
		panel.add(submitButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(275, 250, 100, 25);
		panel.add(cancelButton);
	}
	
	
	public void addActionListenerToCancelButton (ActionListener listener) {
		cancelButton.addActionListener(listener);
	}
	
	public void addActionListenerToSubmitButton (ActionListener listener) {
		submitButton.addActionListener(listener);
	}
	
	public String getName() {
		return nameTextField.getText();
	}
	
	public String getPetType() {
		return typeTextField.getText();
	}
	
	public String getSpecies() {
		return speciesTextField.getText();
	}
	
	public String getId() {
		return idTextField.getText();
	}
	
	public String getAge() {
		return ageTextField.getText();
	}
}
