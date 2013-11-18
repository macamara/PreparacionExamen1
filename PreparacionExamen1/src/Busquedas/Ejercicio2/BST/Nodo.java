package Busquedas.Ejercicio2.BST;

public class Nodo {
	
	private int llave;
	private String val;
	private Nodo izq;
	private Nodo der;

	public Nodo(int llave, String val, Nodo izq, Nodo der){
		this.llave=llave;
		this.val=val;
		this.izq=izq;
		this.der=der;
	}
	
	public String getString(int llave, Nodo raiz){
		if (raiz==null){
			return "No se ha encontrado coincidencia";
		}else if(llave==raiz.llave){
			return raiz.val;
		}else if(llave<raiz.llave){
			return getString(llave,raiz.izq);
		}else{
			return getString(llave,raiz.der);
		}
	}
	
	public int profundidadBST(Nodo raiz){
		if(raiz==null){
			return 0;
		} else{
			return 1 + Math.max(profundidadBST(raiz.der), profundidadBST(raiz.izq));
		}
	}
}
