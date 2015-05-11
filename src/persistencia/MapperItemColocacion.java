package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vista.ItemColocacionView;

public class MapperItemColocacion {

	private static MapperItemColocacion instancia;
	
	public MapperItemColocacion() {

	}
	
	public static MapperItemColocacion getInstancia() {
		if (instancia == null)
			instancia = new MapperItemColocacion();
		return instancia;
	}

	public void update(int codigoColocacion, ItemColocacionView a) {
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("UPDATE [UADE-TP-API-2015].dbo.ItemsColocacion " +
					"set colocado = 1 " +
					"WHERE codigo = ? " +
					"AND nroitem = ?");
			//s.setBoolean(1, true);
			s.setInt(1, codigoColocacion);
			s.setInt(2, a.getNroItem());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println();
		}
	}
}
