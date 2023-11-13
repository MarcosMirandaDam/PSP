package HiloAuxiliar;

public class Hilo3  implements Runnable{

	Thread hiloAux;									// hilo auxiliar
	
	
	public void creaLanzaHiloAuxiliar() {			//creamos y lanzamos el hilo auxiliar
		hiloAux=new Thread(this);
		hiloAux.start();
	}
	
	int tiempo;										//en este caso usaremos tiempo para dormirlo lo deseado
	String nombre;									//nombre de cada hilo
	
	
	public Hilo3(int tiempo, String nombre) {       //constructor
		super();
		this.tiempo = tiempo;
		this.nombre = nombre;
	}

	// codigo que ejecuta el hilo cuando llamemos a hilo.start()
	@Override
	public void run() {
		System.out.println("Dormimos el hilo "+nombre+ " durante "+tiempo+ "milisegundos");
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Despertamos el hilo "+nombre);
		
		
	}

	
	
}
