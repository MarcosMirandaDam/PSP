package ConSincro;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) {
		/*
		 * Este programa lanzara tantas copias o instancias del programa
		 * "AccesoMultipleFichero" como iteraciones tenga el bucle for.
		 * 
		 */

		// Definimos una variable de tipo Process
		Process nuevoProceso;
		String nombreFichero;

		// Creamos el fichero de log "javalog.txt" para ver qué ocurre al ejecutar
		// muchos procesos.
		try {
			// Redirigimos salida estándar y de error a un fichero
			PrintStream ps = new PrintStream(
					new BufferedOutputStream(new FileOutputStream(new File("javalog.txt"), true)), true);
			System.setOut(ps);
			System.setErr(ps);
		} catch (Exception e) {
			System.err.println("Error al redirigir las salidas");
			System.err.println(e.toString());
		}

		// Identificamos el sistema operativo para poder acceder por su ruta al
		// fichero de forma correcta.
		String osName = System.getProperty("os.name");
		if (osName.toUpperCase().contains("WIN")) { // Windows
			if (args.length > 0) {
				nombreFichero = args[0].replace("\\", "\\\\");
			} // Hemos recibido la ruta del fichero en la línea de comandos
			else {
				nombreFichero = "valor.txt";
				// Fichero que se utilizará por defecto
			}
		} else { // GNU/Linux
			if (args.length > 0) {
				nombreFichero = args[0];
			} // Hemos recibido la ruta del fichero en la línea de comandos
			else {
				nombreFichero = "." + File.separator + "valor.txt";
				// Fichero que se utilizará por defecto
			}
		}

		// Creamos un grupo de procesos que accederán al mismo fichero, lanzando el
		// programa "AccesoMultipleFichero"
		try {

			String path = System.getProperty("java.class.path");

			for (int i = 1; i <= 25; i++) {
				String[] infoproceso = { "java", "-cp", path, "ConSincro.AccesoMultipleFichero", String.valueOf(i),
						nombreFichero };

				// Creamos el nuevo proceso y le indicamos el número de orden y
				// el fichero que debe utilizar.
				nuevoProceso = Runtime.getRuntime().exec(infoproceso);

				// Mostramos en javalog.txt que hemos creado otro proceso
				System.out.println("Creado el proceso " + i);
			}
		} catch (SecurityException ex) {
			System.err.println(
					"Ha ocurrido un error de Seguridad." + "No se ha podido crear el proceso por falta de permisos.");
		} catch (Exception ex) {
			System.err.println("Ha ocurrido un error, descripción: " + ex.toString());
		}
	}
}
