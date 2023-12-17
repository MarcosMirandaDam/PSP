/**
 * Crear un main donde se defina un objeto ServidorWeb y simular el acceso de 20 TerminalesClientes
 *  cada uno de los cuales hará 1 acceso al servidor Web
 *  @author Marcos Miranda
 */
public class MainServidor {

	public static void main(String[] args) {
		
		Servidor servidor = new Servidor();
		
		for(int i=0;i<20;i++) {
			HiloTerminal hilo=new HiloTerminal("Se conecta al servidor el cliente -->"+i, servidor);
			hilo.start();
			
		}
		
		

	}

}
