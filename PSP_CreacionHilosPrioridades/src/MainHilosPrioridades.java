
public class MainHilosPrioridades {

	public static void main(String[] args) {
		
		// creamos array de hilos por prioridades
		Thread[]hilosPocoPrioridad=new Thread[10];
		Thread[]hilosMediaPrioridad=new Thread[10];
		Thread[]hilosAltaPrioridad=new Thread[10];
		
		for(int i=0;i<10;i++) {
			
			Hilo miHilo=new Hilo();							//creamos hilo
			miHilo.setPriority(Thread.MIN_PRIORITY);		//le damos la prioridad minima
			hilosPocoPrioridad[i]=miHilo;					//llenamos el array
		}
		
		for(int i=0;i<10;i++) {
			
			Hilo miHilo=new Hilo();							//creamos hilo
			miHilo.setPriority(Thread.NORM_PRIORITY);		//le damos la prioridad media
			hilosMediaPrioridad[i]=miHilo;					//llenamos el array
		}
		
		for(int i=0;i<10;i++) {
			
			Hilo miHilo=new Hilo();							//creamos hilo
			miHilo.setPriority(Thread.MAX_PRIORITY);		//le damos la prioridad alta
			hilosAltaPrioridad[i]=miHilo;					//llenamos el array
		}
		
		for(int i=0;i<10;i++) {
			
			hilosPocoPrioridad[i].start();					//arrancamos el hilo
			hilosMediaPrioridad[i].start();
			hilosAltaPrioridad[i].start();
			
			
			
		}

	}

}
