public class Cliente {

	public static void main(String[] args) {

		Grafo grafo = new Grafo();

		Vertice v0 = grafo.criarVertice("v0");
		Vertice v1 = grafo.criarVertice("v1");
		Vertice v2 = grafo.criarVertice("v2");
		Vertice v3 = grafo.criarVertice("v3");
		Vertice v4 = grafo.criarVertice("v4");
		Vertice v5 = grafo.criarVertice("v5");
		Vertice v6 = grafo.criarVertice("v6");
		Vertice v7 = grafo.criarVertice("v7");
		Vertice v8 = grafo.criarVertice("v8");
		Vertice v9 = grafo.criarVertice("v9");
		Vertice v10 = grafo.criarVertice("v10");

		grafo.criarAresta(v1, v2, 5);
		grafo.criarAresta(v2, v3, 2);
		grafo.criarAresta(v2, v4, 10);
		grafo.criarAresta(v4, v5, 1);
		grafo.criarAresta(v5, v4, 5);

		//grafo.caminhadaLargura();
		//System.out.println("---");
		//grafo.caminhadaProfundidade();
		//System.out.println("---");
		grafo.dijkstra();
		//System.out.println("---");
		//grafo.exibir();

	}

}
