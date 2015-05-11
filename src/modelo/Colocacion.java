package modelo;

import java.util.Vector;

public class Colocacion {
	private int codigoColocacion;
	private Vector<ItemColocacion> items;
	private String fecha;
	
	public Colocacion(Vector<ItemColocacion> items, String fecha) {
		codigoColocacion = obtenerUltimoCodigo() + 1;
		this.items = items;
		this.fecha = fecha;
	}
	
	private int obtenerUltimoCodigo() {
		// Falta implementar
		return 0;
	}

	public int getCodigoColocacion() {
		return codigoColocacion;
	}
	public void setCodigoColocacion(int codigoColocacion) {
		this.codigoColocacion = codigoColocacion;
	}
	public Vector<ItemColocacion> getItems() {
		return items;
	}
	public void setItems(Vector<ItemColocacion> items) {
		this.items = items;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
