package p3.Concurrencia.CanibalesSencillo;

public class Marmita {

	private int numeroRaciones;
	private int racionesRestantes;

	public Marmita(int numeroRaciones){
		this.numeroRaciones=numeroRaciones;
		racionesRestantes=numeroRaciones;
	}
	
	public synchronized void comer() throws InterruptedException{
		while(racionesRestantes==0){
			notifyAll();
			wait();
		}
		racionesRestantes--;
	}
	public synchronized void rellenar(){
		racionesRestantes=numeroRaciones;
	}
}
