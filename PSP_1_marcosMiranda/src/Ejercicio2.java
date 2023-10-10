import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		String[] parametros = { "Notepad.exe", "notas.txt" };

		try {
			
			Process n1Proceso = Runtime.getRuntime().exec(parametros);
			Thread.sleep(5000);
			n1Proceso.destroyForcibly();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	}


