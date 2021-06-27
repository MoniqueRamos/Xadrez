package Xadrez.Peças;

import Tabuleiro.Posição;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PeçaDeXadrez;

public class Rei extends PeçaDeXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean podeMover(Posição posição) {
		PeçaDeXadrez p = (PeçaDeXadrez) getTabuleiro().peça(posição);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posição p = new Posição(0, 0);

		// cima
		p.setValores(posição.getLinha() - 1, posição.getColuna());
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// abaixo
		p.setValores(posição.getLinha() + 1, posição.getColuna());
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setValores(posição.getLinha(), posição.getColuna() - 1);
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setValores(posição.getLinha(), posição.getColuna() + 1);
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// noroeste
		p.setValores(posição.getLinha() - 1, posição.getColuna() - 1);
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// nordeste
		p.setValores(posição.getLinha() - 1, posição.getColuna() + 1);
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// sudoeste
		p.setValores(posição.getLinha() + 1, posição.getColuna() - 1);
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// sudeste
		p.setValores(posição.getLinha() + 1, posição.getColuna() + 1);
		if (getTabuleiro().posiçãoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
