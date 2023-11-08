package Runnable;

public class Hilo2 implements Runnable{
	
	String nombre;
	String saludo;
	
	
	public Hilo2(String nombre, String saludo) {
		super();
		this.nombre = nombre;
		this.saludo = saludo;
	}


	@Override
	public void run() {
		
		System.out.println("Creado hilo creado con Runnable!!");
		
	}
	
	
	

}
