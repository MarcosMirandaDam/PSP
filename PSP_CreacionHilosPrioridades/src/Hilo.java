
public class Hilo extends Thread{

	
	public void run() {
		
		
		for(int i=1;i<=1000000;i++) {
			this.yield();
			
		}
		System.out.println("Hilo "+this.getName()+ " con prioridad"+this.getPriority());
	}
}
