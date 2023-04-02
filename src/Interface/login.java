package src.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	/* Atributos */
	JTextField usernameInput;
	JLabel usernameLabel;
	JButton loginButton;

	// Construtor
	Login() {
		// Config basica
		this.setSize(new Dimension(400, 200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		// Caixa de texto e sua label
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(160, 10, 200, 50);

		usernameInput = new JTextField();
		usernameInput.setBounds(50, 50, 280, 30);

		// Botão de enviar
		loginButton = new JButton("Enter to chat");
		loginButton.setBounds(130, 95, 120, 30);
		loginButton.addActionListener(this);

		// Adiciona à janela principal
		this.add(loginButton);
		this.add(usernameLabel);
		this.add(usernameInput);

		this.setVisible(true);
	}

	// Métodos de interação com o Usuario, interface ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Welcome " + usernameInput.getText(), "Welcome",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public String getUsername() {
		return usernameInput.getText();
	}

	public static void main(String[] args) {
		Login teste = new Login();
	}
}