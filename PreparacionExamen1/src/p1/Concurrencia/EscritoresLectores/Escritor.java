package p1.Concurrencia.EscritoresLectores;

public class Escritor extends Thread{
	
	private Control monitor;

	public Escritor (Control monitor){
		this.monitor=monitor;
	}
	
	public void run(){
		while(true){
			try {
				Object nuevoDato=new Object();
				monitor.escribirDato(nuevoDato);
				Thread.sleep(500);
				monitor.leer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
