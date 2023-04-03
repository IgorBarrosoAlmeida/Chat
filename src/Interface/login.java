package src.Interface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	/* Atributos */
	private JPanel mainPanel;
	private JTextField usernameInput;
	private JLabel usernameLabel;
	private JButton loginButton;
	public boolean verifyLogin = false;

	// Construtor
	public Login() {
		// Config basica
		this.setSize(new Dimension(400, 200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);

		// Painel principal
		mainPanel = new JPanel();
		mainPanel.setSize(new Dimension(400, 200));
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setLayout(null);

		// Label do input de username
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
		usernameLabel.setBounds(154, 10, 200, 50);
		usernameLabel.setForeground(Color.WHITE);

		// Caixa de texto
		usernameInput = new JTextField();
		usernameInput.setFont(new Font("Arial", Font.BOLD, 13));
		usernameInput.setBounds(50, 50, 280, 30);

		// Botão de enviar
		loginButton = new JButton("Enter to chat");
		loginButton.setFont(new Font("Arial", Font.BOLD, 15));
		loginButton.setBounds(118, 95, 140, 30);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.GRAY);

		loginButton.addActionListener(this);

		// Adiciona à janela principal
		mainPanel.add(loginButton);
		mainPanel.add(usernameLabel);
		mainPanel.add(usernameInput);

		this.add(mainPanel);
		this.setVisible(true);
	}

	// Métodos de interação com o Usuario, interface ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Welcome " + usernameInput.getText(), "Welcome",
				JOptionPane.INFORMATION_MESSAGE);
		this.verifyLogin = true;
		this.setVisible(false);
	}

	public String getUsername() {
		return usernameInput.getText();
	}
}