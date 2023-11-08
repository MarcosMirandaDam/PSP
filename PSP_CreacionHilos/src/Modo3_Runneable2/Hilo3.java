package Modo3_Runneable2;

public class Hilo3 implements Runnable {

	Thread hiloAuxiliar;					// hilo auxiliar
	
	public void creaLanzaHiloAux() {		//metodo que crea y lanza el hilo auxiliar creado
		hiloAuxiliar=new Thread(this);		
		hiloAuxiliar.start();
	}
	
	int tiempo;
	String nombre;

	// constructor
	public Hilo3(int tiempo, String nombre) {
		this.tiempo = tiempo;
		this.nombre = nombre;
	}

	// codigo que ejecuta el hilo cuando llamemos a hilo.start()
	public void run() {

		System.out.println("Dormimos el hilo :" + nombre + " durante " + tiempo + " milisegundos");
		try {

			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Despertamos el hilo:" + nombre);

	}
}
