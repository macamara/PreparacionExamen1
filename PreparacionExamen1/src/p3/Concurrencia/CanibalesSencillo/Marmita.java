package p3.Concurrencia.CanibalesSencillo;

public class Marmita {

	private int numeroRaciones;					//Para que haya aleatoriedad a la hora de comer, dejo este int como p�blico (la comprobaci�n de si
	public int racionesRestantes;				//hay o no raciones la hago desde los m�todos run de cada uno de los can�bales (no hay cerrojos bloqueados).
												
	public Marmita(int numeroRaciones){
		this.numeroRaciones=numeroRaciones;
		racionesRestantes=numeroRaciones;
	}
	
	public synchronized void comer() throws InterruptedException{
		racionesRestantes--;					//Come un canibal elegido aleatoriamente entre los que estaban esperando.
	}
	public synchronized void rellenar() throws InterruptedException{
		while(racionesRestantes>0) wait();		//Al despertar al cocinero desde el run de la clase Canibal, se llena la marmita y
		racionesRestantes=numeroRaciones;		//despierto a todos los can�bales que estuviesen esperando (no tienen ning�n cerrojo bloqueado,
		notifyAll();							//luego hay aleatoriedad a la hora de elegir qui�n come primero.
	}											
}
