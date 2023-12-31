
public class Dato {

	private String dato;

	public Dato(String d) {
		dato = d;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public synchronized void meterNuevoDato(String d) {

		dato = d;
	}

}
