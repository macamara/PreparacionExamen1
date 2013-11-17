package p2.Concurrencia.ProductorConsumidor;

public class Consumidor extends Thread{

	private Buffer buffer;

	public Consumidor(Buffer buffer){
		this.buffer=buffer;
	}
	
	public void run(){
		while(true){
			try {
				buffer.Quita();
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
