package Runnable;

public class LanzadorRunnable {

	public static void main(String[] args) {
		
			
		Hilo2 mihilo=new Hilo2(null, null);		// creamos objeto Hilo2 de la clase creada
		Thread hilo1=new Thread(mihilo);		//creamos el hilo con la clase Thread pasando como argumento el objeto Hilo2
		hilo1.start();							//arrancamos el hilo !!
				
		

	}

}
