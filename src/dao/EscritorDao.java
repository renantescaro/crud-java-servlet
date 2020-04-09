package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Escritor;
import entity.Pessoa;
import com.mysql.jdbc.PreparedStatement;

public class EscritorDao{
	
	public List<Escritor> selecionarTudo() throws SQLException{
		
		Conexao conexao = new Conexao();
		PessoaDao pessoaDao = new PessoaDao();
		
		String sql = "SELECT * FROM escritor;";
		
		conexao.conectar();
		PreparedStatement statement = (PreparedStatement) conexao.cnx.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		List<Escritor> escritores = new ArrayList<Escritor>();
		
		while(rs.next()){
			Escritor escritor = new Escritor();
			Pessoa pessoa = pessoaDao.selecionarPorId(rs.getInt("pessoa_id"));
			
			escritor.setId(rs.getInt("id"));
			escritor.setPessoa(pessoa);
			
			escritores.add(escritor);
		}
		
		conexao.fecharConexao();
		
		return escritores;
	}
	
	public Escritor selecionarPorId(int id) throws SQLException{
		
		Conexao conexao = new Conexao();
		Escritor escritor = new Escritor();
		PessoaDao pessoaDao = new PessoaDao();
		
		String sql = "SELECT * FROM escritor WHERE id=?";

		conexao.conectar();
		PreparedStatement statement = (PreparedStatement) conexao.cnx.prepareStatement(sql);
		
		statement.setInt(1, id);
		
		ResultSet rs = statement.executeQuery();
		
		if(rs != null){		
			rs.next();
			
			Pessoa pessoa = pessoaDao.selecionarPorId(rs.getInt("pessoa_id"));
			
			escritor.setId(rs.getInt("id"));
			escritor.setPessoa(pessoa);
		}
		
		conexao.fecharConexao();
		
		return escritor;
	}
	
	public boolean inserir(Escritor escritor) throws SQLException {
		
		Conexao conexao = new Conexao();
		
		String sql = "INSERT INTO escritor(pessoa_id) "+
					 "VALUES(?)";
		
		
		conexao.conectar();
		PreparedStatement statement = (PreparedStatement) conexao.cnx.prepareStatement(sql);
		
		statement.setInt(1, escritor.getPessoa().getId());
		return statement.execute();
	}
	
	public boolean deletarPorId(int id) throws SQLException{
		
		Conexao conexao = new Conexao();
		
		String sql = "DELETE FROM escritor WHERE id=?";

		conexao.conectar();
		PreparedStatement statement = (PreparedStatement) conexao.cnx.prepareStatement(sql);
		
		statement.setInt(1, id);
		
		return statement.execute();
	}
	
	public boolean atualizar(Escritor escritor) throws SQLException{
		
		Conexao conexao = new Conexao();
		String sql = "UPDATE escritor SET pessoa_id=? WHERE id=?";

		conexao.conectar();
		PreparedStatement statement = (PreparedStatement) conexao.cnx.prepareStatement(sql);
		
		statement.setInt(1, escritor.getPessoa().getId());
		statement.setInt(2, escritor.getId());
		
		return statement.execute();
	}
}
