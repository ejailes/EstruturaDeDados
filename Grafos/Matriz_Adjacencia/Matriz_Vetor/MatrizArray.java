public class MatrizArray {

	// Matriz binaria
	private int[][] matrizArray;

	public MatrizArray() {

	}

	public void updateTamanhoMatriz(int tamanho) {

		this.matrizArray = this.updateTamanhoMatriz(tamanho, this.matrizArray);

	}

	private int[][] updateTamanhoMatriz(int tamanho, int[][] matriz) {

		// Nova matriz
		int[][] novaMatriz = new int[tamanho][tamanho];

		/*
		 * 
		 * Para expandir uma matriz de array é necessário criar a nova matriz expandida,
		 * depois percorrer todas as posições da antiga matriz, passando os antigos
		 * valores para a matriz expandida.
		 * 
		 * Necessário percorrer a antiga matriz para não perde as conexões
		 * binaria(Aresta) (1 conectado) (0 não conectado).
		 * 
		 */

		if (matriz != null) {

			for (int i = 0; i < matriz.length; i++) {

				for (int j = 0; j < matriz.length; j++) {

					// antigos valores para nova matriz expandida.
					novaMatriz[i][j] = matriz[i][j];
				}
			}

		}

		return novaMatriz;

	}

	public void setMatriz(int i, int j, int conexao) {

		this.matrizArray[i][j] = conexao;

	}

	public int getMatriz(int i, int j) {

		return this.matrizArray[i][j];

	}

}
