package Modelo;

/**
 * @author Marcos Miranda
 */
public class HiloSalida extends Thread{
	
	private String nombre;
	private Jardin jardin;
	
	
	public HiloSalida(String nombre, Jardin jardin) {
		
		this.nombre = nombre;
		this.jardin = jardin;
		this.setName(nombre);
	}


	@Override
	public void run() {
		jardin.decrementarPersonas();
	}
	
	
	

}
