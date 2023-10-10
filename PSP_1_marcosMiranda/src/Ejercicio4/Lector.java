package Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Lector {

	public static void main(String[] args) {
		
		Socket canal=null;
		
		BufferedReader entrada=null;
		
		String lectura = null;
		
		try {
			canal=new Socket("localHost",13);
			entrada=new BufferedReader(new InputStreamReader(canal.getInputStream()));
			
			
			while((lectura=entrada.readLine())!=null) {
				System.out.println(lectura);
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
