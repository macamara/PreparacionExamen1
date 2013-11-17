package p3.Concurrencia.CanibalesSencillo;

public class Cocinero extends Thread{

	private Marmita marmita;

	public Cocinero(Marmita marmita){
		this.marmita=marmita;
	}
	
	public void run(){
		while(true){
			try {
				wait();
				marmita.rellenar();
				notifyAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
