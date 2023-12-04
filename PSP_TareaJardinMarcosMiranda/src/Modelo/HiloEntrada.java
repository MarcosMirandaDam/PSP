package Modelo;

/**
 * @author Marcos Miranda
 */
public class HiloEntrada extends Thread{
	
	private String nombre;
	private Jardin jardin;
	
	
	public HiloEntrada(String nombre, Jardin jardin) {
		
		this.nombre = nombre;
		this.jardin = jardin;
		this.setName(nombre);
	}


	@Override
	public void run() {
		jardin.incrementarPersonas();
	}
	
	

}
