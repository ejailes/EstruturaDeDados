package Arvore.AVL;

public class No {

	// Ponteiros, esquerda, direita
	private No esq;
	private No dir;

	// No Pai
	private No noPai;

	// Altura No
	private int alturaNo;

	// Profundidade No
	private int profNo;

	// Chave
	private int numero;

	public No(int numero) {
		this.numero = numero;
		this.alturaNo = 0;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}

	public No getDir() {
		return dir;
	}

	public void setDir(No dir) {
		this.dir = dir;
	}

	public int getAlturaNo() {
		return alturaNo;
	}

	public void setAlturaNo(int alturaNo) {
		this.alturaNo = alturaNo;
	}

	// Set No com Interface Fluente
	public No setProf(int p) {
		this.profNo = p;
		return this;
	}

	public int getNumero() {
		return numero;
	}

	// Set No com Interface Fluente
	public No setNoPai(No no) {
		this.noPai = no;
		return this;
	}

	public int getProf() {
		return this.profNo;
	}

	public No getNoPai() {
		return this.noPai;
	}

}
