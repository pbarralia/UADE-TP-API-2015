package modelo;

import java.util.Vector;

import vista.PautaView;
/*o	Pauta exceso devolución:
 *  si el vendedor devolvió más ejemplares de los que cargo se lo penaliza
 *   disminuyendo su colocación actual en base a una tabla de exceso.
 *   */


public class PautaExcesoDevolucion extends PautaColocacion {

	public PautaExcesoDevolucion(boolean activa, int codigo) {
		super(activa, codigo);
	}


	
	public int obtenerCarga(Vendedor vendedor, Vector<Colocacion> col) {
		int colocados = 0;
		int devueltos = 0;
		Vector<ItemColocacion> ic = vendedor.getItemsColocaciones();
		for (int i = ic.size(); (i + 3)  > ic.size() ; i --){   //ultimas tres ediciones
			colocados = ic.elementAt(i).getColocados() + colocados;
			devueltos = ic.elementAt(i).getDevueltos() + devueltos;
		}
		return  ic.elementAt(ic.size()).getColocados() + tablaDevolucion(devueltos - colocados);
	}
	
	
	
	private int tablaDevolucion(int exceso){
		if (exceso >10)
			return -6;
		else if (exceso >8)
			return -5;
		else if (exceso > 6)
			return -4;
		else if (exceso >4)
			return -3;
		else if (exceso >2)
			return -2;
		else if (exceso > 1)
			return -1;
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
