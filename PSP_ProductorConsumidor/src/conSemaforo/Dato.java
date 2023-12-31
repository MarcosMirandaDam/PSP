package conSemaforo;

/**
 * @author Marcos Miranda
 * 
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dato {

	private final int MAX_LIMITE=5;
	private int dato;
	private Semaphore productor=new Semaphore(MAX_LIMITE);
	private Semaphore consumidor=new Semaphore(0);
	private Semaphore semaforo=new Semaphore(1);		//decidir numero de hilos a region critica

	

	/**
	 * consumidor
	 * @return
	 */
	public void producirDato(String nombreProductor) {

		System.out.println(nombreProductor + " intentando almacenar un dato.");
		try {
				productor.acquire();
				semaforo.acquire();
				
				dato++;
				System.out.println(nombreProductor + " almacena un dato." + " Almacen con "+dato+ "datos almacenados");
				semaforo.release();
				
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				consumidor.release();

			}
	}

	/**
	 * productor..
	 * @param d
	 */
	public  void consumirDato(String nombreConsumidor) {
		
		System.out.println(nombreConsumidor + " intentando consumir un dato");
		try {
			consumidor.acquire();
			semaforo.acquire();
			
			dato--;
			
			System.out.println(nombreConsumidor + " consume un dato." + "Almacenamiento de datos con "+dato+ " datos.");
			semaforo.release();
			
			Thread.sleep(500);
			
		} catch (InterruptedException ex){
			Logger.getLogger(Dato.class.getName()).log(Level.SEVERE,null,ex);
		}
		finally {
            productor.release();

        }
		
			
		}

}
