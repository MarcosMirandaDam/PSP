package SinSincro;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Este programa lee el valor guardado en un fichero, lo incrementa, y escribe
 * el nuevo valor en el mismo fichero. El dato se lee y se escribe en el fichero
 * valor.txt Redirigimos la salida System.out al fichero de log "javalog.txt"
 * Después de ejecutarlo la primera vez, refrescar el proyecto (botón derecho
 * sobre proyecto-> refresh) para que salgan los archivos, tanto valor.txt
 * comojavalog.txt Abrir los ficheros y comprobar el contenido para analizarlo.
 */
public class AccesoMultipleFichero {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 int orden = 0;
	      String nombreFichero = "";
	      File archivo = null;
	      FileReader leer = null;
	      BufferedReader br = null;
	      FileWriter escribir = null;
	      PrintWriter pw = null;
	      int valor = 0;
	      
	      //Número de orden de creación de este proceso
	      if (args.length > 0)
	          orden = Integer.parseInt(args[0]);
	      
	      //Creamos el fichero de log "javalog.txt" para ver qué ocurre al ejecutar muchos procesos. 
	      try{

	    	  PrintStream ps = new PrintStream(
	                             new BufferedOutputStream(new FileOutputStream(
	                             new File("."+File.separator+"javalog.txt"),true)), true);
	           
	          System.setOut(ps);
	          System.setErr(ps);
	      }catch(Exception e){
	            System.err.println("P"+orden+" No he podido redirigir salidas.");
	      }
	      
	      //Identificamos el sistema operativo para poder acceder por su ruta al
	      //fichero de forma correcta.
	      String osName = System.getProperty("os.name");
	      if (osName.toUpperCase().contains("WIN")){ //Windows
	        if (args.length > 1)
	            nombreFichero = args[1].replace("\\", "\\\\");
	            //Hemos recibido la ruta del fichero en la línea de comandos
	        else{
	            nombreFichero = "."+File.separator+"valor.txt";
	            //Fichero que se utilizará por defecto
	          }
	      }else{ //GNU/Linux
	          if (args.length > 1)
	            nombreFichero = args[1];
	          //Hemos recibido la ruta del fichero en la línea de comandos
	          else{
	               nombreFichero = "."+File.separator+"valor.txt";
	               //Fichero que se utilizará por defecto
	        }
	      }
	      archivo = new File(nombreFichero);
	      
	      //Si el fichero no existe, lo creamos y escribimos un "0"
	      if (!archivo.exists()){
	          //Si no existe el fichero
	        try {
	            archivo.createNewFile(); //Lo creamos
	            escribir = new FileWriter(nombreFichero);
	            pw = new PrintWriter(escribir);
	            pw.println(String.valueOf(0)); //Escribimos el valor 0 en el fichero
	            System.out.println("Proceso"+ orden + ": Creando el fichero.");
	        }catch(Exception e){
	            System.err.println("P"+orden+" Error al crear el fichero");            
	        }finally{
	            try{
	            // Nos asegurarnos que se cierra el fichero.
	                if (null != escribir)
	                    escribir.close();
	               } catch (Exception e2) {
	                    System.err.println("Error al cerrar el fichero");
	                    System.exit(1); //Si hay error, finalizamos
	               }
	        }
	       }
	      
	      //Si el fichero existe, leemos el valor de la primera línea.
	      //Leemos de fichero
	      try{
	         leer = new FileReader(archivo);
	         br = new BufferedReader(leer);
	         // Lectura del fichero
	         String linea;
	         linea = br.readLine();
	         valor = Integer.parseInt(linea);
	         System.out.println("Proceso"+ orden +
	                 ": Valor leído del fichero: " + valor);
	      }catch(Exception e){
	         System.err.println("P"+orden+" Error al leer del fichero");
	      }finally{
	         // En el finally cerramos el escribir, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta
	         // una excepcion.
	         try{
	            if( null != leer ){
	               leer.close();
	            }
	         }catch (Exception e2){
	            System.err.println("P"+orden+" Error al cerrar el fichero");
	            System.exit(1);  //Si hay error, finalizamos
	         }         
	      }
	      //Incrementamos el valor del número leido.
	      valor ++;

	      //Escribimos en el fichero el número nuevo ya incrementado
	      try {
	            escribir = new FileWriter(nombreFichero);
	            pw = new PrintWriter(escribir);           
	            pw.println(String.valueOf(valor));
	            System.out.println("Proceso"+ orden +
	                 ": Valor escrito en el fichero: " + valor);
	      }
	      catch(Exception e){
	         System.err.println("P"+orden+" Error al escribir en el fichero");
	      }finally{
	        try{
	           // Nos asegurarnos de que se cierra el fichero.
	           if (null != escribir)
	              escribir.close();
	           } catch (Exception e2) {
	              System.err.println("P"+orden+" Error al cerrar el fichero");
	              System.exit(1);  //Si hay error, finalizamos
	           }         
	      }
		

	}

}
