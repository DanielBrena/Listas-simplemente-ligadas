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
	/**
	 * Metodo que divide una lista en dos
	 * @param num
	 */
	public void dividir(Integer num) {
        int cont = 0;
        Nodo<T> q = p;
        while (q != null) {
            q = q.getLiga();
            cont++;
        }
        q = p;
        int primeraParte = cont - cont / 2;
        cont = 0;
        if (num == 1) {
            while (cont != primeraParte) {
                System.out.println(q.getValor());
                q = q.getLiga();
                cont++;
            }
        } else {
            while (cont != primeraParte) {
                q = q.getLiga();
                cont++;
            }
            while (q != null) {
                System.out.println(q.getValor());
                q = q.getLiga();
            }
        }
    }
	/**
	 * Metodo que elimina duplicados
	 */
	
	public void eliminarDuplicados() {
        Nodo<T> q = p;
        Nodo<T> r;
        Nodo<T> s = q;
        boolean ban;
        while (q != null && s.getLiga() != null) {
            ban = false;
            r = q;
            s = q.getLiga();
            while (s.getValor() != q.getValor() && !ban) {
                if (s.getLiga() != null) {
                    r = s;
                    s = s.getLiga();
                } else {
                    ban = true;
                }
            }
            if (!ban) {
                if (s.getLiga() != null) {
                    s = s.getLiga();
                    r.setLiga(s);
                } else {
                    r.setLiga(null);
                }
            }
            q = q.getLiga();
        }
    }
	
	
	/**
	 * Meotodo que inserta un nodo dentro de la lista, tomando en cuenta
	 * que lo inserta antes de un valor dado.
	 * @param dato Nodo que se insertara dentro de la lista.
	 * @param x Valor que se buscara, para insertar un nuevo nodo
	 * antes de el.
	 */
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
	
	/**
	 * 
	 * Metodo que inserta un nodo dentro de una lista despue de un nodo seleccionado.
	 * @param dato Dato que sera agregado en la lista.
	 * @param x Dato que busdara para que despues, agregue otro nodo.
	 */
	public void insertarDespuesDeX(T dato, T x){
		Nodo<T> q = this.p;
		Nodo<T> t = new Nodo<T>();
		boolean bandera = true;
		while(q.getValor() !=  x && bandera){
			if(q.getLiga() != null){
				q = q.getLiga();
			}else{
				bandera = false;
			}
		}
		
		if(bandera){
			t.setValor(dato);
			t.setLiga(q.getLiga());
			q.setLiga(t);
			
		}else{
			System.out.println("El nodo no se encuentra en la lista");
		}
		
		
	}
	
	/**
	 * Metodo que elimina el nodo del inicio de
	 * la lista
	 */
	public void eliminarInicio(){
		Nodo<T> q = this.p;
		p = q.getLiga();
		
	}
	
	/**
	 * Metodo que elimina el ultimo nodo de la lista
	 * 
	 */
	public void eliminarUltimo(){
		Nodo<T> q = this.p;
		Nodo<T> t = new Nodo<T>();
		if(q.getLiga() == null){
			this.p = null;
		}else{
			while(q.getLiga() != null){
				t = q;
				q = q.getLiga();
			}
			t.setLiga(null);
		}
	}
	
	/**
	 * Metodo que elimina un nodo con informacion x
	 * @param x Informacion que se buscara dentro de la lista.
	 */
	public void eliminarX(T x){
		Nodo<T> q = this.p;
		Nodo<T> t = new Nodo<T>();
		boolean bandera = true;
		
		while(q.getValor() != x && bandera){
			if(q.getLiga() != null){
				t = q;
				q = q.getLiga();
			}else{
				bandera = false;
			}
		}
		if(!bandera){
			System.out.println("El elemento con esa informacion, no se encuentra");
		}else{
			if(q == this.p){
				p = q.getLiga();
			}else{
				t.setLiga(q.getLiga());
			}
		}
	}
	
	/**
	 * Metodo que elimina un nodo antes con  informacion X de la lista.
	 * @param x Informacion a buscar para eliminar un nodo anterior.
	 */
	public void eliminarAntesDeX(T x){
		Nodo<T> q = this.p;
		Nodo<T> t = new Nodo<T>();
		Nodo<T> r = new Nodo<T>();
		boolean bandera = true;
		if(this.p.getValor() == x){
			System.out.println("No hay valor que proceda de  que contenga X");
		}else{
			q = this.p;
			t = this.p;
			while(q.getValor() != x && bandera){
				if(q.getLiga() != null){
					r = t;
					t = q;
					q = q.getLiga();
				}else{
					bandera = false;
				}
				
			}
			if(!bandera){
				System.out.println("Elemento no se encuentra");
			}else{
				if(p.getLiga() == q){
					p = q;
				}else{
					r.setLiga(q);
				}
			}
			
		}
		
	}
	
	/**
	 * Metodo que buscara cierto dato dentro de la lista.
	 * @param x Dato que se buscara.
	 */
	public void busquedaDesordenada(T x){
		Nodo<T> q = this.p;
		while(q.getLiga() != null && q.getValor() != x){
			q = q.getLiga();
		}
		if(q == null){
			System.out.println("No se encontro el valor");
		}else{
			System.out.println("Se encontro el valor dentro de la lista");
		}
	}
	/**
	 * Metodo que busca ordenadamente, tomando en cuenta que esta ordenada ascendente
	 * 
	 * @param x Dato que se buscara dentro de la lista.
	 */
	public void busquedaOrdenada(T x){
		/*
		 * Metodo que funciona si son nodos del tipo entero
		Nodo<T> q = this.p;
		while(q != null && q.getValor() < x){
			q = q.getLiga();
		}
		if(q == null){
			System.out.println("No se encuentra en la lista");
		}else{
			System.out.println("Se encuentra en la lista");
		}*/
		
	}
	
	/**
	 * Metodo que nos realiza una busqueda recursiva-
	 * @param x Dato a buscar dentro de la lista ligada.
	 */
	public void busquedaRecursiva(T x){
		if(this.p != null){
			if(p.getValor() == x){
				System.out.println("Se encontro dentro de la lista");
			}else{
				
				p = p.getLiga();
				busquedaRecursiva(x);
			}
		}else{
			System.out.println("No se econtro dentro de la lista");
		}
	}
	public Nodo<T> getP() {
		return p;
	}

	public void setP(Nodo<T> p) {
		this.p = p;
	}
	
	
}
