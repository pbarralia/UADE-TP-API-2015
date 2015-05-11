package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.PautaAgotados;
import modelo.PautaColocacion;
import modelo.PautaExcesoDevolucion;
import modelo.PautaPorZona;

public class MapperPauta {
	private static MapperPauta instancia;

	public static MapperPauta getInstancia() {
		if (instancia == null)
			instancia = new MapperPauta();
		return instancia;
	}

	public void update(Object o) {
		try {
			PautaColocacion p = (PautaColocacion) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			String script = "UPDATE Pautas SET activa = ? WHERE codigo = ?";
			PreparedStatement s = con.prepareStatement(script);
			int activa = 0;

			activa = p.estasActiva() ? 1 : 0;

			s.setInt(1, activa);
			s.setInt(2, p.getCodigo());

			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector<PautaColocacion> selectAll() {
		try {
			Vector<PautaColocacion> pautas = new Vector<PautaColocacion>();
			Connection c = PoolConnection.getPoolConnection().getConnection();
			Statement s = c.createStatement();
			ResultSet result = s.executeQuery("Select * from Pautas");
			while (result.next()) {
				int codigo = result.getInt(1);
				boolean activa = result.getInt(2) == Integer.parseInt("1");
				int cantUltimasEdiciones = result.getInt(3);
				String zona = result.getString(4);
				PautaColocacion pauta;

				if (cantUltimasEdiciones != -1) {
					pauta = new PautaAgotados(activa, codigo,
							cantUltimasEdiciones);
				} else if (!zona.trim().isEmpty()) {
					pauta = new PautaPorZona(activa, codigo, zona);
				} else {
					pauta = new PautaExcesoDevolucion(activa, codigo);
				}
				pautas.add(pauta);
			}
			PoolConnection.getPoolConnection().realeaseConnection(c);
			return pautas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}