
public class Vertice {

	private String valor;

	/*
	 * Ponteiros
	 * 
	 * Dois ponteiras para manter a ordena��o de inser��o ponteira in�cio fixo,
	 * ponteira �ltimo atualizado a cada inser��o.
	 * 
	 * Utilizando apenas 1 ponteira a exibi��o ficara de tr�s para frente.
	 * 
	 */
	private Adjacencia inicio;
	private Adjacencia ultimo;

	//
	private boolean visitado;
	

	public Vertice(String valor) {

		this.valor = valor;
	}

	public String getValor() {

		return this.valor;
	}

	public Adjacencia getInicio() {
		return inicio;
	}

	public void setInicio(Adjacencia inicio) {
		this.inicio = inicio;
	}

	public Adjacencia getUltimo() {
		return ultimo;
	}

	public void setUltimo(Adjacencia ultimo) {
		this.ultimo = ultimo;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean getVisitado() {
		return this.visitado;
	}

}
