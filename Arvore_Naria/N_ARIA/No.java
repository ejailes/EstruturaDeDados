public class No {

	// Ponteiros
	private No prim_filho;
	private No prox_irmao;

	/*
	 * Outra forma de exibição em profundidade é criar um atributo profundidade
	 * na classe NO quando for criar um novo NO prim_filho ou prox_irmao set a
	 * profundidade.
	 */

	private String chave;

	public No(String chave) {
		this.chave = chave;
	}
	
	public No getPrim_filho() {
		return prim_filho;
	}

	public void setPrim_filho(No prim_filho) {
		this.prim_filho = prim_filho;
	}

	public No getProx_irmao() {
		return prox_irmao;
	}

	public void setProx_irmao(No prox_irmao) {
		this.prox_irmao = prox_irmao;
	}

	public String getChave() {
		return chave;
	}

}
