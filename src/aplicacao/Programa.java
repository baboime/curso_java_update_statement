package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args) {
		
		Connection conexao = null;
		PreparedStatement st = null;
		
		try {
			conexao = DB.getConnection();
			
			st = conexao.prepareStatement(
					"UPDATE vendedor "
					+ "SET SalarioBase = SalarioBase + ? "
					+ "WHERE "
					+ "(IdDepartamento = ?)");
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);

			int linhasAtualizadas = st.executeUpdate();
			
			System.out.println("Tabela atualizada, linhas atualizadas: " + linhasAtualizadas);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
