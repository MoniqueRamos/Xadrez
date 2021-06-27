package Xadrez.Peças;

import Tabuleiro.Posição;
import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PeçaDeXadrez;

public class Torre extends PeçaDeXadrez {

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

		Posição p = new Posição(0, 0);

		// cima
		p.setValores(posição.getLinha() - 1, posição.getColuna());
		while (getTabuleiro().posiçãoExiste(p) && !getTabuleiro().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posiçãoExiste(p) && temPeçaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda
		p.setValores(posição.getLinha(), posição.getColuna() - 1);
		while (getTabuleiro().posiçãoExiste(p) && !getTabuleiro().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getTabuleiro().posiçãoExiste(p) && temPeçaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// direita
		p.setValores(posição.getLinha(), posição.getColuna() + 1);
		while (getTabuleiro().posiçãoExiste(p) && !getTabuleiro().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().posiçãoExiste(p) && temPeçaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// abaixo
		p.setValores(posição.getLinha() + 1, posição.getColuna());
		while (getTabuleiro().posiçãoExiste(p) && !getTabuleiro().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posiçãoExiste(p) && temPeçaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
