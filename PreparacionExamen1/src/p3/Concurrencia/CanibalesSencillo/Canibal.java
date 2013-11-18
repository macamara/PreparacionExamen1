package p3.Concurrencia.CanibalesSencillo;

public class Canibal extends Thread{

	private Marmita marmita;

	public Canibal (Marmita marmita){
		this.marmita=marmita;
	}
	
	public void run(){
		while (true){
			try {
				if(marmita.racionesRestantes==0){
					notifyAll();					//Si no hay raciones en la marmita, despierto al cocinero.
				}									//Cuando llega el notify del cocinero (en la clase Marmita) se despiertan todas las hebras
				marmita.comer();					//que estuviesen esperando y, como no hay cerrojos bloqueados, come una cualquiera y el resto espera.
				sleep(1000);						
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
