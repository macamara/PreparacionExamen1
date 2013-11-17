package Concurrencia.Filosofos;

public class Palillo {
	
	private boolean ocupado;
	
	public Palillo(int numeroPalillos){
		ocupado=false;
	}
	
	public void cogePalillo() throws InterruptedException{
		while(ocupado){
			wait();
		}
		ocupado=true;
	}
	
	public void dejaPalillo(){
		ocupado=false;
		notifyAll();
	}
	
}
