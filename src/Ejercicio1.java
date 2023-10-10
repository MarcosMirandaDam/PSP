import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {

		String[] parametros = { "Notepad.exe", "notas.txt" };

		try {
			Process n1Proceso = Runtime.getRuntime().exec(parametros);
			int valorAlCierre = n1Proceso.waitFor();
			System.out.println("Valor de retorno ---> " + valorAlCierre);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
