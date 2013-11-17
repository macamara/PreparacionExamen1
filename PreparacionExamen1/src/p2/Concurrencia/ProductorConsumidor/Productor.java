package p2.Concurrencia.ProductorConsumidor;

public class Productor extends Thread{

	private Buffer buffer;

	public Productor(Buffer buffer){
		this.buffer=buffer;
	}
	
	public void run(){
		while(true){
			try {
				buffer.Pon((int)(Math.random()));
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
