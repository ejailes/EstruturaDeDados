public class Arvore_AVL {

	private No raiz;

	public Arvore_AVL() {
		this.raiz = null;
	}

	public void setNumeroAVL(int numero) {

		this.setNumeroAVL(this.raiz, numero);
	}

	private void setNumeroAVL(No no, int numero) {

		if (this.raiz == null) {
			
			this.raiz = new No(numero).setNoPai(no);

		} else {

			if (numero > no.getNumero()) {

				if (no.getDir() != null) {

					this.setNumeroAVL(no.getDir(), numero);

					// Verificar se ocorreu desbalanceamento
					if (this.calAltura(no.getEsq()) - this.calAltura(no.getDir()) == -2) {

						No noPai = no.getNoPai();

						// Insenção a direita da subArvore a direita.
						if (numero > no.getDir().getNumero()) {

							No aux = this.rotacaoEsquerda(no);

							// Quando desbalanceamento ocorrer no NO RAIZ, inserção a direta da subArvore
							// a direita.
							if(noPai == null) {
								
								this.raiz = aux;
								
							} else if (noPai.getNumero() < aux.getNumero()) {
							
							// Quando desbalanceamento ocorrer a direta da subArvore
							// a direita.
								
								noPai.setDir(aux);
								/*
								 * 
								 *    [x] -> NO DESBALANCEADO
								 *     |
								 *     -----|
								 *         [x]
								 *          |
								 *          -----
								 *               |
								 *           	[x] -> INSERÇÃO A DIREITA DA SUB_ARVORE
								 *           		   A DIRETA.
								 * 
								 */

							} else {

								// Excepcionalmente quando desbalanceamento ocorrer a direita
								// da subArvore a direita a esquerda do NOPAI RAIZ 

								noPai.setEsq(aux);
								
								/*
								 * 
								 * 	        [x] -> NO_PAI RAIZ(raiz da arvore)
								 * 	         |
								 *           -----
								 *           |
								 *          [x] -> NO DESBALANCEADO
								 *           |
								 *           -----|
								 *           	 [x]
								 *           	  |
								 *           	  -----
								 *           	      |
								 *           	     [x] -> INSERÇÃO A DIREITA DA SUB_ARVORE
								 *           		    A DIRETA, A ESQUERDA DO NO_PAI RAIZ
								 * 
								 */
								
							}

							
						// Insenção a esquerda da subArvore a direita.
						} else {
							
							No aux = this.rotacaoDireitaEsquerda(no);
							
							// Quando desbalanceamento ocorrer no NO RAIZ DA ARVORE, inserção a esquerda da subArvore
							// a direita. 
							if(noPai == null) {
								
								this.raiz = aux;
								
							} else if(noPai.getNumero() < aux.getNumero()) {
							
							// Quando desbalanceamento ocorrer a esquerda da subArvore
							// a direita.
								
								noPai.setDir(aux);
								
								/*
								 * 
								 *          [x] -> NO DESBALANCEADO
								 *           |
								 *           -----|
								 *           	 [x]
								 *           	  |
								 *           |-----
								 *          [x] -> INSERÇÃO A ESQUERDA DA SUB_ARVORE
								 *           	   A DIRETA.
								 * 
								 */
								
							}else {
								
								// Excepcionalmente quando desbalanceamento ocorrer a esquerda
								// da subArvore a direita a esquerda do NOPAI RAIZ 
								
								noPai.setEsq(aux);
								
								/*
								 * 
								 * 	        [x] -> NO_PAI RAIZ(raiz da arvore)
								 * 	         |
								 *           -----
								 *           |
								 *          [x] -> NO DESBALANCEADO
								 *           |
								 *           -----|
								 *           	 [x]
								 *           	  |
								 *           |-----
								 *          [x] -> INSERÇÃO A ESQUERDA DA SUB_ARVORE
								 *           	   A DIRETA, A ESQUERDA DO NO_PAI RAIZ
								 * 
								 */
							}
							
						}

					}

				} else {

					no.setDir(new No(numero).setNoPai(no));
				}

			} else {

				if (no.getEsq() != null) {

					this.setNumeroAVL(no.getEsq(), numero);
					
					// Verificar se ocorreu desbalanceamento
					if(this.calAltura(no.getEsq()) - this.calAltura(no.getDir()) == 2) {
						
						No noPai = no.getNoPai();
						
						if(numero < no.getEsq().getNumero()) {
							
							No aux = this.rotacaoDireita(no);
			
							// Quando desbalanceamento ocorrer no NO RAIZ DA ARVORE, inserção a esquerda da subArvore
							// a esquerda.
							if(noPai == null) {
								
								this.raiz = aux;
								
							} else if (noPai.getNumero() > aux.getNumero()) {
								
							// Quando desbalanceamento ocorrer a esquerda da subArvore
							// a esquerda.
								
								noPai.setEsq(aux);
								
								/*
								 * 
								 *                  [x] -> NO DESBALANCEADO
								 *                   |
								 *               -----
								 *               |
								 *              [x]
								 *               |
								 *           -----
								 *           |
								 *          [x] -> INSERÇÃO A ESQUERDA DA SUB_ARVORE
								 *           	   A ESQUERDA.
								 * 
								 */
								
							} else {
								
								// Excepcionalmente quando desbalanceamento ocorrer a esquerda
								// da subArvore a esquerda a direita do NOPAI RAIZ 
								
								noPai.setDir(aux);
								
								/*
								 * 
								 * 	        [x] -> NO_PAI RAIZ(raiz da arvore)
								 * 		 |
								 *               -----
								 *                   |
								 *                  [x] -> NO DESBALANCEADO
								 *                   |
								 *               -----
								 *               |
								 *           	[x]
								 *           	 |
								 *           -----
								 *           |
								 *          [x] -> INSERÇÃO A ESQUERDA DA SUB_ARVORE
								 *           	   A ESQUEERDA, A DIREITA DO NO_PAI RAIZ
								 * 
								 */
							}
			
						} else {
							
							No aux = this.rotacaoEsquerdaDireita(no);
							
							// Quando desbalanceamento ocorrer no NO RAIZ DA ARVORE, inserção a direta da subArvore
							// a esquerda.
							if(noPai == null) {
								
								this.raiz = aux;
								
							} else if(noPai.getNumero() > aux.getNumero()) {
							
							// Quando desbalanceamento ocorrer a direita da subArvore
							// a esquerda.
								
								noPai.setEsq(aux);
								
								/*
								 * 
								 *          [x] -> NO DESBALANCEADO
								 *           |
								 *      |-----
								 *     [x]
								 *      |----|
								 *          [x] -> INSERÇÃO A DIREITA DA SUB_ARVORE
								 *           	   A ESQUERDA.
								 * 
								 */
								
							} else {
								
								// Excepcionalmente quando desbalanceamento ocorrer a direita
								// da subArvore a esquerda a direita do NOPAI RAIZ
								
								noPai.setDir(aux);
								
								/*
								 * 
								 *      [x] -> NO_PAI RAIZ(raiz da arvore)
								 * 	 |
								 *       -----
								 *           |
								 *          [x] -> NO DESBALANCEADO
								 *           |
								 *      |-----
								 *     [x]
								 *      |----|
								 *          [x] -> INSERÇÃO A DIREITA DA SUB_ARVORE
								 *           	   A ESQUERDA a DIREITA DO NO_PAI RAIZ
								 * 
								 * 
								 */
							}
						}
						
					}

				} else {

					no.setEsq(new No(numero).setNoPai(no));
				}
			}

			// Calcula Altura do NO
			no.setAlturaNo(Math.max(this.calAltura(no.getEsq()), this.calAltura(no.getDir())) + 1);
		}

	}
	
	public void buscaBinaria(int numero) {
		
		No no = buscaBinaria(this.raiz, numero);
		
		if(no != null) {
			System.out.println("Numero " + no.getNumero() + " encontrado");
		} else {
			System.out.println("Numero não existe na Árvore AVL");
		}
		
	}

	private No buscaBinaria(No no, int numero) {
		
		if(no != null) {
			
			if(numero == no.getNumero()) {
				return no;
			} else {
				
				if(numero > no.getNumero()) {
					if(no.getDir() != null) {
						return buscaBinaria(no.getDir(), numero);
					}
				} else {
					
					if(no.getEsq() != null) {
						 return buscaBinaria(no.getEsq(), numero);
					}
				}
			}
			
			
		}
		return null;
	}

	private No rotacaoEsquerdaDireita(No no) {
		
		no.setEsq(this.rotacaoEsquerda(no.getEsq()));
		
		return this.rotacaoDireita(no);
	}

	private No rotacaoDireitaEsquerda(No no) {
		
		no.setDir(this.rotacaoDireita(no.getDir()));
		
		return this.rotacaoEsquerda(no);
	}

	private No rotacaoDireita(No no) {
		
		// Rotação direita
		No aux = no.getEsq();
		no.setEsq(aux.getDir());
		aux.setDir(no);
	
		// Update NOs Pai
		aux.setNoPai(no.getNoPai());
		no.setNoPai(aux);
		if(no.getEsq() != null) {
			no.getEsq().setNoPai(no);
		}
		
		// Update Alturas
		no.setAlturaNo(Math.max(this.calAltura(no.getEsq()), this.calAltura(no.getDir())) + 1);
		aux.setAlturaNo(Math.max(this.calAltura(no.getEsq()), no.getAlturaNo()) + 1);
		
		return aux;
	}

	private No rotacaoEsquerda(No no) {
		
		// Rotação esquerda
		No aux = no.getDir();
		no.setDir(aux.getEsq());
		aux.setEsq(no);

		// Update NOs Pai
		aux.setNoPai(no.getNoPai());
		no.setNoPai(aux);
		if(no.getDir() != null) {
			no.getDir().setNoPai(no);	
		}
		
		// Update Alturas
		no.setAlturaNo(Math.max(this.calAltura(no.getEsq()), this.calAltura(no.getDir())) + 1);
		aux.setAlturaNo(Math.max(no.getAlturaNo(), this.calAltura(aux.getDir())) + 1);

		return aux;

	}

	public void exibirAVL() {

		this.exibirAVL(this.raiz, 0);
	}

	private int calAltura(No no) {

		if (no == null) {
			return -1;
		}

		return no.getAlturaNo();
	}

	private void exibirAVL(No no, int esp) {

		if (no != null) {

			// GetNoPai
			int x = no.getNoPai() == null ? 0 : no.getNoPai().getNumero();
			
			System.out.println(" " + this.espaco(esp) + no.getNumero() + " -> Altura: " + no.getAlturaNo() + "| NO PAI -> " + x);
			
			this.exibirAVL(no.getDir(), esp + 1);
			this.exibirAVL(no.getEsq(), esp + 1);
			
		}

	}
	
	private String espaco(int i) {

		String esp = "|";
		
		for (int j = i; j > 0; j--) {
			
			esp += "-";
	
		}
		
		return esp;
	}

}
