package Xadrez;

import Tabuleiro.Posi��o;
import Tabuleiro.Tabuleiro;
import Xadrez.Pe�as.Torre;
import Xadrez.Pe�as.Rei;

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

	private void inicializa��o() {
		tabuleiro.lugarDaPe�a(new Torre(tabuleiro, Cor.WHITE), new Posi��o(2, 1));
		tabuleiro.lugarDaPe�a(new Rei(tabuleiro, Cor.BLACK), new Posi��o(0, 4));
		tabuleiro.lugarDaPe�a(new Rei(tabuleiro, Cor.WHITE), new Posi��o(7, 4));
	}
}
