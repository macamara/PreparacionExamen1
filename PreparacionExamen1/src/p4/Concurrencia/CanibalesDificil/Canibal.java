package p4.Concurrencia.CanibalesDificil;

public class Canibal extends Thread{

	private Marmita marmita;

	public Canibal (Marmita marmita){
		this.marmita=marmita;
	}
	
	public void run(){
		while (true){
			try {
				marmita.comer();
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
