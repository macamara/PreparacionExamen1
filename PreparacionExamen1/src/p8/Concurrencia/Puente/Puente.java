package p8.Concurrencia.Puente;

public class Puente {

	private boolean ocupado=false;
	private int esperaNorte=0;
	private int esperaSur=0;
	private boolean ambulancia=false;
	
	public synchronized void entrarPuenteSur() throws InterruptedException{
		while(ocupado || ambulancia || esperaNorte>esperaSur){		//El veh�culo se a�ade a la lista de espera si el puente est� ocupado, est� esperando
			esperaSur++;											//una ambulancia o en la otra entrada hay m�s coches esperando.
			wait();
		}
		ocupado=true;												//El veh�culo ocupa el puente
		if(esperaSur>0){											//Dicho veh�culo sale de la lista de espera.
			esperaSur--;
		}
		notifyAll();												//Aviso de que ha salido un coche de la lista de espera y ha ocupado el puente.
	}
	
	public synchronized void entrarPuenteNorte() throws InterruptedException{
		while(ocupado || ambulancia || esperaSur>esperaNorte){		//El veh�culo se a�ade a la lista de espera si el puente est� ocupado, est� esperando
			esperaNorte++;											//una ambulancia o en la otra entrada hay m�s coches esperando.
			wait();
		}
		ocupado=true;												//El veh�culo ocupa el puente
		if(esperaNorte>0){											//Dicho veh�culo sale de la lista de espera.
			esperaNorte--;
		}
		notifyAll();												//Aviso de que ha salido un coche de la lista de espera y ha ocupado el puente.
	}
	
	public void entrarAmbulancia() throws InterruptedException{
		while(ocupado){			//Si el puente no est� ocupado, directamente paso. Si no, aviso de que quiere pasar y espero a que el puente
			ambulancia=true;	//no est� ocupado.
			wait();
		}
		ocupado=true;			//Ambulancia pasa al puente.
		ambulancia=false;		//Ya no hay ambulancia esperando.
		notifyAll();			//Aviso de que ya no hay ninguna ambulancia esperando.	
	}
	
	public synchronized void salirPuente(){
		ocupado=false;			//Desocupo el puente.
		notifyAll();			//Aviso de que el puente no est� ocupado.
	}
}
