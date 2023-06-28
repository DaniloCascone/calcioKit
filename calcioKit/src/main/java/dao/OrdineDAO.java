package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Ordine;

public class OrdineDAO {
	private DataSource dataSource;

	public OrdineDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// Delete Ordine
	public void deleteOrdine(int ID_ordine) throws SQLException {
		String query = "DELETE FROM Ordine WHERE ID_ordine = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, ID_ordine);
			statement.executeUpdate();
		}
	}

	private Ordine extractOrdineFromResultSet(ResultSet resultSet) throws SQLException {
		Ordine ordine = new Ordine();
		ordine.setIdOrdine(resultSet.getInt("ID_ordine"));
		ordine.setDataInserimento(resultSet.getDate("data_inserimento"));
		ordine.setPrezzoVendita(resultSet.getBigDecimal("prezzo_vendita"));
		ordine.setIvaCout(resultSet.getDouble("iva_cout"));
		ordine.setStatoOrdine(resultSet.getString("stato_ordine"));
		ordine.setUsernameCliente(resultSet.getString("username_cli"));
		ordine.setEmailCliente(resultSet.getString("email_cli"));
		return ordine;
	}

	public Ordine getOrdineByID(int ID_ordine) throws SQLException {
		String query = "SELECT * FROM Ordine WHERE ID_ordine = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, ID_ordine);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return extractOrdineFromResultSet(resultSet);
				}
			}
		}
		return null;
	}

	// Get all Ordine for a specific user
	public List<Ordine> getOrdineForUser(String username, String email) throws SQLException {
		String query = "SELECT * FROM Ordine WHERE username_cli = ? AND email_cli = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, email);
			try (ResultSet resultSet = statement.executeQuery()) {
				List<Ordine> ordini = new ArrayList<>();
				while (resultSet.next()) {
					Ordine ordine = new Ordine();
					ordine.setIdOrdine(resultSet.getInt("ID_ordine"));
					ordine.setUsernameCliente(resultSet.getString("username_cli"));
					ordine.setEmailCliente(resultSet.getString("email_cli"));
					ordine.setPrezzoVendita(resultSet.getBigDecimal("prezzo_vendita"));
					ordine.setDataInserimento(resultSet.getDate("data_inserimento"));
					ordine.setIvaCout(resultSet.getDouble("iva_cout"));
					ordine.setStatoOrdine(resultSet.getString("stato_ordine"));
					ordini.add(ordine);
				}
				return ordini;
			}
		}
	}

	// Save Ordine
	public int saveOrdine(Ordine ordine) throws SQLException {
		int generatedOrdineId = 0;
		String sql = "INSERT INTO Ordine (ID_ordine , username_cli, email_cli, data_inserimento, prezzo_vendita,iva_cout, stato_ordine) VALUES (?, ? , ?, ?, ?, ? , ?)";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, ordine.getIdOrdine());
			stmt.setString(2, ordine.getUsernameCliente());
			stmt.setString(3, ordine.getEmailCliente());
			stmt.setDate(4, ordine.getDataInserimento());
			stmt.setBigDecimal(5, ordine.getPrezzoVendita());
			stmt.setDouble(6, ordine.getIvaCout());
			stmt.setString(7, ordine.getStatoOrdine());

			int affectedRows = stmt.executeUpdate();
			if (affectedRows > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					generatedOrdineId = generatedKeys.getInt(1); // Retrieve the generated ordine_id
				}
			}
		}
		return generatedOrdineId;
	}

	// Update Ordine
	public void updateOrdine(Ordine ordine) throws SQLException {
		String query = "UPDATE Ordine SET username_cli = ?, email_cli = ?, data_inserimento = ?, prezzo_vendita = ? WHERE ID_ordine = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, ordine.getUsernameCliente());
			statement.setString(2, ordine.getEmailCliente());
			statement.setDate(3, ordine.getDataInserimento());
			statement.setBigDecimal(4, ordine.getPrezzoVendita());
			statement.setInt(5, ordine.getIdOrdine());

			statement.executeUpdate();
		}
	}
}
