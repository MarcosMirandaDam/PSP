package ConWait;

public class Consumidor extends Thread {

	private Dato dato;
	private String nombre;

	public Consumidor(Dato d, String n) {

		dato = d;
		nombre = n;

	}

	public void run() {

		for (int i = 0; i < 5; i++) {

			System.out.println(nombre + "consumiendo el dato:" + dato.getDato());
		}
	}

}
