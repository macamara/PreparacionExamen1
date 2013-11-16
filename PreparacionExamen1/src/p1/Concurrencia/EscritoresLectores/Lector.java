package p1.Concurrencia.EscritoresLectores;

public class Lector extends Thread{

	private Control monitor;

	public Lector (Control monitor){
		this.monitor=monitor;
	}
	
	public void run(){
		while(true){
			try {
				monitor.leer();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
