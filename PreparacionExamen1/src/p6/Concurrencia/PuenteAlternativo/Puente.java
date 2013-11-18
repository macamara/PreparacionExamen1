package p6.Concurrencia.PuenteAlternativo;

public class Puente {

	private boolean ocupado;
	private enum vehiculoEnEspera {NORTE,SUR};
	private vehiculoEnEspera espera;

	public Puente(){
		ocupado=false;
		espera=vehiculoEnEspera.NORTE;
	}
	
	public synchronized void entrarPuenteSur() throws InterruptedException{
		while(ocupado || espera==vehiculoEnEspera.NORTE){
			wait();
		}
		ocupado=true;
		espera=vehiculoEnEspera.NORTE;
		notifyAll();
	}
	
	public synchronized void entrarPuenteNorte() throws InterruptedException{
		while(ocupado|| espera==vehiculoEnEspera.SUR){
			wait();
		}
		ocupado=true;
		espera=vehiculoEnEspera.SUR;
		notifyAll();
	}
	
	public synchronized void salirPuente(){
		ocupado=false;
		notifyAll();
	}
}
