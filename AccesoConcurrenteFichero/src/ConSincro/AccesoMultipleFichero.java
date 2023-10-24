package ConSincro;

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
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

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

		// BLOQUEO
		FileLock bloqueo = null;
		RandomAccessFile raf = null;

		int valor = 0;

		// Número de orden de creación de este proceso
		if (args.length > 0)
			orden = Integer.parseInt(args[0]);

		// Creamos el fichero de log "javalog.txt" para ver qué ocurre al ejecutar
		// muchos procesos.
		try {

			PrintStream ps = new PrintStream(new BufferedOutputStream(
					new FileOutputStream(new File("." + File.separator + "javalog.txt"), true)), true);

			System.setOut(ps);
			System.setErr(ps);
		} catch (Exception e) {
			System.err.println("P" + orden + " No he podido redirigir salidas.");
		}

		// Identificamos el sistema operativo para poder acceder por su ruta al
		// fichero de forma correcta.
		String osName = System.getProperty("os.name");
		if (osName.toUpperCase().contains("WIN")) { // Windows
			if (args.length > 1)
				nombreFichero = args[1].replace("\\", "\\\\");
			// Hemos recibido la ruta del fichero en la línea de comandos
			else {
				nombreFichero = "." + File.separator + "valor.txt";
				// Fichero que se utilizará por defecto
			}
		} else { // GNU/Linux
			if (args.length > 1)
				nombreFichero = args[1];
			// Hemos recibido la ruta del fichero en la línea de comandos
			else {
				nombreFichero = "." + File.separator + "valor.txt";
				// Fichero que se utilizará por defecto
			}
		}

		////// COMIENZO SECCION CRITICA///////

		try {

			archivo = new File(nombreFichero);

			boolean existe;
			
			if(archivo.exists()) {
				existe=true;
			}else {
				existe=false;
			}
			
			raf=new RandomAccessFile(archivo,"rw");					//creamos el ramdon access file
			
			bloqueo=raf.getChannel().lock();						//bloqueamos
			
			System.out.println("Proceso "+orden+ " Bloqueando acceso a fichero");
			
			if(!existe) {
				 
				System.out.println("Proceso "+orden+ " creando  fichero");
				
				//escribimos
				
				raf.writeBytes("1");
				
			} else {
				
				//leemos dato
				String linea=null;
				linea=raf.readLine();
				valor= Integer.parseInt(linea);
				System.out.println("Proceso "+orden+ " lee el dato : "+valor);
				
				//incrementamos valor
				valor++;
				
				//escribimos valor
				raf.seek(0);
				
				raf.writeBytes(String.valueOf(valor));
				System.out.println("Proceso "+orden+ " escribe el dato : "+valor);
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Proceso "+orden+ " error en acceso a fichero");
		} finally {
			////// FIN SECCION CRITICA/////////
			if(bloqueo!=null) {
				try {
					bloqueo.release();
					System.out.println("Proceso "+orden+ " liberando acceso a fichero");
					if(raf!=null) {
						raf.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

		

	}

}
