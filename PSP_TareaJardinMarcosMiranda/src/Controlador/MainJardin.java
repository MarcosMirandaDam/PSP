package Controlador;

import Modelo.HiloEntrada;
import Modelo.HiloSalida;
import Modelo.Jardin;

/**
 * @author Marcos Miranda
 */
public class MainJardin {

	public static void main(String[] args) {
		
		Jardin jardin=new Jardin(50);
		
		for(int i=0;i<10;i++) {
			HiloEntrada hiloEntrada=new HiloEntrada("Entra persona "+i,jardin);
			hiloEntrada.start();
		}
		
		for(int i=0;i<10;i++) {
			HiloSalida hiloSalida=new HiloSalida("Sale persona "+i,jardin);
			hiloSalida.start();
		}
		
				
	}

}
