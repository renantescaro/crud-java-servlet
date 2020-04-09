package dao;
import java.sql.*;

public class Conexao{
	public Connection cnx;
	
	public void conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			this.cnx = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/livraria_java","root","");

		}catch(Exception e){
			String resultado = e.toString();
			System.out.println("Erro: "+resultado);
		}
	}
	
	public void fecharConexao() throws SQLException{
		this.cnx.close();
	}
}