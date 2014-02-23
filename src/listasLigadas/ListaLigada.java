package listasLigadas;

import nodos.Nodo;

public class ListaLigada <T> {
	
	private Nodo<T> p = null;
	
	
	public  void insertarInicio(T obj){
		Nodo<T> t = new Nodo();
		t.setValor(obj);
		t.setLiga(p);
		p = t;
	}
	
	public void insertarFinal(T obj){
		// Variable auxiliar
		Nodo<T> q = p; //EL nodo auxiliar
		Nodo<T> t = new Nodo<>(); //El nuevo nodo a insertar
		t.setValor(obj);
		t.setLiga(null);
		
		if(p == null){
			p = t;
		}else{
			//ciclo que recorre la lista
			while(q.getLiga() != null){
				q = q.getLiga();
			}
			q.setLiga(t);//Asignamos a la liga del ultimo
		}
	}
	
	
	public  void mostrarLista(){
		//Variable auxiliar
		Nodo<T> q = p;
		
		//Cliclo para recorrer lista
		while(q != null){
			System.out.println(q.getValor());
			q = q.getLiga();
		}
	}
	
	public ListaLigada<T> invierteLista(ListaLigada<T> lista){
		ListaLigada<T> aux = lista;
		ListaLigada<T> nueva = new ListaLigada<>();
		
		//Nodo<T> q = aux.getP();
		Nodo<T>	q = p;
		
		while( q != null){
			nueva.insertarInicio(q.getValor());
			q = q.getLiga();
			
		}
		
		
		
		return nueva;
	}
	
	public boolean buscar(T dato){
		boolean resultado = false;
		Nodo<T> q = p;
		
		while(q != null){
			if(q.getValor().equals(dato)){
				resultado = true;
			}
			q = q.getLiga();
		}
		return resultado;
		
	}

	public Nodo<T> getP() {
		return p;
	}

	public void setP(Nodo<T> p) {
		this.p = p;
	}
	
	
}
