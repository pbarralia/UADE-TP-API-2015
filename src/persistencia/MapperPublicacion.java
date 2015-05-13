package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class MapperPublicacion {
	
	private static MapperPublicacion instancia;
	
	public MapperPublicacion() {
		
	}
	
	public static MapperPublicacion getInstancia() {
		if (instancia == null)
			instancia = new MapperPublicacion();
		return instancia;
	}
	
	public void getByCode() {

	}

	public void list() {

	}
	
	public void agregarRelacionEdicion(int codigoPublicacion, int codigoEdicion) {
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			String script = "INSERT INTO [UADE-TP-API-2015].dbo.PublicacionEdicion (Publicacion, Edicion) values (?,?) ";
			PreparedStatement s = con.prepareStatement(script);
			s.setInt(1, codigoPublicacion);
			s.setInt(2, codigoEdicion);
			s.executeQuery();
		}
		catch (Exception e)
		{
			System.out.println();
		}
	}
}
