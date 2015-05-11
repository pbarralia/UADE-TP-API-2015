package vista;

public class PautaView {
	private boolean activa;
	private int codigo;
	private int cantUltimasEdiciones;
	private String zona;
	private String nombre;

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantUltimasEdiciones() {
		return cantUltimasEdiciones;
	}

	public void setCantUltimasEdiciones(int cantUltimasEdiciones) {
		this.cantUltimasEdiciones = cantUltimasEdiciones;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
