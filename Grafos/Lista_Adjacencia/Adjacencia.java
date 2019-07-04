public class Adjacencia {

	private Vertice vertice;
	private Adjacencia prox;
	private int peso;

	public Adjacencia(Vertice v, int peso) {

		this.vertice = v;
		this.peso = peso;
		this.prox = null;
	}

	public Adjacencia getProx() {
		return prox;
	}

	public void setProx(Adjacencia prox) {
		this.prox = prox;
	}

	public Vertice getVertice() {
		return vertice;
	}

	public int getPeso() {
		return peso;
	}

}
