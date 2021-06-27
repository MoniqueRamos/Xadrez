package Xadrez.Pe�as;

import Tabuleiro.Posi��o;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.Pe�aDeXadrez;

public class Rei extends Pe�aDeXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean podeMover(Posi��o posi��o) {
		Pe�aDeXadrez p = (Pe�aDeXadrez) getTabuleiro().pe�a(posi��o);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posi��o p = new Posi��o(0, 0);

		// cima
		p.setValores(posi��o.getLinha() - 1, posi��o.getColuna());
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// abaixo
		p.setValores(posi��o.getLinha() + 1, posi��o.getColuna());
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setValores(posi��o.getLinha(), posi��o.getColuna() - 1);
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setValores(posi��o.getLinha(), posi��o.getColuna() + 1);
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// noroeste
		p.setValores(posi��o.getLinha() - 1, posi��o.getColuna() - 1);
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// nordeste
		p.setValores(posi��o.getLinha() - 1, posi��o.getColuna() + 1);
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// sudoeste
		p.setValores(posi��o.getLinha() + 1, posi��o.getColuna() - 1);
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// sudeste
		p.setValores(posi��o.getLinha() + 1, posi��o.getColuna() + 1);
		if (getTabuleiro().posi��oExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
