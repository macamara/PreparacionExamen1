package p4.Concurrencia.CanibalesDificil;

public class Marmita {

	private int numeroRaciones;
	private int racionesRestantes;

	public Marmita(int numeroRaciones){
		this.numeroRaciones=numeroRaciones;
		racionesRestantes=numeroRaciones;
	}
	
	public synchronized void comer() throws InterruptedException{
		while(racionesRestantes==0){		//Seg�n el problema, lo primero que hace el can�bal es mirar si hay comida.
			notifyAll();					//Si no hay comida, despierto la hebra del cocinero y espero a que termine.
			wait();
		}
		racionesRestantes--;				//Como la hebra que estaba esperando est� esperando desde un m�todo sincronizado, cuando haya un notify
		notifyAll();						//y haya comida, ser� la primera en comer (ya que ten�a el cerrojo bloqueado).
	}
	public synchronized void rellenar() throws InterruptedException{
		while(racionesRestantes>0){			//Mientras que la marmita tenga comida, el cocinero espera. Si llega un notify del can�bal (no hay comida)
			wait();							//se despierta la hebra, comprueba que no hay comida y llena la marmita de nuevo.
		}
		racionesRestantes=numeroRaciones;
		notifyAll();						//Una vez se llena la marmita, notifico a la hebra que hab�a llamado al cocinero de que ya hay comida.
	}
}
