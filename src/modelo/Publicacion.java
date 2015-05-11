package modelo;

import java.util.Vector;
import vista.EdicionView;

public abstract class Publicacion {
	private int codigo;
	private String titulo;
	private String editor;
	private String tema;
	private String subtema;
	private String publico;
	private int periodicidad;
	private String idioma;
	private String paisDeOrigen;
	private Vector<Edicion> ediciones;

	public abstract void getUltimasTresEdiciones();

	public Publicacion(int codigo, String titulo, String editor, String tema,
			String subtema, String publico, int periodicidad, String idioma,
			String paisDeOrigen, Vector<Edicion> ediciones) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.editor = editor;
		this.tema = tema;
		this.subtema = subtema;
		this.publico = publico;
		this.periodicidad = periodicidad;
		this.idioma = idioma;
		this.paisDeOrigen = paisDeOrigen;
		this.ediciones = ediciones;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getSubtema() {
		return subtema;
	}

	public void setSubtema(String subtema) {
		this.subtema = subtema;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public int getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}

	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}

	public Vector<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(Vector<Edicion> ediciones) {
		this.ediciones = ediciones;
	}

	public void agregarEdicion(String tituloEdicion, float precio,
			String fechaSalida) {
		Edicion edicionNueva = new Edicion(tituloEdicion, precio, fechaSalida);

		ediciones.add(edicionNueva.getCodigoEdicion(), edicionNueva);
	}

	public Edicion tenesEdicion (int codEd){
		Edicion e;
		return e = buscarEdicion(codEd);
	}
	
	public EdicionView getEdicionView(Edicion ed){
		return ed.getView();
	}
	
	private Edicion buscarEdicion(int codigoEdicion) {
		for(int i = 0; i < ediciones.size(); i++){
			//JOAQUIN: para mi no es necesario el sosEdicion
			//Pablo : podemos hacer la busqueda por el codigo de la edicion directamente
			if(ediciones.elementAt(i).getCodigoEdicion() == codigoEdicion)
				//JOAQUIN: modifique para que solo busque las ediciones no borradas
				// Pablo estoy deacuerdo
				if(ediciones.elementAt(i).isBorrado()==false){
					return ediciones.elementAt(i);
				}	
		}
		return null;
	}
	
	public void bajaLogica() {
		edicionActual.setBorrado(true);
	}
	
	
	public void modificarDatosEdicion(Edicion edicionActual, String tituloTapa, float precio, String fechaSalida) {
		edicionActual.modificarDatos(tituloTapa, precio, fechaSalida);
	}
}
