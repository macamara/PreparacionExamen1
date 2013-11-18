package p9.Concurrencia.Museo;

public class Persona extends Thread{

	private int edad;
	private GestorSala sala;

	public Persona (int edad, GestorSala sala){
		this.edad=edad;
		this.sala=sala;
	}
	
	public void run(){
		try {
			if(edad<67){
				sala.entrarSala();
			} else {
				sala.jubilado=true;	//Aquí es donde indico que la persona que quiere entrar es un jubilado (modifico el booleano de la clase GestorSala), obligando a otras personas a esperar.
				sala.entrarSalaJubilado();		//Una vez he avisado de que hay un jubilado esperando, le hago entrar al museo.
			}
			sleep(2000);						//Duermo la hebra un rato.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sala.salirSala();						//Saco a la persona de la sala.
	}
}
