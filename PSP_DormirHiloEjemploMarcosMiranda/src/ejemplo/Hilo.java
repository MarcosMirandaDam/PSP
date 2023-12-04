package ejemplo;

import javax.swing.JPanel;

public class Hilo extends Thread {

	JPanel_Marcador marcador;
	boolean dormir;
	

	public Hilo(JPanel_Marcador m,boolean d) {
		this.marcador = m;
		dormir=d;
	}



	@Override
	public void run() {

		for (int i = 0; i <= 20; i++) {
			marcador.valor = i;
			marcador.repaint();
			
			if(dormir) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
