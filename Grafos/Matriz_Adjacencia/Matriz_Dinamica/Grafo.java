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

			System.err.print("Erro ao realização operação: Criar Vertice\n");

		}

	}

	public void removerAresta(Vertice v_ini, Vertice v_fim) {

		if (this.vertices.contains(v_ini) && this.vertices.contains(v_ini)) {

			int linha = this.vertices.indexOf(v_ini);
			int coluna = this.vertices.indexOf(v_fim);

			this.matriz.setMatriz(linha, coluna, 0);
			
		} else {
			
			System.err.print("Erro ao realização operação: Remover Vertice\n");
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
				 * Função para inserir valor padrão não conectado (Ex: -1, -10, 999)
				 * 
				 * Esta função vai preencher toda a matriz nos pontos não conectados com valor
				 * padrão definido, consumindo mais memória, e perdendo um dos objetivo da
				 * estrutura matriz dinâmica.
				 * 
				 * Caso necessário preencher todas as posições de uma matriz, utilizar matriz
				 * estática (Matriz de Array)
				 * 
				 * Preenchendo todas a posições não conectados com -1
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

	// Função para inserir valor padrão não conectado
	private void carregarValorNaoConectado(int linha, int coluna, int valorDefaultNaoConectado) {

		if (this.matriz.getMatriz(linha, coluna) == null) {
			this.matriz.setMatriz(linha, coluna, valorDefaultNaoConectado);
		}

	}

}
