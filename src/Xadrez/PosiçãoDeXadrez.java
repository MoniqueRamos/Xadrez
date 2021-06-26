package Xadrez;

import Tabuleiro.Posi��o;

public class Posi��oDeXadrez {
	private char coluna;
	private int linha;

	public Posi��oDeXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro na posi��o! Valores v�lidos s�o de a1 at� h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}

	protected Posi��o paraPosi��o() {
		return new Posi��o(8 - linha, coluna - 'a');
	}

	protected static Posi��oDeXadrez dePosi��o(Posi��o posi��o) {
		return new Posi��oDeXadrez((char) ('a' - posi��o.getColuna()), 8 - posi��o.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}

}
