package ejemplo;

import java.util.List;

public interface IBusqueda {

	public boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino);
	
}
