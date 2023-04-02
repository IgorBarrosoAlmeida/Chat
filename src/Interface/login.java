package src.Interface;

import javax.swing.JOptionPane;

public class Login {

	public static void main(String[] args) {

		String nomeUsuario = JOptionPane.showInputDialog("Digite seu nome: ");
		
		JOptionPane.showMessageDialog(null, "Nome Usuario: "+nomeUsuario,"Nome eh:",JOptionPane.INFORMATION_MESSAGE);

	}
}