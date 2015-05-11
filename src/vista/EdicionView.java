package vista;


public class EdicionView {
	private int codigoEdicion;
	private String tituloTapa;
	private float precio;
	private String fechaSalida;

	public EdicionView(String tituloTapa){
		this.tituloTapa = tituloTapa;
		};
	
	public EdicionView(int codigoEdicion, String tituloTapa, float precio,
			String fechaSalida) {
		super();
		this.codigoEdicion = codigoEdicion;
		this.tituloTapa = tituloTapa;
		this.precio = precio;
		this.fechaSalida = fechaSalida;
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
	
}
