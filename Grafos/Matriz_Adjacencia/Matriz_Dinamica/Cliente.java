package matrizAdj;

public class Cliente {

	public static void main(String[] args) {
	
		Vertice[] v = new Vertice[5]; 
		Grafo g = new Grafo();
		
		v[0] = g.criarVertice("v0");
		v[1] = g.criarVertice("v1");
		v[2] = g.criarVertice("v2");
		v[3] = g.criarVertice("v3");
		v[4] = g.criarVertice("v4");
		
		System.out.println(v[0].getValor());
		

		
		

	}

}
