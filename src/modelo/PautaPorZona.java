package modelo;

import java.util.Vector;

import vista.PautaView;

/*o	Pauta por zona: se prioriza la colocación de ejemplares a
 *  vendedores cuya ubicación coincida con la zona determinada.
 *  */

public class PautaPorZona extends PautaColocacion {
	private String zona;

	public PautaPorZona(boolean activa, int codigo, String zona) {
		super(activa, codigo);
		this.setZona(zona);
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int obtenerCarga(Vendedor vendedor, Vector<Colocacion> col) {
		Vector<ItemColocacion> ic = vendedor.getItemsColocaciones();
		if (zona.compareTo(vendedor.getZona())==0)
			return  ic.elementAt(ic.size()).getColocados();
		return 0;
	}

	public PautaView obtenerVista() {
		PautaView vista = new PautaView();
		vista.setCodigo(this.codigo);
		vista.setActiva(this.activa);
		vista.setZona(this.zona);
		vista.setNombre("Pauta por zona: " + this.zona);
		return vista;
	}

}
