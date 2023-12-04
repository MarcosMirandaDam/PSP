package ejemplo;

public class Hilo extends Thread {

	 boolean detenido = true; // creamos boolean para determinar el esatdo del hilo.
	
	@Override
	public void run() {

		while(isAlive()) {
		while (detenido) {
				
			try {
				System.out.println("Ejecutando ---->" + Thread.currentThread().getName());
				
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		}
	}

	public  void detenElHilo() {

		detenido = false;
		

	}
	
	
	public  void reanudarElHilo() {

		detenido=true;

	}

	
}
