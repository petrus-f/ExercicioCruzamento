package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Cruzamento {
	
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 1; i <= 4; i++) {
			ThreadCruzamento t = new ThreadCruzamento(i, semaforo);
			t.start();
		}
	}
}
