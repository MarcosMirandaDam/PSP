
public class Main {

	public static void main(String[] args) {

		Dato midato = new Dato("Dato");

		Productor p = new Productor(midato, "p1");
		Consumidor c1 = new Consumidor(midato, "c1");
		Consumidor c2 = new Consumidor(midato, "c2");

		p.start();
		c1.start();
		c2.start();

	}

}
