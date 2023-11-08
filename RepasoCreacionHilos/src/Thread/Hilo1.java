package Thread;

public class Hilo1 extends Thread{
	
	String saludo=" Hola estoy creando un hilo extendiendo Thread!!";
	
	public void run() {
		
		System.out.println(saludo);
	}

}
