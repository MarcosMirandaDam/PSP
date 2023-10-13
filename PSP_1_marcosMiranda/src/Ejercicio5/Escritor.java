package Ejercicio5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Escritor {

	public static void main(String[] args) {

		ServerSocket conexion = null; 										// creamos el socket / servidor

		Socket canal = null; 												// canal por donde iran los datos

		PrintWriter streamSalida = null; 									// creamos stream de datos

		try {
			conexion = new ServerSocket(13); 								// dirigimos la conexion
			System.out.println("Escritor esperando.... al lector");
			canal = conexion.accept();										//redirigimos el canal al socket
			streamSalida = new PrintWriter(canal.getOutputStream());

			for (int i = 0; i < 10; i++) {
				streamSalida.println(i);
				streamSalida.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			streamSalida.close();
			try {
				canal.close();
				conexion.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}