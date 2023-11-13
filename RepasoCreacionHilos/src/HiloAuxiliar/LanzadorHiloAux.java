package HiloAuxiliar;

import java.util.Iterator;

public class LanzadorHiloAux {

	public static void main(String[] args) {
		
		Hilo3 miHiloRunnable;									//creamos objeto Hilo3
		
		int tiempo=0;
		
		for (int i = 0; i < 20; i++) {
			
			tiempo=(int) Math.random()*8+1*1000;
			
			miHiloRunnable=new Hilo3(tiempo,String.valueOf(i));			// lo hacemos runnable
					
			miHiloRunnable.creaLanzaHiloAuxiliar();						// creamos y lanzamos 
			
		}
		

	}

}
