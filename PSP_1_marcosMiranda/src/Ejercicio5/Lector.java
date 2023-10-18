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

		try {
			canal = new Socket("localHost", 13);
			entrada = new BufferedReader(new InputStreamReader(canal.getInputStream()));
			
			System.out.println("Introduzca el número deseado para realizar la tabla de multiplicar:");					//pedimos numero
			int numeroDeseado=sc.nextInt();
			
			while ((lectura = entrada.readLine()) != null) {
				System.out.println(lectura+ " X " +numeroDeseado+ " = " +numeroDeseado*Integer.valueOf(lectura));		//multiplicamos por numero
				
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
