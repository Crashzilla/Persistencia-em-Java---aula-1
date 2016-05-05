package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Pedidos;

public class PedidosDao extends Dao {

	public void incluirPedido (Pedidos pedido) throws Exception{
		try{
			abrirConexao();
			String sql = "INSERT INTO PEDIDOS (IDCLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, pedido.getIdCliente());
			stmt.setDate(2, new java.sql.Date(pedido.getData().getTime()));
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
			stmt.executeUpdate();
			
		} catch (Exception e){
			
		}finally {
			fecharConexao();
		}
	}
	public List<Pedidos> listarPedidos(int idCliente) throws Exception{
		
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		
		try{
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM PEDIDOS WHERE IDCLIENTE=?");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while(rs.next()){
				Pedidos p = new Pedidos();
				p.setId(rs.getInt("ID"));
				p.setIdCliente(rs.getInt("IDCLIENTE"));
				p.setData(rs.getDate("DATA"));
				p.setDescricao(rs.getString("DESCRICAO"));
				p.setValor(rs.getDouble("VALOR"));
				
				pedidos.add(p);
			}
		} catch (Exception e){
			
		}finally {
			fecharConexao();
		}
		return pedidos;
	}
}
