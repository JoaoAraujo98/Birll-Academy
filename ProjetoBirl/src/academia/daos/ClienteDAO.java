package academia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import academia.config.*;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Cliente cliente) {

		String sql = "insert into clientes (nome, cpf, fone, endereco, email, dataNascimento) " + "values (?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getFone());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getEmail());
			

			stmt.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Cliente> getLista() {
		List<Cliente> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setFone(rs.getString("fone"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(data);

				// adicionando o objeto à lista
				result.add(c);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Cliente cliente) {
		String sql = "update clientes set nome=?, cpf=?, fone=?, email=?, endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getFone());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getEndereco());
			stmt.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setLong(7, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from clientes where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cliente getById(Long id) {
		Cliente result = null;
		
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where id = ?;");
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				result = new Cliente();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setFone(rs.getString("fone"));
				result.setCpf(rs.getString("cpf"));
				result.setEmail(rs.getString("email"));
				result.setEndereco(rs.getString("endereco"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(data);

				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

		
	}

}
