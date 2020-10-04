package ejemplo;

import java.util.List;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Ejemplo {

	public static void main(String[] args) {

		try {

			// Patron de estrategia
			SeContainer container = SeContainerInitializer.newInstance().initialize();
			IGrafo g = container.select(Grafo.class).get();
			
			System.out.println("*** ");
			System.out.println(g.getClass().getName());
			System.out.println("*** ");
			

			g.addNodo("A");
			g.addNodo("B");
			g.addNodo("C");

			if (g.getClass().getName().equalsIgnoreCase("ejemplo.GrafoNormal")) {
				g.addArco("A", "C");
				g.addArco("B", "C");
				g.addArco("A", "B");
			} else {
				g.addArco("A", "B", 1);
				g.addArco("B", "C", 1);
				g.addArco("A", "C", 2);
			}
		

			List<Nodo> camino = g.buscarRuta("A", "C");

			if (camino == null) {
				System.out.println("Camino A -> C no encontrado");
			} else {
				System.out.println("Camino A -> C encontrado");
				for (Nodo nodo : camino) {
					System.out.println(nodo.getNombre());
				}
			}

			
			
			IGrafo h = container.select(Grafo.class).get();

			h.addNodo("A");
			h.addNodo("B");
			h.addNodo("C");
			h.addNodo("D");
			h.addNodo("E");

			if (h.getClass().getName().equalsIgnoreCase("ejemplo.GrafoNormal")) {
				h.addArco("A", "B");
				h.addArco("B", "C");
				h.addArco("C", "D");
				h.addArco("E", "D");
				h.addArco("A", "C");
			} else {
				h.addArco("A", "B", 1);
				h.addArco("B", "C", 1);
				h.addArco("C", "D", 1);
				h.addArco("E", "D", 2);
				h.addArco("A", "C", 3);
				
			}
			

			List<Nodo> caminodos = h.buscarRuta("A", "E");

			if (caminodos == null) {
				System.out.println("Camino A -> E no encontrado");
			} else {
				System.out.println("Camino A -> E encontrado");
				for (Nodo nodo : caminodos) {
					System.out.println(nodo.getNombre());
				}
			}
			System.out.println();
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
