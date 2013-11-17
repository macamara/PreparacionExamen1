package p1.Concurrencia.EscritoresLectores;

import java.util.ArrayList;
import java.util.List;

public class Control {
	
	private List<Object> datos;

	public Control(){
		this.datos = new ArrayList <Object>();
	}

	public synchronized Object leer(){
		return datos.get((int) (Math.random()*datos.size()+0));
	}
	
	public synchronized void escribirDato(Object nuevoDato){
		int posAleatoria = (int) (Math.random()*datos.size()+0);
		datos.set(posAleatoria, nuevoDato);
	}
}
