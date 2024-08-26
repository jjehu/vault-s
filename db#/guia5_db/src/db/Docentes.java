package db;

public class Docentes {
	String cedula;
	String nombre;
	String ap;
	String am;
	int estado;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public Docentes() {}
	public Docentes(String cedula, String nombre, String ap, String am, int estado) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.ap = ap;
		this.am = am;
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Docentes [cedula=" + cedula + ", nombre=" + nombre + ", ap=" + ap + ", am=" + am + ", estado=" + estado
				+ "]";
	}
}
