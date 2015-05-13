package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import modelo.Vendedor;

public class MapperVendedor {
	private static MapperVendedor instancia;

	public static MapperVendedor getInstancia() {
		if (instancia == null) {
			instancia = new MapperVendedor();
		}
		return instancia;
	}

	public Vector<Vendedor> selectAll() {
		try {
			Vector<Vendedor> vendedores = new Vector<Vendedor>();

			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con
					.prepareStatement("Select * from Vendedores");

			ResultSet result = s.executeQuery();

			while (result.next()) {
				Vendedor vend = new Vendedor(result.getInt(1),
						result.getString(2), result.getString(3),
						result.getInt(4));

				vendedores.add(vend);
			}

			return vendedores;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
