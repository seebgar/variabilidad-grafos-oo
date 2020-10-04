package ejemplo;

import java.util.List;

public interface IGrafo {
	
	public void addNodo(String nombre);
	
	public void addArco(String origen, String destino) throws Exception;
	
	public void addArco(String origen, String destino, int peso) throws Exception;

	public void addArco(Nodo nodoOrigen, Nodo nodoDestino);

	public Nodo buscarNodo(String nombre);
	
	public boolean existeRuta(String origen, String destino) throws Exception;
	
	public List<Nodo> buscarRuta(String origen, String destino) throws Exception;
}
