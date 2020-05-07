package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
	String direcao;
	Semaphore semaforo;
	int carro;
	public ThreadCruzamento(int carro, Semaphore semaforo) {
		this.semaforo = semaforo;
		this.carro = carro;
		
		switch(carro){
		case 1:
			direcao = "N -> S";
			break;
		case 2:
			direcao = "O -> L";
			break;
		case 3:
			direcao = "S -> N";
			break;
		case 4:
			direcao = "L -> O";
			break;
		}
		
	}
		
	@Override
	public void run() {
		System.out.println("#"+ carro + " está esperando para atravessar");
		try {
			semaforo.acquire();
			cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	
	}

	private void cruzar() {
		System.out.println("#"+ carro + " está cruzando no sentido " + direcao);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#"+ carro + " atravessou");
	}
}
