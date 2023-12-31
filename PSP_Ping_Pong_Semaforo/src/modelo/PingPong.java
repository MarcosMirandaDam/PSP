package modelo;

import java.util.concurrent.Semaphore;

public class PingPong extends Thread{
	
	private String sonido;
	private Semaphore semaforo;
	
	//constructor
	public PingPong(String sonido, Semaphore semaforo) {
		super();
		this.sonido = sonido;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			try {
				semaforo.acquire();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(sonido);
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaforo.release();
			
			
		}
		
	}
	
	
	
	

}
