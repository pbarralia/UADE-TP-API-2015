package modelo;

import persistencia.MapperEdicion;
import vista.EdicionView;

public class Edicion {
	private int codigoEdicion;
	private String tituloTapa;
	private float precio;
	private String fechaSalida;
	private boolean borrado;

	public Edicion(String tituloTapa, float precio, String fechaSalida) {
		this.tituloTapa = tituloTapa;
		this.precio = precio;
		this.fechaSalida = fechaSalida;
		this.borrado = false;

		this.codigoEdicion = MapperEdicion.getInstancia().insert(this);
	}

	public Edicion(int codigo, String tituloTapa, float precio,
			String fechaSalida, boolean borrado) {
		this.tituloTapa = tituloTapa;
		this.precio = precio;
		this.fechaSalida = fechaSalida;
		this.borrado = borrado;
	}

	public int getCodigoEdicion() {
		return codigoEdicion;
	}

	public void setCodigoEdicion(int codigoEdicion) {
		this.codigoEdicion = codigoEdicion;
	}

	public String getTituloTapa() {
		return tituloTapa;
	}

	public void setTituloTapa(String tituloTapa) {
		this.tituloTapa = tituloTapa;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	public boolean sosEdicion(int codigoEdicion2) {
		if (codigoEdicion2 == codigoEdicion)
			return true;
		return false;
	}

	public EdicionView getView() {
		return new EdicionView(codigoEdicion, tituloTapa, precio, fechaSalida);
	}

	public void modificarDatos(String tituloTapa2, float precio2,
			String fechaSalida2) {
		tituloTapa = tituloTapa2;
		precio = precio2;
		fechaSalida = fechaSalida2;

		MapperEdicion.getInstancia().update(this);
	}
}