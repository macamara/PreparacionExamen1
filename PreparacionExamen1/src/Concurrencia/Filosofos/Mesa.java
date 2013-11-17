package Concurrencia.Filosofos;

public class Mesa {

	Palillo palillos[];
	
	public Mesa(int numeroFilosofos){
		this.palillos=new Palillo [numeroFilosofos];
	}
	
	public synchronized void cogePalillo(int id) throws InterruptedException{
		palillos[id].cogePalillo();
		palillos[id+1].cogePalillo();
	}
	
	public synchronized void dejaPalillo(int id) throws InterruptedException{
		palillos[id].dejaPalillo();
		palillos[id+1].dejaPalillo();
	}
}
