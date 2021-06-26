package Xadrez;

import Tabuleiro.Posição;
import Tabuleiro.Tabuleiro;
import Xadrez.Peças.Torre;
import Xadrez.Peças.Rei;

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

	private void inicialização() {
		tabuleiro.lugarDaPeça(new Torre(tabuleiro, Cor.WHITE), new Posição(2, 1));
		tabuleiro.lugarDaPeça(new Rei(tabuleiro, Cor.BLACK), new Posição(0, 4));
		tabuleiro.lugarDaPeça(new Rei(tabuleiro, Cor.WHITE), new Posição(7, 4));
	}
}
