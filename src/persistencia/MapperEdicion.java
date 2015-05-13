package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Edicion;

public class MapperEdicion {

	private static MapperEdicion instancia;

	public MapperEdicion() {

	}

	public static MapperEdicion getInstancia() {
		if (instancia == null)
			instancia = new MapperEdicion();
		return instancia;
	}

	public int insert(Object o) {
		try {
			Edicion a = (Edicion) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			String script = "INSERT INTO Ediciones (TituloTapa, Precio, FechaSalida, Borrado) values (?,?,?,?) ";
			PreparedStatement s = con.prepareStatement(script);
			s.setString(1, a.getTituloTapa());
			s.setFloat(2, a.getPrecio());
			s.setString(3, a.getFechaSalida());
			s.setBoolean(4, a.isBorrado());
			s.execute();

			script = "SELECT MAX(codigo) FROM Ediciones";
			s = con.prepareStatement(script);
			ResultSet result = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			result.next();
			return result.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void delete() {

	}

	public void update(Object o) {
		try {
			Edicion a = (Edicion) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("update Ediciones "
					+ "set tituloTapa = ?, " + "set precio = ?, "
					+ "set fechaSalida =? " + "WHERE codigoEdicion = ?");
			// agregar campos
			s.setString(1, a.getTituloTapa());
			s.setFloat(2, a.getPrecio());
			// JOAQUIN: ¿para que casteo?
			s.setString(3, a.getFechaSalida());
			s.setInt(4, a.getCodigoEdicion());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Edicion getByCodigo(Connection c, int codigo) {
		try {
			boolean conexionProvista = false;
			Connection con;

			if (c != null) {
				con = c;
				conexionProvista = true;
			} else {
				con = PoolConnection.getPoolConnection().getConnection();
			}

			PreparedStatement s = c
					.prepareStatement("select * from Ediciones where codigo = ?");

			s.setInt(1, codigo);

			ResultSet result = s.executeQuery();

			result.next();
			Edicion edicion = new Edicion(result.getInt(1),
					result.getString(2), result.getFloat(3),
					result.getString(4),
					result.getInt(5) == Integer.parseInt("1"));

			if (!conexionProvista) {
				PoolConnection.getPoolConnection().realeaseConnection(con);
			}

			return edicion;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void list() {

	}
}