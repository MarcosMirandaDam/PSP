package Procesos;

import java.io.IOException;

public class ProcesoPrincipal {

	public static void main(String[] args) {
		
		//Lanzamos el proceso secundario
		
		String path=System.getProperty("java.class.path");
		
		String[]parametros= {"java","-cp",path,"Procesos.ProcesoSecundario"};
		
		ProcessBuilder pBuilder=new ProcessBuilder(parametros);
		
		try {
			
			pBuilder.redirectErrorStream();
			pBuilder.inheritIO();
			Process miProcesoSecundario=pBuilder.start();
			
			// recibir feedback
			
			int valoresRetorno=miProcesoSecundario.waitFor();
			
			if(valoresRetorno==0) {
				System.out.println("Proceso Secundario ejecutado correctamente");
			} else {
				System.out.println("Se ha producido un error Codigo---> "+valoresRetorno);
			}
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
