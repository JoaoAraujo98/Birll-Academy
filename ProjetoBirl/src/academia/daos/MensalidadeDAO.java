package academia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Generated;

import academia.config.*;

public class MensalidadeDAO {

	private Connection connection;

	public MensalidadeDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Mensalidade mensalidade) {

		String sql = "insert into mensalidades (idcliente, valor, datapagamento, datainicio, datafim) " + "values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, mensalidade.getIdcliente());
			stmt.setDouble(2, mensalidade.getValor());
			stmt.setDate(3, new java.sql.Date(mensalidade.getDatapagamento().getTimeInMillis()));
			stmt.setDate(4, new java.sql.Date(mensalidade.getDatainicio().getTimeInMillis()));
			stmt.setDate(5, new java.sql.Date(mensalidade.getDatafim().getTimeInMillis()));
			

			

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Mensalidade> getLista(long idcliente) {
		List<Mensalidade> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from mensalidades where idcliente = "+ idcliente+";");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto 
				Mensalidade m = new Mensalidade();
				m.setCodigo(rs.getLong("codigo"));
				m.setIdcliente(rs.getLong("idcliente"));
				m.setValor(rs.getDouble("valor"));
				
				

				// montando a data através do Calendar
				Calendar datapagamento = Calendar.getInstance();
				Calendar datainicio = Calendar.getInstance();
				Calendar datafim = Calendar.getInstance();
				
				datapagamento.setTime(rs.getDate("datapagamento"));
				datainicio.setTime(rs.getDate("datainicio"));
				datafim.setTime(rs.getDate("datafim"));
				
				m.setDatapagamento(datapagamento);
				m.setDatainicio(datainicio);
				m.setDatafim(datafim);
				
				// adicionando o objeto à lista
				result.add(m);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Mensalidade> getFluxo(String datainicioo, String datafimm) {
		List<Mensalidade> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM mensalidades WHERE datapagamento BETWEEN ('"+datainicioo+"')  AND  ('"+datafimm+"');");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto 
				Mensalidade m = new Mensalidade();
				m.setCodigo(rs.getLong("codigo"));
				m.setIdcliente(rs.getLong("idcliente"));
				m.setValor(rs.getDouble("valor"));
				
				

				// montando a data através do Calendar
				Calendar datapagamento = Calendar.getInstance();
				Calendar datainicio = Calendar.getInstance();
				Calendar datafim = Calendar.getInstance();
				
				datapagamento.setTime(rs.getDate("datapagamento"));
				datainicio.setTime(rs.getDate("datainicio"));
				datafim.setTime(rs.getDate("datafim"));
				
				m.setDatapagamento(datapagamento);
				m.setDatainicio(datainicio);
				m.setDatafim(datafim);
				
				// adicionando o objeto à lista
				result.add(m);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}
