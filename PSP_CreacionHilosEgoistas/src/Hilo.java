
public class Hilo extends Thread {

	public void run() {
		
		this.yield();
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Color" +this.getName());
		}

	}

}
