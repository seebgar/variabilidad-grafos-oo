package ejemplo;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

@Alternative
public class GrafoDirigidoPeso extends Grafo {
	
	List<ArcoPeso> arcos = new ArrayList<>();
	
	public GrafoDirigidoPeso() { 
	}
	
	@Override
	public void addArco(String origen, String destino, int peso) throws Exception {
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino, peso);
		
	}
	
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso)
	{
		ArcoPeso arco = new ArcoPeso();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}

}
