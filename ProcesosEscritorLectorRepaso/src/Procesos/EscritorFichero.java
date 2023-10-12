package Procesos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EscritorFichero {

	public static void main(String[] args) {

		ServerSocket conexion = null; // creamos ServerSocket

		Socket canal = null; // creamos el canal

		BufferedWriter bw = null; // bufer de escritura

		try {
			File fichero = new File("pruebaFichero.txt"); // fichero
			conexion = new ServerSocket(7); // numero del puerto asignado
			canal = conexion.accept();
			System.out.println("Escritor esperando al lector......");
			bw = new BufferedWriter(new FileWriter(fichero));

			for (int i = 0; i < 15; i++) {
				bw.write("Linea de escritura----" + i);
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				try {
					if(canal!=null) {
						 canal.close();
						 conexion.close();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		}

	}

}
