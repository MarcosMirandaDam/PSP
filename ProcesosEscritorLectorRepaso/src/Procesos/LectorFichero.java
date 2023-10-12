package Procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LectorFichero {

	public static void main(String[] args) {

		Socket canal = null;

		BufferedReader br = null;

		String lectura = null;
		
		File fichero=new File("pruebaFichero.txt");
		
		try {
			canal=new Socket("localHost",7);
			br=new BufferedReader(new FileReader(fichero));
			
			while((lectura=br.readLine())!=null) {
				System.out.println(lectura);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} try {
				if(canal!=null) {
					canal.close();
				}
				
			} catch(IOException e) {
				
			}
		}
		

	}

}
