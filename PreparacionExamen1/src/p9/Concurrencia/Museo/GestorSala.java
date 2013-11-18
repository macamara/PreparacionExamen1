package p9.Concurrencia.Museo;

public class GestorSala {

	private int nMaximo;
	private int tUmbral=30;
	private int nPersonas;
	private int temperaturaActual;
	public boolean jubilado=false;		//En el momento en que se abre la sala, no hay jubilados.
	
	public GestorSala(){
		nMaximo=50;						//Pongo el aforo m�ximo a 50 personas.
		nPersonas=0;
		temperaturaActual=20;			//Supongo una temperatura de apertura a 20�C.
	}
	
	public synchronized void entrarSala() throws InterruptedException{
		while(nPersonas==nMaximo || jubilado==true){		//Mientras que el aforo est� completo, o haya jubilados que quieran pasar, se espera.
			wait();
		}
		nPersonas++;										//Entra la persona.
	}
	
	public synchronized void entrarSalaJubilado() throws InterruptedException{
		while(nPersonas==nMaximo){							//Mientras el aforo est� completo, se espera. Cuando haya hueco, ser� el primero en pasar.
			wait();											//El hecho de que la persona est� jubilada lo debemos indicar desde la llamada al m�todo,
		}													//es decir, primero aviso que hay un jubilado esperando (boolean a true, ver clase Persona).
		nPersonas++;										//Entra el jubilado.
		jubilado=false;										//El jubilado ya ha entrado, luego ponemos el booleano a false.
	}
	
	public synchronized void salirSala(){
		nPersonas--;										//Sacamos una persona del museo.
		notifyAll();										//Avisamos al resto de hebras de que hay hueco libre.
	}
	
	public synchronized void notificarTemperatura(int temperatura){
		temperaturaActual=temperatura;						//Mido la temperatura.
		if(temperaturaActual>tUmbral){
			nMaximo=35;										//Si la temperatura sobrepasa el umbral, bajo el aforo m�ximo a 35 personas.
		}else {												//Si la temperatura ha bajado de la temperatura umbral, elevo el aforo a 50 personas.
			nMaximo=50;
		}
	}
}
