package ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	private String 		nombre;
	private List<IArco>	arcos = new ArrayList<>();
	
	public Nodo() { }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarArco(IArco arco) {
		arcos.add(arco);
	}

	public List<IArco> getArcos() {
		return arcos;
	}
	
	public List<Nodo> getNodosAdyacentes() {
		List<Nodo> nodos = new ArrayList<>();
		
		// por cada arco donde el nodo es origen
		for (IArco arco : arcos) {
			// si el arco no es reflexivo
			if (arco.getDestino() != this)
				// agrega el nodo destino a la lista 
				// de nodos adyacentes
				nodos.add(arco.getDestino());
		}
		
		// retorna la lista de nodos adyacentes
		return nodos;
	}
	
}
