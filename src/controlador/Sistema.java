package controlador;

import java.util.Date;
import java.util.Vector;

import modelo.Colocacion;
import modelo.Edicion;
import modelo.ItemColocacion;
import modelo.PautaColocacion;
import modelo.Publicacion;
import modelo.Vendedor;
import persistencia.MapperItemColocacion;
import persistencia.MapperPauta;
import persistencia.MapperPublicacion;
import persistencia.MapperVendedor;
import vista.EdicionView;
import vista.ItemColocacionView;
import vista.PautaView;
import vista.VendedorView;

public class Sistema {

	private Vector<Vendedor> vendedores;
	private Vector<Publicacion> publicaciones;
	private Vector<PautaColocacion> pautasColocacion;
	private Vector<Colocacion> colocaciones;
	private static Sistema instancia;
	private Publicacion publicacionActual;
	private Edicion edicionActual;

	private Sistema() {
		vendedores = MapperVendedor.getInstancia().selectAll();
		publicaciones = MapperPublicacion.getInstancia().selectAll();
		pautasColocacion = MapperPauta.getInstancia().selectAll();
		colocaciones = new Vector<Colocacion>();

	}

	public static Sistema getControlador() {
		if (instancia == null)
			instancia = new Sistema();
		return instancia;
	}

	public void setPublicacionActual(Publicacion publicacionActual) {
		this.publicacionActual = publicacionActual;
	}

	public void setEdicionActual(Edicion edicionActual) {
		this.edicionActual = edicionActual;
	}

	public Publicacion getPublicacionActual() {
		return publicacionActual;
	}

	public Edicion getEdicionActual() {
		return edicionActual;
	}

	
	public Vector<ItemColocacionView> mostrarColocacion() {

		Vector<ItemColocacionView> itemsColocacionView = new Vector<ItemColocacionView>(); // Almaceno items

		for (int i = 0; i < vendedores.size(); i++) {
			
			int colocados = obtenerPautaActiva().obtenerCarga(vendedores.elementAt(i),	colocaciones); // verifico la pauta
			ItemColocacion item = new ItemColocacion(colocados, edicionActual, publicacionActual, vendedores.elementAt(i));
			itemsColocacionView.add(item.obtenerVista());
		}
		return itemsColocacionView;
	}
	
	
	public void realizarColocacion() {


		Vector<ItemColocacion> itemsColocacion = new Vector<ItemColocacion>(); // Almaceno items
		PautaColocacion pauta = obtenerPautaActiva();

		for (int i = 0; i < vendedores.size(); i++) {
			vendedores.elementAt(i).realizarColocacion(edicionActual.getCodigoEdicion(), edicionActual.getFechaSalida());
			int colocados = pauta.obtenerCarga(vendedores.elementAt(i),	colocaciones); // verifico la pauta
			ItemColocacion item = new ItemColocacion(colocados, edicionActual, publicacionActual, vendedores.elementAt(i));
			vendedores.elementAt(i).addItems(item);
			itemsColocacion.add(item);
		}

		Colocacion c = new Colocacion(itemsColocacion, edicionActual.getFechaSalida()); 
		// Por cada	// edicion// y// fecha// voy a// tener// una// colocacion// con// todos// los// items// en// estado// false
		colocaciones.add(c);
	}


	public void agregarEdicion(int codigoPublicacion, String tituloEdicion,
			float precio, String fechaSalida) {
		try {
			buscarPublicacion(codigoPublicacion).agregarEdicion(tituloEdicion,
					precio, fechaSalida);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void borrarEdicion(int codPub, int codEd) {

		this.setPublicacionActual(this.buscarPublicacion(codPub));
		this.validarEdicion(codPub, codEd);
	}

	public void bajaLogica() {
		this.publicacionActual.bajaLogica();
		this.setEdicionActual(null);
		this.setPublicacionActual(null);
	}

	private PautaColocacion obtenerPautaActiva() {
		for (int i = 0; i < pautasColocacion.size(); i++) {
			if (pautasColocacion.elementAt(i).estasActiva())
				return pautasColocacion.elementAt(i);
		}
		return null;
	}

	public Vector<PautaView> obtenerPautas() {
		Vector<PautaView> vistaPautas = new Vector<PautaView>();
		for (int i = 0; i < pautasColocacion.size(); i++) {
			vistaPautas.add(pautasColocacion.elementAt(i).obtenerVista());
		}
		return vistaPautas;
	}

	public void activarPauta(int codigo) {
		PautaColocacion p = buscarPauta(codigo);
		if (p != null) {
			p.setActiva(true);
			MapperPauta.getInstancia().update(p);
		}
	}

	private PautaColocacion buscarPauta(int codigo) {
		for (int i = 0; i < pautasColocacion.size(); i++) {
			if (pautasColocacion.elementAt(i).sosLaPauta(codigo)) {
				return pautasColocacion.elementAt(i);
			}
		}
		return null;
	}

	private Vector<VendedorView> emitirResumen(Date fechaSalida) {
		Vector<VendedorView> resumen = new Vector<VendedorView>();
		VendedorView resumenIndividual;
		for (Vendedor v : vendedores) {
			resumenIndividual = v.dameResumen(fechaSalida);
			resumen.add(resumenIndividual);
		}
		return resumen;
	}

	public void updateItemColocacion(int codigoColocacion,
			ItemColocacionView item) {
		MapperItemColocacion mapper = new MapperItemColocacion();
		mapper.update(codigoColocacion, item);
	}

	public PautaView buscarPautaActiva() {
		for (int i = 0; i < pautasColocacion.size(); i++) {
			if (pautasColocacion.elementAt(i).estasActiva()) {
				return pautasColocacion.elementAt(i).obtenerVista();
			}
		}
		return null;
	}

	public void desactivarPauta(int codigo) {
		PautaColocacion p = buscarPauta(codigo);
		if (p != null) {
			p.setActiva(false);
			MapperPauta.getInstancia().update(p);
		}
	}

	public EdicionView validarEdicion(int codPub, int codEd) {
		EdicionView ev = null;
		Publicacion p = buscarPublicacion(codPub);
		if (p != null) {
			Edicion ed = p.tenesEdicion(codEd);
			if (ed != null) {
				ev = p.getEdicionView(ed);
				setEdicionActual(ed);
				setPublicacionActual(p);
			}
		}
		return ev;
	}

	private Publicacion buscarPublicacion(int codPub) {
		for (int i = 0; i < publicaciones.size(); i++) {
			if (publicaciones.elementAt(i).getCodigo() == codPub) {
				return publicaciones.elementAt(i);
			}
		}
		return null;
	}

	public void modificarDatosEdicion(Edicion edicionActual, String tituloTapa,
			float precio, String fechaSalida) {
		publicacionActual.modificarDatosEdicion(edicionActual, tituloTapa,
				precio, fechaSalida);
		setPublicacionActual(null);
		setEdicionActual(null);
	}

	public void cancelarModificarEdicion() {
		setPublicacionActual(null);
		setEdicionActual(null);
	}
}
