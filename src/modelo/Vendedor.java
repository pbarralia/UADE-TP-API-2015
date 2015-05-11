package modelo;

import java.util.Date;
import java.util.Vector;

import vista.EdicionView;
import vista.ItemColocacionView;
import vista.VendedorView;

public class Vendedor {
	private int nroVendedor;
	private String direccion;
	private String zona;
	private int tipo;
	private Vector<ItemColocacion> itemsColocaciones;
	
	public Vendedor(int nroVendedor, String direccion, String zona, int tipo) {
		this.nroVendedor = nroVendedor;
		this.direccion = direccion;
		this.zona = zona;
		this.tipo = tipo;
		itemsColocaciones = new Vector<ItemColocacion>();
	}

	public void addItems(ItemColocacion item){
		itemsColocaciones.add(item);
	}
	
	public int getNroVendedor() {
		return nroVendedor;
		//prueba
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
	
	public Vector<ItemColocacion> getItemsColocaciones() {
		return itemsColocaciones;
	}

	public void setItemsColocaciones(Vector<ItemColocacion> itemsColocaciones) {
		this.itemsColocaciones = itemsColocaciones;
	}
	
	public VendedorView dameResumen (Date fechaSalida){
		VendedorView v = new VendedorView(nroVendedor);
		for (ItemColocacion i: itemsColocaciones)
			if (i.getEdicion().getFechaSalida().equals(fechaSalida) && !i.isColocado()){
				EdicionView e         = new EdicionView(i.getEdicion().getTituloTapa());
				ItemColocacionView iv = new ItemColocacionView(i.getNroItem(), i.getColocados(), e);
				v.agregarItem(iv);
			}
		return v;
	}
	
	public VendedorView realizarColocacion(int codigoEdicion, String fechaSalida) {
		VendedorView v = new VendedorView( nroVendedor,  direccion,  zona,  tipo);
		for (ItemColocacion i: itemsColocaciones)
			if (i.getEdicion().getFechaSalida().equals(fechaSalida)){
				v.agregarItem(i.obtenerVista());
			}
		return v; 
	}
}
