package ConWait;

public class Dato {

	private String dato;
	private boolean hayDatoNuevo = false;

	public Dato(String d) {
		dato = d;
	}

	/**
	 * consumidor
	 * @return
	 */
	public synchronized String getDato() {

		String resultado = "";
		while (!hayDatoNuevo) {

			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		resultado=dato;
		hayDatoNuevo = false;
		notifyAll();
		return resultado;
	}

	/**
	 * productor..
	 * @param d
	 */
	public synchronized void meterNuevoDato(String d) {
		while (hayDatoNuevo) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dato = d;
		hayDatoNuevo = true;
		notifyAll();
	}

}
