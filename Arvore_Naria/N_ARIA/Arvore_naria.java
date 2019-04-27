package arvore.naria;

public class Arvore_naria {

	private No raiz;

	public Arvore_naria(String chave) {
		this.raiz = new No(chave);
	}

	public void setConteudo(String chave, String valor) {
		No no = checkChave(this.raiz, chave);

		if (no != null) {

			this.setConteudo(no, valor);

		} else {
			System.out.println("Chave não existe");
		}
	}

	private void setConteudo(No no, String valor) {

		No aux = no.getPrim_filho();

		if (aux == null) {

			no.setPrim_filho(new No(valor));

		} else {

			while (aux.getProx_irmao() != null) {

				aux = aux.getProx_irmao();
			}

			aux.setProx_irmao(new No(valor));
		}

	}

	private No checkChave(No no, String chave) {

		if (no != null) {

			if (no.getChave().equalsIgnoreCase(chave)) {

				return no;

			} else {

				if (no.getPrim_filho() != null) {
					No aux = checkChave(no.getPrim_filho(), chave);
					if (aux != null) {
						return aux;
					}
				}

				if (no.getProx_irmao() != null) {
					No aux = checkChave(no.getProx_irmao(), chave);
					if (aux != null) {
						return aux;
					}
				}

			}
		}

		return null;

	}

	public void exibirArvore() {
		
		this.exibirArvore(this.raiz, "RAIZ", 0);
	}

	private void exibirArvore(No no, String chavePai, int prof) {

		if (no != null) {

			System.out.println(this.profundidade(prof) + no.getChave() + " | Chave pai: " + chavePai);

			exibirArvore(no.getPrim_filho(), no.getChave(), prof + 1);
			exibirArvore(no.getProx_irmao(), chavePai, prof);
		}

	}
	
	private String profundidade(int prof){
		
		String barra = "|";
		
		for (int i = prof; i > 0; i--) {
			
			barra += "-";
		}
		
		return barra;
	}

}
