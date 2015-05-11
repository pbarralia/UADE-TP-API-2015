package vista;

import java.util.Vector;

public class VendedorView {
	private int nroVendedor;
	private String direccion;
	private String zona;
	private int tipo;
	private Vector<ItemColocacionView> itemsColocaciones;
	
	public VendedorView(int nroVendedor){
		this.nroVendedor = nroVendedor;
		itemsColocaciones = new Vector<ItemColocacionView>();
	}
	
	public VendedorView(int nroVendedor, String direccion, String zona, int tipo) {
		this.nroVendedor = nroVendedor;
		this.direccion = direccion;
		this.zona = zona;
		this.tipo = tipo;
		itemsColocaciones = new Vector<ItemColocacionView>();
	}

	public int getNroVendedor() {
		return nroVendedor;
	}

	public void setNroVendedor(int nroVendedor) {
		this.nroVendedor = nroVendedor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Vector<ItemColocacionView> getItemsColocaciones() {
		return itemsColocaciones;
	}

	public void setItemsColocaciones() {
		itemsColocaciones = new Vector<ItemColocacionView>();
	}

	public void agregarItem (ItemColocacionView item){
		itemsColocaciones.add(item);
	}
}