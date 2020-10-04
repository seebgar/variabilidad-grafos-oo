package ejemplo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.enterprise.inject.Alternative;

@Alternative
public class DFS implements IBusqueda {

	@Override
	public boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
		System.out.println("DFS");
		// agrega el origen
		nodosRuta.add(nodoOrigen);

		// origen y destino son el mismo ?
		if (nodoOrigen.getNombre().equals(nodoDestino.getNombre())) {
			return true;
		}

		// si no son el mismo, revise las rutas usando una pila
		Stack<Nodo> pilaDeNodos = new Stack<>();
		ArrayList<Nodo> nodosVisitados = new ArrayList<>();

		pilaDeNodos.add(nodoOrigen);

		while (!pilaDeNodos.isEmpty()) {
			Nodo actual = pilaDeNodos.pop();

			// ignore los nodos ya visitados
			if (nodosVisitados.contains(actual))
				continue;

			// es el nodo que estamos buscando ?
			if (actual.equals(nodoDestino)) {
				nodosRuta.addAll(pilaDeNodos);
				nodosRuta.add(nodoDestino);
				return true;
			} else {
				// siga buscando en las rutas no visitadas
				nodosVisitados.add(actual);
				for (Nodo nodo : actual.getNodosAdyacentes()) {
					if (!pilaDeNodos.contains(nodo))
						pilaDeNodos.add(nodo);
				}
			}
		}
		return false;
	}

}
