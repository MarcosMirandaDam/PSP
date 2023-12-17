/**
 * Clase HiloTerminal, simula un cliente , Creamos también una clase HiloTerminal que se 
 * encargará de crear el hilo con un nombre de Terminal Cliente y se pasará también el 
 * objeto servidorWeb al que va a acceder. Su método run() invocará al correspondiente método del 
 * servidorWeb que se encarga de contabilizar los accesos al mismo. Suponemos que desde cada Terminal 
 * se realizarán 1 accesos al servidor web.
 * @author Marcos Miranda
 */
public class HiloTerminal extends Thread{
	
	private String nombre;
	private Servidor servidor;
	
	public HiloTerminal(String nombre, Servidor servidor) {
		
		this.nombre = nombre;
		this.servidor = servidor;
		this.setName(nombre);			//le ponemos el nombre de esta manera al hilo
	}

	@Override
	public void run() {
		
		servidor.incrementarNumeroConexion();
	}
	
	

}
