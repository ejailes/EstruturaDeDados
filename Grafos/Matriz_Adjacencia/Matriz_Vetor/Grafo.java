package matriz.array;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private List<Vertice> vertice;
	
	// Matriz binaria
	private MatrizArray matriz;

	public Grafo() {

		this.vertice = new ArrayList<Vertice>();
		this.matriz = new MatrizArray();
	}

	public Vertice criarVertice(String v) {

		Vertice vertice = new Vertice(v);
		this.vertice.add(vertice);

		this.matriz.updateTamanhoMatriz(this.vertice.size());

		return vertice;
	}

	public void criarAresta(Vertice v_ini, Vertice v_fim) {

		try {

			int linha = this.vertice.indexOf(v_ini);
			int coluna = this.vertice.indexOf(v_fim);

			this.matriz.setMatriz(linha, coluna, 1);

		} catch (Exception e) {

			System.err.print("Erro ao realização operação: Criar Vertice\n");
		}

	}

	public void removerVertice(Vertice v_ini, Vertice v_fim) {

		try {

			int linha = this.vertice.indexOf(v_ini);
			int coluna = this.vertice.indexOf(v_fim);

			this.matriz.setMatriz(linha, coluna, 0);

		} catch (Exception e) {

			System.err.print("Erro ao realização operação: Remover Vertice\\n");
		}

	}

	public void exibir() {

		System.out.print("   ");
		for (Vertice v : vertice) {
			System.out.print(v.getValor() + " ");
		}

		System.out.println();

		for (int i = 0; i < this.vertice.size(); i++) {

			System.out.print(this.vertice.get(i).getValor() + ": ");

			for (int j = 0; j < this.vertice.size(); j++) {

				System.out.print(this.matriz.getMatriz(i, j));
				System.out.print("  ");

			}

			System.out.println();
		}

	}
}
