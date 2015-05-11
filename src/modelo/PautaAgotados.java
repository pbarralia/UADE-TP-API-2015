package modelo;

import java.util.Vector;
import vista.PautaView;

public class PautaAgotados extends PautaColocacion {
	private int cantUltimasEdiciones;

	public PautaAgotados(boolean activa, int codigo, int cantUltimasEdiciones) {
		super(activa, codigo);
		this.cantUltimasEdiciones = cantUltimasEdiciones;
	}

	public int getCantUltimasEdiciones() {
		return cantUltimasEdiciones;
	}

	public void setCantUltimasEdiciones(int cantUltimasEdiciones) {
		this.cantUltimasEdiciones = cantUltimasEdiciones;
	}

	public int obtenerCarga(Vendedor vendedor, Vector<Colocacion> col) {
		int colocados = 0;
		int devueltos = 0;
		Vector<ItemColocacion> ic = vendedor.getItemsColocaciones();
		for (int i = ic.size(); (i + 3)  > ic.size() ; i --){   //ultimas tres ediciones
			colocados = ic.elementAt(i).getColocados() + colocados;
			devueltos = ic.elementAt(i).getDevueltos() + devueltos;
		}
		if (devueltos == 0 && colocados == 1)
			return 3;
		else if (devueltos == 0 && colocados >= 2 && colocados <= 5)
			return 5;
		else if (devueltos == 0 && colocados >= 6 && colocados <= 10)
			return 10;
		return 0;
	}
	
	

	public PautaView obtenerVista() {
		PautaView vista = new PautaView();
		vista.setCodigo(this.codigo);
		vista.setActiva(this.activa);
		vista.setCantUltimasEdiciones(this.cantUltimasEdiciones);
		vista.setNombre("Pauta por agotados: ultimas "
				+ Integer.toString(cantUltimasEdiciones) + " ediciones");
		return vista;
	}
}
