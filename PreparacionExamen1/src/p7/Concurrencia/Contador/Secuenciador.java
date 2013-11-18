package p7.Concurrencia.Contador;

public class Secuenciador {

	private int numero=0;
	
	public int siguiente(){
		numero++;
		notifyAll();
		return numero;
	}
	
	public void esperaPar() throws InterruptedException{
		while(numero%2!=0){
			wait();
		}
	}
	
	public void esperaImpar() throws InterruptedException{
		while(numero%2==0){
			wait();
		}
	}
}
