import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesHilo {

	public static void main(String[] args) {
		
		Thread.currentThread().setName("ProgPrincipal");			//ponemos nombre al hilo de la clase principal
		
		Hilo mihilo=new Hilo("miHilo");								//instanciamos objeto clase hilo y pongo nombre mihilo
		
		System.out.println("Hilo "+mihilo.getName()+ " en ejecución ? ---> "+mihilo.isAlive());   //compruebo si está vivo o muerto
		
		mihilo.start();					// lo arranco....
		
		System.out.println("Hilo "+mihilo.getName()+ " en ejecución ? ---> "+mihilo.isAlive());   //compruebo si está vivo o muerto de nuevo
		
		System.out.println("HILO PRINCIPAL ----> "+Thread.currentThread().getName());			// nombre del hilo principal
		
		try {
			Thread.currentThread().sleep(1000);				//duermo el principal 3 segundos
			System.out.println("Se ha dormido el hilo "+Thread.currentThread());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, e);
		}
		System.out.println("Hilo " + mihilo.getName() + " después de ejecutarse: " + mihilo.isAlive());
		
	}

}
