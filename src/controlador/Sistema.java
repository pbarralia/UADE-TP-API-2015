package controlador;


import java.util.Date;
import java.util.Vector;

import persistencia.MapperItemColocacion;
import persistencia.MapperPauta;
import modelo.Colocacion;
import modelo.Edicion;
import modelo.ItemColocacion;
import modelo.PautaColocacion;
import modelo.Publicacion;
import modelo.Vendedor;
import vista.EdicionView;
import vista.ItemColocacionView;
import vista.VendedorView;
import vista.PautaView;

public class Sistema {

	private Vector<Vendedor> vendedores;
	private Vector<Publicacion> publicaciones;
	private Vector<PautaColocacion> pautasColocacion;
	private Vector<Colocacion> colocaciones;
	private static Sistema instancia;
	private Publicacion publicacionActual;
	private Edicion edicionActual;

	private Sistema() {
		vendedores = new Vector<Vendedor>();
		publicaciones = new Vector<Publicacion>();
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

	public void realizarColocacion(int codigoEdicion, String fechaSalida) {
		//Al finalizar la colocaci�n hay que llamar al m�todo "emitirResumen" para que genere la lista.
		//Devuelve una colecci�n de "VendedoresView" que solo tiene el "NroVendedor" y una colecci�n de "ItemColocacion".
		
		Vector<ItemColocacion> itemsColocacion = new Vector<ItemColocacion>()  ; // Almaceno los items colocados
		PautaColocacion pauta = obtenerPautaActiva();
		
		for (int i = 0; i < vendedores.size(); i++) {
			vendedores.elementAt(i).realizarColocacion(codigoEdicion, fechaSalida);
			int colocados = pauta.obtenerCarga(vendedores.elementAt(i), colocaciones);  //verifico la pauta
			ItemColocacion item = crearItem(colocados, codigoEdicion, vendedores.elementAt(i));
			vendedores.elementAt(i).addItems(item); 
			itemsColocacion.add(item);
		}
		
		Colocacion c = new Colocacion(itemsColocacion, fechaSalida); // Por cada edicion y fecha voy a tener una colocacion con todos los items en estado false
		colocaciones.add(c);
	}

	private ItemColocacion crearItem(int colocados, int codigoEdicion,	Vendedor vend) {
		for (int i = 0; i < publicaciones.size(); i++) {
			Edicion edicion = publicaciones.elementAt(i).buscarEdicion(codigoEdicion);
		    if (edicion != null)
		    	return new ItemColocacion(colocados, edicion, publicaciones.elementAt(i), vend);
		}
		return null;
	}
	
	

	public void agregarEdicion(int codigoPublicacion, String tituloEdicion, float precio, String fechaSalida) {
		try {
			publicaciones.elementAt(codigoPublicacion).agregarEdicion(tituloEdicion, precio, fechaSalida);
			
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
	

	
	private Vector <VendedorView> emitirResumen (Date fechaSalida){
		Vector<VendedorView> resumen = new Vector<VendedorView>();
		VendedorView resumenIndividual;
		for (Vendedor v: vendedores){
			resumenIndividual = v.dameResumen(fechaSalida);
			resumen.add(resumenIndividual);
		}
		return resumen;
	}
	
	public void updateItemColocacion(int codigoColocacion, ItemColocacionView item){
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
	
	public EdicionView validarEdicion(int codPub, int codEd){
		EdicionView ev = null;
		Publicacion p = buscarPublicacion(codPub);
		if(p!=null){
			Edicion ed = p.tenesEdicion(codEd);
			if(ed!=null){
				ev = p.getEdicionView(ed);
				setEdicionActual(ed);
				setPublicacionActual(p);
			}
		}
		return ev;
	}
	
	
	private Publicacion buscarPublicacion (int codPub){
		Publicacion p = null;
		for(int i=0; i<publicaciones.size(); i++){
			if(publicaciones.elementAt(i).getCodigo()==codPub){
				p=publicaciones.elementAt(i);
			}
		}
		return p;
	}
	
	public void modificarDatosEdicion(Edicion edicionActual, String tituloTapa, float precio, String fechaSalida){
		publicacionActual.modificarDatosEdicion(edicionActual, tituloTapa, precio, fechaSalida);
		setPublicacionActual(null);
		setEdicionActual(null);
	}
	
	public void cancelarModificarEdicion(){
		setPublicacionActual(null);
		setEdicionActual(null);
	}
}
