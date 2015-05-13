package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.Diario;
import modelo.Edicion;
import modelo.Publicacion;
import modelo.Revista;

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
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			String script = "INSERT INTO PublicacionEdicion (Publicacion, Edicion) values (?,?) ";
			PreparedStatement s = con.prepareStatement(script);
			s.setInt(1, codigoPublicacion);
			s.setInt(2, codigoEdicion);
			s.execute();
		} catch (Exception e) {
			System.out.println();
		}
	}

	public Vector<Publicacion> selectAll() {
		try {
			Vector<Publicacion> publicaciones = new Vector<Publicacion>();
			Connection c = PoolConnection.getPoolConnection().getConnection();
			Statement s = c.createStatement();
			ResultSet result = s.executeQuery("Select * from Publicaciones");
			while (result.next()) {
				int codigo = result.getInt(1);
				String titulo = result.getString(2);
				String tipo = result.getString(3);
				String editor = result.getString(4);
				String tema = result.getString(5);
				String subtema = result.getString(6);
				String publico = result.getString(7);
				int periodicidad = result.getInt(8);
				String idioma = result.getString(9);
				String paisDeOrigen = result.getString(10);

				Publicacion publicacion;

				if (tipo.equals("Diario")) {
					publicacion = new Diario(codigo, titulo, editor, tema,
							subtema, publico, periodicidad, idioma,
							paisDeOrigen, new Vector<Edicion>());
				} else {
					publicacion = new Revista(codigo, titulo, editor, tema,
							subtema, publico, periodicidad, idioma,
							paisDeOrigen, new Vector<Edicion>());
				}

				publicaciones.add(publicacion);
			}
			PoolConnection.getPoolConnection().realeaseConnection(c);
			return publicaciones;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// private Vector<Edicion> selectEdiciones(int codigo, Connection c) {
	// try {
	// Vector<Edicion> ediciones = new Vector<Edicion>();
	// PreparedStatement s = c
	// .prepareStatement("Select * from PublicacionEdicion WHERE Publicacion = ?");
	//
	// s.setInt(1, codigo);
	//
	// ResultSet result = s.executeQuery();
	// while (result.next()) {
	// int codEdicion = result.getInt(2);
	//
	// ediciones.add(MapperEdicion.getInstancia().getByCodigo(c,
	// codEdicion));
	// }
	// return ediciones;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
}