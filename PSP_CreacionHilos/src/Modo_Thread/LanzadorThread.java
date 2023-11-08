package Modo_Thread;

public class LanzadorThread {

	public static void main(String[] args) {
	
		int tiempo;
		
	for(int i=0;i<25;i++) {
		
		tiempo=(int) Math.random()*8+1*1000;
		Hilo mihilo=new Hilo(tiempo,String.valueOf(i));
		mihilo.start();
	}

	}

}
