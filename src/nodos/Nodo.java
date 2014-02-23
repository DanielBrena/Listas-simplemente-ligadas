package nodos;

public class Nodo <T>{
	//Valor
	private T valor;
	//Liga
	private Nodo<T> liga;
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public Nodo<T> getLiga() {
		return liga;
	}
	public void setLiga(Nodo<T> liga) {
		this.liga = liga;
	}
	
	
}
