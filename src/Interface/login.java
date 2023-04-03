package src.Interface;

/* Imports */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener, KeyListener {
	// Atributos
	private JPanel mainPanel;
	private JLabel usernameLabel;
	private JTextField usernameInput;
	private JLabel hostLabel;
	private JTextField hostInput;
	private JButton loginButton;

	public boolean verifyLogin = false;

	// Construtor
	public Login() {
		// Config basica
		this.setSize(new Dimension(400, 280));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);

		// Painel principal
		mainPanel = new JPanel();
		mainPanel.setSize(new Dimension(400, 280));
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setLayout(null);

		// Label do input de username
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
		usernameLabel.setBounds(50, 10, 200, 50);
		usernameLabel.setForeground(Color.WHITE);

		// Caixa de texto username
		usernameInput = new JTextField();
		usernameInput.setFont(new Font("Arial", Font.BOLD, 13));
		usernameInput.setBounds(50, 50, 280, 30);
		usernameInput.addKeyListener(this); // Escutador de tecla

		// Label do input de host
		hostLabel = new JLabel("Host ip");
		hostLabel.setFont(new Font("Arial", Font.BOLD, 15));
		hostLabel.setBounds(50, 80, 200, 50);
		hostLabel.setForeground(Color.WHITE);

		// Caixa de texto username
		hostInput = new JTextField();
		hostInput.setFont(new Font("Arial", Font.BOLD, 13));
		hostInput.setBounds(50, 120, 280, 30);
		hostInput.addKeyListener(this); // Escutador de tecla
		hostInput.setText("127.0.0.1");

		// Botão de enviar
		loginButton = new JButton("Enter to chat");
		loginButton.setFont(new Font("Arial", Font.BOLD, 15));
		loginButton.setBounds(118, 180, 140, 30);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.GRAY);
		loginButton.addKeyListener(this); // Escutador de tecla
		loginButton.addActionListener(this); // Escutador de click

		mainPanel.add(usernameLabel);
		mainPanel.add(usernameInput);
		mainPanel.add(hostLabel);
		mainPanel.add(hostInput);
		mainPanel.add(loginButton);

		// Adiciona tudo à janela principal e a torna visivel
		this.add(mainPanel);
		this.setVisible(true);
	}

	// Getters dos inputs
	public String getUsername() {
		return usernameInput.getText();
	}

	public String getHost() {
		return hostInput.getText();
	}

	// Método executado quando o ActionListener identifica uma ação
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == loginButton) {
			JOptionPane.showMessageDialog(this, "Welcome " + usernameInput.getText(), "Welcome",
					JOptionPane.INFORMATION_MESSAGE);
			this.verifyLogin = true;
			this.setVisible(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Não precisa da implementação
	}

	// Método executado quando o KeyListener identifica uma key
	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			// Se aperta o botão, acaba o login
			if (event.getSource() == loginButton) {
				JOptionPane.showMessageDialog(this, "Welcome " + usernameInput.getText(), "Welcome",
						JOptionPane.INFORMATION_MESSAGE);
				this.verifyLogin = true;
				this.setVisible(false);
			}
			// Se apertar enter no usernameInput pula para o hostInput
			if (event.getSource() == usernameInput) {
				hostInput.requestFocus(true);
			}
			// Se apertar enter no hostInput pula para o botão
			if (event.getSource() == hostInput) {
				loginButton.requestFocus(true);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Não precisa da implementação
	}
}