package aula12.entradadedadosswing;

import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("Entre com o seu nome: ");		
		JOptionPane.showMessageDialog(null, String.format("Nome: %s", name));

	}

}
