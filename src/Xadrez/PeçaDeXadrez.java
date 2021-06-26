package Xadrez;

import Tabuleiro.Pe�a;
import Tabuleiro.Tabuleiro;

public class Pe�aDeXadrez extends Pe�a {

	private Cor cor;

	public Pe�aDeXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

}
