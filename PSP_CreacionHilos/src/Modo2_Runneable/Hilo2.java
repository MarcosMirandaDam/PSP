package Modo2_Runneable;

public class Hilo2 implements Runnable{
	
	int tiempo;
	String nombre;
	
	
	//constructor 
	public Hilo2(String nombre,int tiempo) {
		this.tiempo = tiempo;
		this.nombre = nombre;
	}



	//codigo que ejecuta el hilo cuando llamemos a hilo.start()
	public void run() {
		
		System.out.println("Dormimos el hilo :"+nombre+ " durante "+tiempo+ " milisegundos");
		try {
			
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} System.out.println("Despertamos el hilo:"+nombre);
		
		
	}

}
