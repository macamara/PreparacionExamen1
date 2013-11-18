package p4.Concurrencia.CanibalesDificil;

public class Marmita {

	private int numeroRaciones;
	private int racionesRestantes;

	public Marmita(int numeroRaciones){
		this.numeroRaciones=numeroRaciones;
		racionesRestantes=numeroRaciones;
	}
	
	public synchronized void comer() throws InterruptedException{
		while(racionesRestantes==0){		//Según el problema, lo primero que hace el caníbal es mirar si hay comida.
			notifyAll();					//Si no hay comida, despierto la hebra del cocinero y espero a que termine.
			wait();
		}
		racionesRestantes--;				//Como la hebra que estaba esperando está esperando desde un método sincronizado, cuando haya un notify
		notifyAll();						//y haya comida, será la primera en comer (ya que tenía el cerrojo bloqueado).
	}
	public synchronized void rellenar() throws InterruptedException{
		while(racionesRestantes>0){			//Mientras que la marmita tenga comida, el cocinero espera. Si llega un notify del caníbal (no hay comida)
			wait();							//se despierta la hebra, comprueba que no hay comida y llena la marmita de nuevo.
		}
		racionesRestantes=numeroRaciones;
		notifyAll();						//Una vez se llena la marmita, notifico a la hebra que había llamado al cocinero de que ya hay comida.
	}
}
