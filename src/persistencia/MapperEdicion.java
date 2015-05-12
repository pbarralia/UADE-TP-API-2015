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
		try
		{
			Edicion a = (Edicion)o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			String script = "INSERT INTO [UADE-TP-API-2015].dbo.Ediciones (TituloTapa, Precio, FechaSalida, Borrado) values (?,?,?,?) ";
			PreparedStatement s = con.prepareStatement(script);
			//agregar campos
			s.setString(1,a.getTituloTapa());
			s.setFloat(2, a.getPrecio());
			s.setString(3, a.getFechaSalida());
			s.setBoolean(4, a.isBorrado());
			s.executeQuery();
			script = "SELECT MAX(codigo) FROM [UADE-TP-API-2015].dbo.Ediciones";
			ResultSet result = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			result.next();
			return result.getInt(1);
		}
		catch (Exception e)
		{
			System.out.println();
		}
		return -1;		
	}
	
	public void delete() {
	
	}
	
	public void update(Object o) {
		try
		{
			Edicion a = (Edicion)o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("update A_Interactivas_01.dbo.ediciones " +
					"set tituloTapa = ?, " +
					"set precio = ?, " +
					"set fechaSalida =? " +
					"WHERE codigoEdicion = ?");
			//agregar campos
			s.setString(1, a.getTituloTapa());
			s.setFloat(2,a.getPrecio());
			//JOAQUIN: ¿para que casteo?
			s.setString(3, a.getFechaSalida());
			s.setInt(4, a.getCodigoEdicion());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println();
		}
	}
	
	public void getByCodigo() {
	
	}
	
	public void list() {
	
	}
}
