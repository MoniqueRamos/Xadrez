package Xadrez.Peças;

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

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}

}
