package matriz.dinamica;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private MatrizDinamica matriz;
	private List<Vertice> vertices;

	public Grafo() {
		this.vertices = new ArrayList<Vertice>();
		this.matriz = new MatrizDinamica();
	}

	public Vertice criarVertice(String v) {

		Vertice vertice = new Vertice(v);
		this.vertices.add(vertice);

		return vertice;
	}

	public void criarAresta(Vertice v_ini, Vertice v_fim) {

		if (this.vertices.contains(v_ini) && this.vertices.contains(v_ini)) {

			int linha = this.vertices.indexOf(v_ini);
			int coluna = this.vertices.indexOf(v_fim);

			this.matriz.setMatriz(linha, coluna, 1);

		} else {

			System.err.print("Erro ao realiza��o opera��o: Criar Vertice\n");

		}

	}

	public void removerAresta(Vertice v_ini, Vertice v_fim) {

		if (this.vertices.contains(v_ini) && this.vertices.contains(v_ini)) {

			int linha = this.vertices.indexOf(v_ini);
			int coluna = this.vertices.indexOf(v_fim);

			this.matriz.setMatriz(linha, coluna, 0);
			
		} else {
			
			System.err.print("Erro ao realiza��o opera��o: Remover Vertice\n");
		}

	}

	public void exibirMatriz() {

		this.exibirMatriz(this.vertices.size());
	}

	private void exibirMatriz(int tamanho) {

		System.out.print("   ");
		for (Vertice vertice : vertices) {
			System.out.print(" " + vertice.getValor());
		}

		System.out.println();

		for (int i = 0; i < tamanho; i++) {

			System.out.print(this.vertices.get(i).getValor() + ": ");

			for (int j = 0; j < tamanho; j++) {

				/*
				 * Fun��o para inserir valor padr�o n�o conectado (Ex: -1, -10, 999)
				 * 
				 * Esta fun��o vai preencher toda a matriz nos pontos n�o conectados com valor
				 * padr�o definido, consumindo mais mem�ria, e perdendo um dos objetivo da
				 * estrutura matriz din�mica.
				 * 
				 * Caso necess�rio preencher todas as posi��es de uma matriz, utilizar matriz
				 * est�tica (Matriz de Array)
				 * 
				 * Preenchendo todas a posi��es n�o conectados com -1
				 * 
				 * this.carregarValorNaoConectado(i, j, -1);
				 * System.out.print((this.matriz.getMatriz(i, j) != null) ? 1 : 0 + "  ");
				 * 
				 */

				System.out.print((this.matriz.getMatriz(i, j) != null) ? 1 : 0);
				System.out.print("  ");
			}

			System.out.println();

		}
	}

	// Fun��o para inserir valor padr�o n�o conectado
	private void carregarValorNaoConectado(int linha, int coluna, int valorDefaultNaoConectado) {

		if (this.matriz.getMatriz(linha, coluna) == null) {
			this.matriz.setMatriz(linha, coluna, valorDefaultNaoConectado);
		}

	}

}
