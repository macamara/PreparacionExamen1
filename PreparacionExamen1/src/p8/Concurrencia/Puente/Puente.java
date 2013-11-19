package p8.Concurrencia.Puente;

public class Puente {

	private boolean ocupado=false;
	private int esperaNorte=0;
	private int esperaSur=0;
	private boolean ambulancia=false;
	
	public synchronized void entrarPuenteSur() throws InterruptedException{
		while(ocupado || ambulancia || esperaNorte>esperaSur){		//El vehículo se añade a la lista de espera si el puente está ocupado, está esperando
			esperaSur++;											//una ambulancia o en la otra entrada hay más coches esperando.
			wait();
		}
		ocupado=true;												//El vehículo ocupa el puente
		if(esperaSur>0){											//Dicho vehículo sale de la lista de espera.
			esperaSur--;
		}
		notifyAll();												//Aviso de que ha salido un coche de la lista de espera y ha ocupado el puente.
	}
	
	public synchronized void entrarPuenteNorte() throws InterruptedException{
		while(ocupado || ambulancia || esperaSur>esperaNorte){		//El vehículo se añade a la lista de espera si el puente está ocupado, está esperando
			esperaNorte++;											//una ambulancia o en la otra entrada hay más coches esperando.
			wait();
		}
		ocupado=true;												//El vehículo ocupa el puente
		if(esperaNorte>0){											//Dicho vehículo sale de la lista de espera.
			esperaNorte--;
		}
		notifyAll();												//Aviso de que ha salido un coche de la lista de espera y ha ocupado el puente.
	}
	
	public void entrarAmbulancia() throws InterruptedException{
		while(ocupado){			//Si el puente no está ocupado, directamente paso. Si no, aviso de que quiere pasar y espero a que el puente
			ambulancia=true;	//no esté ocupado.
			wait();
		}
		ocupado=true;			//Ambulancia pasa al puente.
		ambulancia=false;		//Ya no hay ambulancia esperando.
		notifyAll();			//Aviso de que ya no hay ninguna ambulancia esperando.	
	}
	
	public synchronized void salirPuente(){
		ocupado=false;			//Desocupo el puente.
		notifyAll();			//Aviso de que el puente no está ocupado.
	}
}
