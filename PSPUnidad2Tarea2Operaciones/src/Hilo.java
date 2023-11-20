import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{

	String nombre;

	/**
	 * constructor del hilo con el parametro nombre
	 * @param nombre
	 */
	public Hilo(String nombre) {
		super(nombre);
	
	}

	@Override
	public void run() {
		try {
			sleep(2000);
			System.out.println("FIN HILO");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	
	
	
	
}
