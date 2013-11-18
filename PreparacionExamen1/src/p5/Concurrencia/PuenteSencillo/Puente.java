package p5.Concurrencia.PuenteSencillo;

public class Puente {

	private boolean ocupado;
	
	public Puente (){
		ocupado=false;
	}
	
	public synchronized void entrarPuente() throws InterruptedException{
		while(ocupado){
			wait();
		}
		ocupado=true;
	}
	
	public synchronized void salirPuente(){
		ocupado=false;
		notifyAll();
	}
}
