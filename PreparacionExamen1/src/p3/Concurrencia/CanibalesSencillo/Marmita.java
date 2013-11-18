package p3.Concurrencia.CanibalesSencillo;

public class Marmita {

	private int numeroRaciones;					//Para que haya aleatoriedad a la hora de comer, dejo este int como público (la comprobación de si
	public int racionesRestantes;				//hay o no raciones la hago desde los métodos run de cada uno de los caníbales (no hay cerrojos bloqueados).
												
	public Marmita(int numeroRaciones){
		this.numeroRaciones=numeroRaciones;
		racionesRestantes=numeroRaciones;
	}
	
	public synchronized void comer() throws InterruptedException{
		racionesRestantes--;					//Come un canibal elegido aleatoriamente entre los que estaban esperando.
	}
	public synchronized void rellenar() throws InterruptedException{
		while(racionesRestantes>0) wait();		//Al despertar al cocinero desde el run de la clase Canibal, se llena la marmita y
		racionesRestantes=numeroRaciones;		//despierto a todos los caníbales que estuviesen esperando (no tienen ningún cerrojo bloqueado,
		notifyAll();							//luego hay aleatoriedad a la hora de elegir quién come primero.
	}											
}
