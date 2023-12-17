/**
 * 	Clase Servidor. 
 *	 Se pretende contabilizar los accesos actuales a un servidor WEB. Se considera que el servidor Web es un recurso compartido y habrá una variable que se incrementará cada vez que se accede a él.
	Cada cliente o terminal será un hilo. Simular que acceden al servidor Web 20 hilos terminales, cada uno de ellos realiza 1 acceso.
	@author Marcos Miranda
 */
public class Servidor {
	
	private int numeroConexiones;

	public Servidor() {
		this.numeroConexiones=0;
		
	}

	public int getNumeroConexiones() {
		return numeroConexiones;
	}

	public void setNumeroConexiones(int numeroConexiones) {
		this.numeroConexiones = numeroConexiones;
	}
	
	/**
	 * metodo que incrementa el numero de conexiones al servidor web
	 */
	public synchronized void incrementarNumeroConexion() {
		System.out.println(Thread.currentThread().getName());
		numeroConexiones++;
		System.out.println("Número de clientes conectados al servidor --->"+numeroConexiones);
	}
	

}
