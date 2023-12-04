package Modelo;

/**
 * @author Marcos Miranda
 */

public class Jardin {
	
	private int personasDentroJardin;

	
	public Jardin(int personasDentroJardin) {
		this.personasDentroJardin = personasDentroJardin;
	}


	public int getPersonasDentroJardin() {
		return personasDentroJardin;
	}


	public void setPersonasDentroJardin(int personasDentroJardin) {
		this.personasDentroJardin = personasDentroJardin;
	}
	
	/**
	 * metodo que incrementa el numero de personas en el jardin. SYNCHRONIZED O NO, DEPENDE !!
	 */
	public  void incrementarPersonas() {			
		
		System.out.println(Thread.currentThread().getName());
        personasDentroJardin++;
        System.out.println("Total personas en jardín: " + personasDentroJardin);
		
	}
	
	/**
	 * metodo que decrementa el numero de personas en el jardin .SYNCHRONIZED O NO, DEPENDE !!
	 */
	public  void decrementarPersonas() {
		System.out.println(Thread.currentThread().getName());
		personasDentroJardin--;
        System.out.println("Total personas en jardín: " + personasDentroJardin);
		
	}
	

}
