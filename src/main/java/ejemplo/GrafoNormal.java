package ejemplo;

import javax.enterprise.inject.Alternative;

@Alternative
public class GrafoNormal extends Grafo {

	public GrafoNormal() { 
	}

	@Override
	public void addArco(String origen, String destino, int peso) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("El grafo no tiene pesos");
	}
	
}
