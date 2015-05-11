package vista;

public class ItemColocacionView {
	private int nroItem;
	private int colocados;
	private int devueltos;
	private EdicionView edicionView;
	private PublicacionView publicacionView;
	private VendedorView vendedorView;
	private boolean colocado;
	
	
	public ItemColocacionView(){};
	
	public ItemColocacionView(int nroItem, int colocados, EdicionView edicionView) {
		this.nroItem = nroItem;
		this.colocados = colocados;
		this.edicionView = edicionView;
	}
	
	
	public ItemColocacionView(int colocados, int devueltos,	EdicionView edicionView, PublicacionView publicacionView,
			VendedorView vendedorView, boolean colocado) {
		this.colocados = colocados;
		this.devueltos = devueltos;
		this.edicionView = edicionView;
		this.publicacionView = publicacionView;
		this.vendedorView = vendedorView;
		this.colocado = colocado;
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


	public EdicionView getEdicionView() {
		return edicionView;
	}


	public void setEdicionView(EdicionView edicionView) {
		this.edicionView = edicionView;
	}


	public PublicacionView getPublicacionView() {
		return publicacionView;
	}


	public void setPublicacionView(PublicacionView publicacionView) {
		this.publicacionView = publicacionView;
	}


	public VendedorView getVendedorView() {
		return vendedorView;
	}


	public void setVendedorView(VendedorView vendedorView) {
		this.vendedorView = vendedorView;
	}
	
	public boolean isColocado() {
		return colocado;
	}


	public void setColocado(boolean colocado) {
		this.colocado = colocado;
	}

	public int getNroItem() {
		return nroItem;
	}

	public void setNroItem(int nroItem) {
		this.nroItem = nroItem;
	}
}
