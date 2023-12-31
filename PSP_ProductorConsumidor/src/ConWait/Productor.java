package ConWait;

public class Productor extends Thread {

	private Dato dato;

	private String nombre;

	public Productor(Dato d, String n) {
		dato = d;
		nombre = n;
	}

	public void run() {

		for (int i = 0; i < 5; i++) {

			dato.meterNuevoDato(nombre + " " + i);
		}
	}

}
