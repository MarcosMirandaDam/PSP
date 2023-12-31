package conSemaforo;

public class Consumidor extends Thread {

	private Dato dato;
	
	public Consumidor(String name,Dato dato) {

		super(name);
		this.dato=dato;

	}

	public void run() {

		while(true) {
			dato.consumirDato(this.getName());
		}
	}

}
