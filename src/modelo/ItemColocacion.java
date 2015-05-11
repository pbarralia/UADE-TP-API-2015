package modelo;

import vista.ItemColocacionView;

public class ItemColocacion {
	private int nroItem;
	private int colocados;
	private int devueltos;
	private Edicion edicion;
	private Publicacion publicacion;
	private Vendedor vendedor;
	private boolean colocado;
	
	public ItemColocacion(int nroColocacion, int colocados, int devueltos, Edicion edicion,
			Publicacion publicacion, Vendedor vendedor) {
		this.nroItem = obtenerUltimoNroItem(nroColocacion) + 1;
		this.colocados = colocados;
		this.devueltos = devueltos;
		this.edicion = edicion;
		this.publicacion = publicacion;
		this.vendedor = vendedor;
		this.colocado = false;
	}
	
	private int obtenerUltimoNroItem(int nroColocacion) {
		// Falta implementar
		return 0;
	}

	public ItemColocacion(int colocados, Edicion edicion,
			Publicacion publicacion, Vendedor vendedor) {
		this.colocados = colocados;
		this.devueltos = 0;
		this.edicion = edicion;
		this.publicacion = publicacion;
		this.vendedor = vendedor;
		this.colocado = false;
	}

		public int getNroItem() {
		return nroItem;
	}

	public void setNroItem(int nroItem) {
		this.nroItem = nroItem;
	}

	public int getColocados() {
		return colocados;
	}
	public void setColocados(int colocados) {
		this.colocados = colocados;
	}
	public int getDevueltos() {
		return devueltos;
	}
	public void setDevueltos(int devueltos) {
		this.devueltos = devueltos;
	}
	public Edicion getEdicion() {
		return edicion;
	}
	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}
	public Publicacion getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public boolean isColocado() {
		return colocado;
	}

	public void setColocado(boolean colocado) {
		this.colocado = colocado;
	}
	
	public ItemColocacionView obtenerVista(){
		ItemColocacionView itemView = new ItemColocacionView( );
		return itemView;
	}
	
	
}
