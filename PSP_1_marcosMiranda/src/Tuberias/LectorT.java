package Tuberias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LectorT {

	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String valorEntrada = null;
		Scanner sc = new Scanner(System.in);
		
		try {

			while ((valorEntrada = br.readLine()) != null) {
				System.out.println(valorEntrada);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
