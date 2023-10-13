package Ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author  Marcos Miranda.
 * En este caso el lector coge los valores y los multiplica por 5 .
 */
public class Lector {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		Socket canal = null;

		BufferedReader entrada = null;

		String lectura = null;

		String[] miArray = new String[10]; // almacenamos los datos en un array
		int contador = 0; // para llevar registro de la cantidad de elementos añadidos

		try {
			canal = new Socket("localHost", 13);
			entrada = new BufferedReader(new InputStreamReader(canal.getInputStream()));

			while ((lectura = entrada.readLine()) != null) {
				miArray[contador] = lectura;
				contador++;
			}

			System.out.println("Introduzca el número deseado para realizar la tabla de multiplicar:");		
			int numeroDeseado=sc.nextInt();
			for (int i = 0; i < contador; i++) {

				System.out.println(+Integer.parseInt(miArray[i]) + " X "+numeroDeseado+ " = " + Integer.parseInt(miArray[i]) * numeroDeseado); // multiplicamos
																													// por
																													// 5
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				entrada.close();
				canal.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
