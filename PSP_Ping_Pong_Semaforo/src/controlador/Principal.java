package controlador;

import java.util.concurrent.Semaphore;

import modelo.PingPong;

public class Principal {

	public static void main(String[] args) {
	
		Semaphore pelota=new Semaphore(2);
		
		PingPong j1=new PingPong("Ping",pelota);
		PingPong j2=new PingPong("Pong",pelota);

		
		j1.start();
		j2.start();
	}

}
