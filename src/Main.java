import listasSimplementeLigadas.ListaSimplementeligada;


public class Main {
	
	public static void main(String[] args){
		
		listaEnteros();
		listaCadena();
	}
	
	public static void listaCadena(){
		ListaSimplementeligada<String> listaCadena = new ListaSimplementeligada<String>();
		listaCadena.insertaInicio("Daniel");
		listaCadena.insertaInicio("Mario");
		listaCadena.insertaInicio("Jaime");
		listaCadena.insertaFinal("Guillermina");
		
		listaCadena.recorreRecursivo(listaCadena.getInicio());
	}
	
	public static void listaEnteros(){
		
		ListaSimplementeligada<Integer> listaEnteros = new ListaSimplementeligada<Integer>();
		listaEnteros.insertaInicio(1);
		listaEnteros.insertaInicio(2);
		listaEnteros.insertaFinal(0);
		listaEnteros.insertaInicio(3);
		
		
		
		System.out.println(listaEnteros.recorreIteractivo());
	}
	
}
