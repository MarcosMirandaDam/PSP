package conSemaforo;

public class Main {

	public static void main(String[] args) {

		final int PRODUCTOR=3;		//constante numero de productores
		final int CONSUMIDOR=4;		//constante numero de consumidores
		
		Dato dato=new Dato();
		
		for (int i = 0; i < PRODUCTOR; i++) {
            new Productor("Productor " + i, dato).start();
        }
        
        for (int i = 0; i < CONSUMIDOR; i++) {
            new Consumidor("Consumidor " + i, dato).start();
        }
		

	}

}
