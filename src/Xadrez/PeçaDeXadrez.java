package Xadrez;

import Tabuleiro.Pe�a;
import Tabuleiro.Posi��o;
import Tabuleiro.Tabuleiro;

public abstract class Pe�aDeXadrez extends Pe�a {

	private Cor cor;

	public Pe�aDeXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	protected boolean temPe�aAdversaria(Posi��o posi��o) {
		Pe�aDeXadrez p = (Pe�aDeXadrez) getTabuleiro().pe�a(posi��o);
		return p != null && p.getCor() != cor;
	}

}
