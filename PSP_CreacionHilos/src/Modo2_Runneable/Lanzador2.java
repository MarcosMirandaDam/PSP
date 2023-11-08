package Modo2_Runneable;

import Modo_Thread.Hilo;

public class Lanzador2 {

	public static void main(String[] args) {
		int tiempo;
		
		for(int i=0;i<25;i++) {
			
			tiempo=(int) Math.random()*8+1*1000;
			
			Hilo2 hiloRunnable=new Hilo2(String.valueOf(i),tiempo);
			
			Thread miHilo= new Thread(hiloRunnable);
			
			miHilo.start();
		}

		

	}

}
