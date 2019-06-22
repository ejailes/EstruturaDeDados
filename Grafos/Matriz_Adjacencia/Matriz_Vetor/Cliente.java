public class Cliente {

	public static void main(String[] args) {

		Grafo grafo = new Grafo();

		Vertice v0 = grafo.criarVertice("v0");
		Vertice v1 = grafo.criarVertice("v1");
		Vertice v2 = grafo.criarVertice("v2");

		grafo.criarAresta(v1, v0);
		grafo.criarAresta(v1, v2);

		grafo.exibir();

	}

}
