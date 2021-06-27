package Xadrez.Pe�as;

import Tabuleiro.Posi��o;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.Pe�aDeXadrez;

public class Torre extends Pe�aDeXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posi��o p = new Posi��o(0, 0);

		// cima
		p.setValores(posi��o.getLinha() - 1, posi��o.getColuna());
		while (getTabuleiro().posi��oExiste(p) && !getTabuleiro().temUmaPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posi��oExiste(p) && temPe�aAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setValores(posi��o.getLinha(), posi��o.getColuna() - 1);
		while (getTabuleiro().posi��oExiste(p) && !getTabuleiro().temUmaPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getTabuleiro().posi��oExiste(p) && temPe�aAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setValores(posi��o.getLinha(), posi��o.getColuna() + 1);
		while (getTabuleiro().posi��oExiste(p) && !getTabuleiro().temUmaPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().posi��oExiste(p) && temPe�aAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// abaixo
		p.setValores(posi��o.getLinha() + 1, posi��o.getColuna());
		while (getTabuleiro().posi��oExiste(p) && !getTabuleiro().temUmaPe�a(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posi��oExiste(p) && temPe�aAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
