package p2.Concurrencia.ProductorConsumidor;

public class Buffer {

	private int[] buffer;
	private int posLlenas;

	public Buffer(int tamanoBuffer){
		this.buffer=new int[tamanoBuffer];
		posLlenas=0;
	}
	
	public synchronized int Quita() throws InterruptedException{
		int dato=(Integer)null;
		while(posLlenas==0){
			wait();
		}
		for(int i=0;i<buffer.length;i++){
			if(buffer[i]!=(Integer)null){
				dato=buffer[i];
				buffer[i]=(Integer)null;
				posLlenas--;
				break;
			}
		}
		notifyAll();
		return dato;
	}
	
	public synchronized void Pon(int dato) throws InterruptedException{
		while (posLlenas==buffer.length){
			wait();
		}
		for(int i=0;i<buffer.length;i++){
			if(buffer[i]==(Integer)null){
				buffer[i]=dato;
				posLlenas++;
				break;
			}
		}
		notifyAll();
	}
}
