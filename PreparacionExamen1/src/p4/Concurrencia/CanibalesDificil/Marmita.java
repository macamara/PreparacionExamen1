package p4.Concurrencia.CanibalesDificil;

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
		notifyAll();
	}
	public synchronized void rellenar() throws InterruptedException{
		while(racionesRestantes>0){
			wait();
		}
		racionesRestantes=numeroRaciones;
		notifyAll();
	}
}
