package listasLigadas;

import nodos.Nodo;

public class ListaLigada <T> {
	
	private Nodo<T> p = null;
	
	/**
	 * Inserta al inicio de una lista
	 * @param obj Dato que se ingresara
	 */
	public  void insertarInicio(T obj){
		Nodo<T> t = new Nodo();
		t.setValor(obj);
		t.setLiga(p);
		p = t;
	}
	
	/**
	 * Inserta al final de la lista
	 * @param obj
	 */
	
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
	
	/**
	 * Muestra en consola la lista completa
	 */
	public  void mostrarLista(){
		//Variable auxiliar
		Nodo<T> q = p;
		
		//Cliclo para recorrer lista
		while(q != null){
			System.out.println(q.getValor());
			q = q.getLiga();
		}
	}
	
	/**
	 * Invierte de orden una lista
	 * @param lista La lista que se va a invertir
	 * @return Una lista
	 */
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
	/**
	 * Busca un dato dentro de la lista
	 * @param dato Dato a buscar dentro de la lista
	 * @return boolean 
	 */
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
	
	
	
	public void insertarAntesDeX(T dato, T x){
		Nodo<T> q = this.p;
		Nodo<T> t = null;
		boolean bandera = true;
		while(q.getValor()  != x && bandera){
			if(q.getLiga() != null){
					t = q;
					q = q.getLiga();
			}else{
				bandera = false;
			}
			
		}
		if(bandera){
			Nodo<T> nuevo = new Nodo<T>();
			nuevo.setValor(dato);
			if(this.p == q){
				nuevo.setLiga(p);
				p = nuevo;
			}else{
				t.setLiga(nuevo);
				nuevo.setLiga(q);
				
			}
		}else{
			System.out.println("Nodo no esta bajo referencia");
		}
	}

	public Nodo<T> getP() {
		return p;
	}

	public void setP(Nodo<T> p) {
		this.p = p;
	}
	
	
}
