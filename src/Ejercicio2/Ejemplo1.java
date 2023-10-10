package Ejercicio2;

import java.io.IOException;
import java.util.Iterator;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		String[] parametros = { "Notepad.exe", "notas.txt" };
		
		ProcessBuilder pbuilder=new ProcessBuilder(parametros);
		
		for(int i=0;i<3;i++) {
			try {
								
				Process p=pbuilder.start();
				Thread.sleep(3000);
				p.destroy();
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
