package TuberiasTabla5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LectorTablaMultiplicar {

	public static void main(String[] args) {
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		String valorEntrada=null;
		
		try {
			
						
			while((valorEntrada=br.readLine())!=null){
				System.out.println(valorEntrada + " X 5 = "+Integer.valueOf(valorEntrada)*5);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
