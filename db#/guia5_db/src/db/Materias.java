package db;

public class Materias {
	String sigla;
	String nombre;
	int cargahora;
	int estado;
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCargahora() {
		return cargahora;
	}
	public void setCargahora(int cargahora) {
		this.cargahora = cargahora;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public Materias() {}
	public Materias(String sigla, String nombre, int cargahora, int estado) {
		super();
		this.sigla = sigla;
		this.nombre = nombre;
		this.cargahora = cargahora;
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Materias [sigla=" + sigla + ", nombre=" + nombre + ", cargahora=" + cargahora + ", estado=" + estado
				+ "]";
	}
}
