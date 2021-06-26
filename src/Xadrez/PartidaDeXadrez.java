package Xadrez;

import Tabuleiro.Tabuleiro;
import Xadrez.Pe�as.Rei;
import Xadrez.Pe�as.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicializa��o();
	}

	public Pe�aDeXadrez[][] getPe�as() {
		Pe�aDeXadrez[][] mat = new Pe�aDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (Pe�aDeXadrez) tabuleiro.pe�a(i, j);
			}
		}
		return mat;
	}

	private void lugarDaNovaPe�a(char coluna, int linha, Pe�aDeXadrez pe�a) {
		tabuleiro.lugarDaPe�a(pe�a, new Posi��oDeXadrez(coluna, linha).paraPosi��o());
	}

	private void inicializa��o() {
		lugarDaNovaPe�a('b', 6, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPe�a('e', 8, new Rei(tabuleiro, Cor.BLACK));
		lugarDaNovaPe�a('e', 1, new Rei(tabuleiro, Cor.WHITE));
	}
}
