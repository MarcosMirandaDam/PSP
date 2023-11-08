package Modo3_Runneable2;

import Modo_Thread.Hilo;

public class LanzadorForma3 {

	public static void main(String[] args) {
		
		int tiempo = 0;
		
		Hilo3 mihiloRunnable=new Hilo3(tiempo, null);				//creamos el objeto Hilo3 
		
		for(int i=0;i<25;i++) {
			
			tiempo=(int) Math.random()*8+1*1000;
			
			mihiloRunnable=new Hilo3(tiempo,String.valueOf(i));
			
			Thread mihilo=new Thread(mihiloRunnable);
			
			mihiloRunnable.creaLanzaHiloAux();              // aqui creamos y lanzamos a la vez
		}

		
	}

}
