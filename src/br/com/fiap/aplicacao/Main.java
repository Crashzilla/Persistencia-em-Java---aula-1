package br.com.fiap.aplicacao;

import javax.swing.JOptionPane;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.entity.Clientes;

public class Main {
	
	public static void main (String[] args){
		
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String email = JOptionPane.showInputDialog("Digite o email:");
		
		Clientes cliente = new Clientes();
		cliente.setNome(nome);
		cliente.setEmail(email);
		
		try{
			
			ClientesDao dao = new ClientesDao();
			dao.incluirCliente(cliente);
			JOptionPane.showMessageDialog(null, "Incluido");
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}		
	}
}
