package modelo;

import java.util.Vector;

import vista.PautaView;

public class PautaExcesoDevolucion extends PautaColocacion {

	public PautaExcesoDevolucion(boolean activa, int codigo) {
		super(activa, codigo);
	}

	public int obtenerCarga(Vendedor ven, Vector<Colocacion> col) {
		return 0;
	}

	public PautaView obtenerVista() {
		PautaView vista = new PautaView();
		vista.setCodigo(this.codigo);
		vista.setActiva(this.activa);
		vista.setNombre("Pauta por exceso de devolucion");
		return vista;
	}

}