package modelo;

import java.util.Vector;

public class Revista extends Publicacion {

	public Revista(int codigo, String titulo, String editor, String tema,
			String subtema, String publico, int periodicidad, String idioma,
			String paisDeOrigen, Vector<Edicion> ediciones) {

		super(codigo, titulo, editor, tema, subtema, publico, periodicidad,
				idioma, paisDeOrigen, ediciones);

	}

	public void getUltimasTresEdiciones() {

	}
}
