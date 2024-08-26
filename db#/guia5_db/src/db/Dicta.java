package db;

public class Dicta {
	int gestion;
	Docentes doc;
	Materias mat;
	
	public int getGestion() {
		return gestion;
	}
	public void setGestion(int gestion) {
		this.gestion = gestion;
	}
	public Docentes getDoc() {
		return doc;
	}
	public void setDoc(Docentes doc) {
		this.doc = doc;
	}
	public Materias getMat() {
		return mat;
	}
	public void setMat(Materias mat) {
		this.mat = mat;
	}
	
	public Dicta() {}
	public Dicta(int gestion, Docentes doc, Materias mat) {
		super();
		this.gestion = gestion;
		this.doc = doc;
		this.mat = mat;
	}
	
	@Override
	public String toString() {
		return "Dicta [gestion=" + gestion + ", doc=" + doc + ", mat=" + mat + "]";
	}
}
