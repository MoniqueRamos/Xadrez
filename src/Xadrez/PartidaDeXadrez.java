package Xadrez;

import Tabuleiro.Tabuleiro;
import Xadrez.Peças.Rei;
import Xadrez.Peças.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicialização();
	}

	public PeçaDeXadrez[][] getPeças() {
		PeçaDeXadrez[][] mat = new PeçaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PeçaDeXadrez) tabuleiro.peça(i, j);
			}
		}
		return mat;
	}

	private void lugarDaNovaPeça(char coluna, int linha, PeçaDeXadrez peça) {
		tabuleiro.lugarDaPeça(peça, new PosiçãoDeXadrez(coluna, linha).paraPosição());
	}

	private void inicialização() {
		
		lugarDaNovaPeça('c', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('c', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('d', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('e', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('e', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('d', 1, new Rei(tabuleiro, Cor.WHITE));

		lugarDaNovaPeça('c', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('c', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('d', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('e', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('e', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('d', 8, new Rei(tabuleiro, Cor.BLACK));
	}
}
