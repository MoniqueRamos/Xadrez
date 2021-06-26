package Xadrez.Pe�as;

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

}
