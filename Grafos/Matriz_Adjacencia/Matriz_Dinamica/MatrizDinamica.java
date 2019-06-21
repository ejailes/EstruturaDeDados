package matriz.dinamica;

import java.util.HashMap;
import java.util.Map;

public class MatrizDinamica {

	// Matriz Din�mica
	private Map<Integer, Map<Integer, Integer>> matriz;

	public MatrizDinamica() {

		this.matriz = new HashMap<Integer, Map<Integer, Integer>>();
	}

	public void setMatriz(int linha, int coluna, int conexao) {

		Map<Integer, Integer> mapInterna = getMapInterno(linha);

		// Se houver conex�o adicione na matriz, se n�o remova da matriz; 
		// Valor padr�o para remove conex�o � 0(valor alter�vel)
		if (conexao != 0) {

			mapInterna.put(coluna, conexao);

		} else {

			mapInterna.remove(coluna);

		}

	}

	// Retorna Map Interno
	private Map<Integer, Integer> getMapInterno(int linha) {

		Map<Integer, Integer> mapInterno = this.matriz.get(linha);

		if (mapInterno == null) {

			mapInterno = new HashMap<Integer, Integer>();
			this.matriz.put(linha, mapInterno);

		}

		return mapInterno;
	}

	public Integer getMatriz(int linha, int coluna) {

		Map<Integer, Integer> mapInterno = this.getMapInterno(linha);
		return mapInterno.get(coluna);
	}

}
