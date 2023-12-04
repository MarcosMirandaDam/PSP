
public class MainHilosEgoistas {

	public static void main(String[] args) {
		
		Hilo mihiloV=new Hilo();
		mihiloV.setName("verde");
		Hilo mihiloA=new Hilo();
		mihiloA.setName("azul");
		Hilo mihiloR=new Hilo();
		mihiloR.setName("rojo");
		
		
		mihiloV.start();
		mihiloA.start();
		mihiloR.start();
		
	}

		
}
