
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Grafo {

	private List<Vertice> vertices;

	public Grafo() {

		this.vertices = new ArrayList<Vertice>();
	}

	public Vertice criarVertice(String v) {

		Vertice vertice = new Vertice(v);
		this.vertices.add(vertice);

		return vertice;

	}

	public void criarAresta(Vertice v_ini, Vertice v_fim, int peso) {

		/*
		 * Cria lista de adjac�ncia: esta fun��o cria um novo objeto Adjac�ncia (Aresta
		 * com peso), cada Adjac�ncia engloba e mantem a refer�ncia da respectiva
		 * v�rtice.
		 * 
		 */

		Adjacencia aresta = new Adjacencia(v_fim, peso);
		int indice = this.vertices.indexOf(v_ini);

		if (this.vertices.get(indice).getInicio() == null) {

			this.vertices.get(indice).setInicio(aresta);

		} else {

			// Get Vari�vel ponteiro pr�ximo da �ltima aresta
			Adjacencia ult = this.vertices.get(indice).getUltimo();

			// Set nova aresta(Adjacencia) no ponteiro pr�ximo da �ltima arestas
			// ponteiro da nova aresta criada � Null, at� que seja criada uma nova
			// aresta fazendo com que ponteiro aponte para pr�xima aresta.
			ult.setProx(aresta);

		}

		// Update ponteiro �ltima aresta
		this.vertices.get(indice).setUltimo(aresta);

	}

	public void exibir() {
		exibir(this.vertices.size());
	}

	private void exibir(int size) {

		for (int i = 0; i < size; i++) {

			System.out.print(this.vertices.get(i).getValor() + ": ");

			Adjacencia adj = this.vertices.get(i).getInicio();
			while (adj != null) {

				if (adj.getProx() != null) {

					System.out.print(adj.getVertice().getValor() + "(Peso:" + adj.getPeso() + ")" + ", ");

				} else {

					System.out.print(adj.getVertice().getValor() + "(Peso:" + adj.getPeso() + ")");
				}

				adj = adj.getProx();
			}

			System.out.println();
		}

	}

	public void caminhadaLargura() {

		this.getConexoes(this.vertices.size());

	}

	public void caminhadaProfundidade() {

		this.getConexoes(this.vertices.size());

	}

	private void getConexoes(int tamanho) {

		for (int i = 0; i < tamanho; i++) {

			System.out.println("Conex�es Vertice " + this.vertices.get(i).getValor() + ":");

			if (!this.vertices.get(i).getVisitado()) {

				buscaProfundidade(this.vertices.get(i));

			}

			for (int j = 0; j < tamanho; j++) {

				this.vertices.get(j).setVisitado(false);
			}

			System.out.println();
		}

	}

	public void pesquisaProfundidade(Vertice v) {

		if (!this.vertices.contains(v)) {

			System.err.print("Erro ao realizar opera��o: Pesquisa em Profundidade\n");

		} else {

			this.buscaProfundidade(v);
		}

	}

	// Busca em profundidade utilizando Stack(Pilha)
	private void buscaProfundidade(Vertice v) {

		Stack<Vertice> pilha = new Stack<Vertice>();

		v.setVisitado(true);
		pilha.add(v);

		while (!pilha.isEmpty()) {

			Vertice vertice = pilha.peek();

			/*
			 * Ordem de pesquisa em busca em profundidade:
			 * 
			 * buscar por todos as adjac�ncias iniciais e ir se aprofundando (Isso faz com
			 * que a busca seja em profundidade, cavando o m�ximo que poder )
			 * 
			 * Ap�s chegar em uma Adjac�ncia inicial NULL (Fim), realizar backTrack e
			 * verificar se Adjac�ncia anterior possui pr�xima adjac�ncia, se n�o existir e
			 * por que este e o caminho m�ximo (caminho mais profundo), retorno Null e sai
			 * do la�o e imprimir o percurso.
			 * 
			 * Porem caso exista pr�ximo Adjac�ncia continue a busca em profundidade at�
			 * chegar no fim da conex�o ou seja at� achar Null.
			 * 
			 */

			Adjacencia adj = this.getAdjVertice(vertice.getInicio());

			while (adj != null) {

				if (!adj.getVertice().getVisitado()) {

					adj.getVertice().setVisitado(true);
					pilha.push(adj.getVertice());

				}

				adj = this.getAdjVertice(adj.getVertice().getInicio());

			}

			exibirPercurso((List<Vertice>) pilha);

			pilha.pop();
			System.out.println();

		}

	}

	// Get Adjac�ncia inicial, caso seja null, Get o pr�xima Adjac�ncia n�o visitada
	private Adjacencia getAdjVertice(Adjacencia adj) {

		while (adj != null) {

			if (!adj.getVertice().getVisitado()) {

				return adj;
			}

			adj = adj.getProx();

		}

		return adj;

	}

	// Busca em profundidade utilizando Fila(Queue)
	private void buscaLargura(Vertice vertice) {

		/*
		 * Ordem de pesquisa busca em largura:
		 * 
		 * Busca pelo adjacente inicial e todos os pr�ximos desse adjacente, Utiliza
		 * fila para armazenas os v�rtice a serem visitados
		 * 
		 * Aqui a explora��o dos v�rtices funciona em camada.
		 * 
		 */

		Queue<Vertice> fila = new LinkedList<Vertice>();

		vertice.setVisitado(true);
		fila.add(vertice);

		while (!fila.isEmpty()) {

			Vertice v = fila.remove();
			System.out.print(v.getValor() + " ");
			Adjacencia adj = v.getInicio();

			while (adj != null) {

				if (!adj.getVertice().getVisitado()) {

					adj.getVertice().setVisitado(true);
					fila.add(adj.getVertice());

				}

				adj = adj.getProx();

				if (adj == null) {

					exibirPercurso((List<Vertice>) fila);

				}

			}

			System.out.println();

		}
	}

	/*
	 * Percursos ou Percuso conectados mais curtos utilizando Algoritmo de Dijkstra
	 * 
	 * logo este algoritmo mostra os menores percursos conectados (mais de um
	 * percurso no plural) e tamb�m o menor percurso conectado (no singular, para
	 * visualizar o menor percurso basta ver o primeiro resultado), a exibi��o est�
	 * em ordem crescente.
	 * 
	 */
	public void dijkstra() {

		System.err.print("*** Algoritmo de Dijkstra ***\n");

		/*
		 * Foi utilizado Array para armazenar Dist�ncia e Predecessor, por quest�o de
		 * desempenho, mas tamb�m pode-se usar atributos dist�ncia e predecessor nas
		 * adjac�ncias, por�m optou-se por Array.
		 * 
		 */
		int[] distancia = this.inicializarDistancia(this.vertices.size());
		String[] predecessor = this.inicializarPredecessor(this.vertices.size());

		for (int i = 0; i < this.vertices.size(); i++) {

			this.dijkstra(this.vertices.get(i), distancia, predecessor);
			System.out.println("\n");

			// Loop para resetar v�rtices visitadas, dessa forma podemos verificar novos
			// percursos de uma determinada v�rtice
			for (int j = i; j < this.vertices.size(); j++) {

				this.vertices.get(j).setVisitado(false);

				// Restaurar a dist�ncia para valor infinito, dessa forma podemos
				// imprimir grafos desconexos.
				distancia[i] = Integer.MAX_VALUE;
			}

		}

	}

	private void dijkstra(Vertice v, int[] distancia, String[] predecessor) {

		Queue<Vertice> fila = new LinkedList<Vertice>();

		System.out.print("Percurso(s) V�rtice " + v.getValor() + ":");
		System.out.println();

		// Condicional para evitar percurso em v�rtices j� visitadas
		if (!v.getVisitado() && v.getInicio() != null) {

			v.setVisitado(true);

			distancia[this.vertices.indexOf(v)] = 0;
			predecessor[this.vertices.indexOf(v)] = null;
			fila.add(v);

		}

		while (!fila.isEmpty()) {

			Vertice vertice = this.getMenorDistanciaNaFila(fila, distancia);
			fila.remove(vertice);

			if (!vertice.getVisitado()) {

				vertice.setVisitado(true);
				int indiceVertice = this.vertices.indexOf(vertice);

				System.out.print(vertice.getValor() + ":D[" + distancia[indiceVertice] + "]" + "|P["
						+ predecessor[indiceVertice] + "]" + "  ");

			}

			fila.addAll(this.relaxamentoAresta(vertice, distancia, predecessor));

		}

	}

	// Menor distancia na fila
	private Vertice getMenorDistanciaNaFila(Queue<Vertice> fila, int[] distancia) {

		Vertice vertice = null;
		int aux = Integer.MAX_VALUE;

		Iterator<Vertice> it = fila.iterator();

		while (it.hasNext()) {

			Vertice nextVertice = it.next();

			int menorDistancia = distancia[this.vertices.indexOf(nextVertice)];

			if (menorDistancia < aux) {

				// Armazena menor dist�ncia em AUX e retorna a v�rtice
				// correspondente a essa menor distancia
				aux = menorDistancia;
				vertice = nextVertice;

			}

		}

		return vertice;

	}

	private Set<Vertice> relaxamentoAresta(Vertice vertice, int[] distancia, String[] predecessor) {

		// Algoritmo n�o permite v�rtice repetidas(SET)
		Set<Vertice> vert = new HashSet<Vertice>();
		Adjacencia adj = vertice.getInicio();

		while (adj != null) {

			if (!adj.getVertice().getVisitado()) {

				int indiceVertice = this.vertices.indexOf(adj.getVertice());
				int somaDistancia = distancia[this.vertices.indexOf(vertice)] + adj.getPeso();

				// Se a soma da v�rtice atual + peso for menor que a dist�ncia da adjac�ncia
				// atualize a dist�ncia, se for maior n�o altere
				if (somaDistancia < distancia[indiceVertice]) {

					distancia[indiceVertice] = somaDistancia;
					predecessor[indiceVertice] = vertice.getValor();

					vert.add(adj.getVertice());
				}

			}

			adj = adj.getProx();

		}

		return vert;

	}

	// Inicializa todos o predecessores em NULL
	private String[] inicializarPredecessor(int t) {

		String[] predecessor = new String[t];

		for (int i = 0; i < t; i++) {

			predecessor[i] = null;

		}

		return predecessor;
	}

	private int[] inicializarDistancia(int t) {

		int[] distancia = new int[t];

		for (int i = 0; i < t; i++) {

			// Integer.MAX_VALUE � o maior valor positivo que pode ser representado por um
			// tipo de dados int em Java ou seja nosso valor INFINITO
			distancia[i] = Integer.MAX_VALUE;

		}

		return distancia;

	}

	private void exibirPercurso(List<Vertice> lista) {

		// System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {

			System.out.print(lista.get(i).getValor() + " ");
		}

	}

}
