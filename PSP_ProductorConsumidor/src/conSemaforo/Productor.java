package conSemaforo;

public class Productor extends Thread {

	private Dato dato;

	

	public Productor(String name, Dato dato) {
		super(name);
		this.dato = dato;
	}



	public void run() {

		while(true) {
			dato.producirDato(getName());
		}
	}

}
