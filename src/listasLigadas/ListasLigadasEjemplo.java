package listasLigadas;

import nodos.Nodo;

public class ListasLigadasEjemplo {
	
	private static Nodo p = null;
	
	
	public static void main(String[] args){
		//Definir el inicio de la lista
		
		ListaLigada<String> lista = new ListaLigada<>();
		lista.insertarFinal("1");
		lista.insertarFinal("2");
		lista.insertarFinal("3");
		
		lista.mostrarLista();
		//System.out.println("----");
		//ListaLigada<String> lista2 = new ListaLigada<>();
		
		//lista.invierteLista(lista).mostrarLista();
		System.out.println("-----");
		//System.out.println(lista.buscar("3"));
		lista.insertarAntesDeX("0", "1");
		lista.mostrarLista();
		lista.insertarDespuesDeX("4", "3");
		System.out.println("-----");
		lista.mostrarLista();
		System.out.println("-----");
		lista.eliminarInicio();
		lista.mostrarLista();
		System.out.println("-----");
		lista.eliminarUltimo();
		lista.mostrarLista();
		
	}
	
	
}
