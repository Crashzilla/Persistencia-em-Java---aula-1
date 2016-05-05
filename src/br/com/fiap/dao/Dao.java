package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	private String url = "jdbc:mysql://localhost:3306/vendas";
	
	protected void abrirConexao(){
		Class.forName("com.mysql.jdbc.Driver");
	}
	
}
