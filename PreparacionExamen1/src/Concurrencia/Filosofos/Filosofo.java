package Concurrencia.Filosofos;

public class Filosofo extends Thread{

	private int id;
	private Mesa mesa;

	public Filosofo (int id, Mesa mesa){
		this.id=id;
		this.mesa=mesa;
	}
	
	public void run(){
		while (true){
			try {
				piensa();
				mesa.cogePalillo(id);
				come();
				mesa.dejaPalillo(id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void come() throws InterruptedException{
		sleep(500);
	}
	
	public void piensa() throws InterruptedException{
		sleep(2000);
	}
}
