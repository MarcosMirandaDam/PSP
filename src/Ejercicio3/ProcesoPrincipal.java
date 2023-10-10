package Ejercicio3;

import java.io.IOException;

public class ProcesoPrincipal {

	public static void main(String[] args) {
		
		//Lanzar el proceso secundario
		
		String path=System.getProperty("java.class.path");
		
		String[] parametros= {"java","-cp",path,"Ejercicio3.ProcesoSecundario"};
				
		ProcessBuilder pBuilder=new ProcessBuilder(parametros);
		
		try {
			
			pBuilder.redirectErrorStream();
			pBuilder.inheritIO();
			Process miProcesoSecundadrio=pBuilder.start();
					
			// Recibir feedback
			
			int valorRetorno=miProcesoSecundadrio.waitFor();
			
			if(valorRetorno==0){
				System.out.println("Proceso2 ejecutado correctamente");
			} else {
				System.out.println("error en el proceso con el codigo de error---> "+valorRetorno);
			}
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
