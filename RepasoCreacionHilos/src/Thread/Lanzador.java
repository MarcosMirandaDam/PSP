package Thread;

public class Lanzador {

	public static void main(String[] args) {
		
		Hilo1 mihilo=new Hilo1();
		mihilo.start();
		mihilo.interrupt();

	}

}
