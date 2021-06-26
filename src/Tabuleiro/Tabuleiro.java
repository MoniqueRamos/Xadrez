package Tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Pe�a[][] pe�as;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro criando o tabuleiro! � necess�rio que haja pelo menos uma linha e uma coluna.");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pe�as = new Pe�a[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Pe�a pe�a(int linha, int coluna) {
		if(!posi��oExiste(linha, coluna)) {
			throw new TabuleiroException("Posi��o inexistente!");
		}
		return pe�as[linha][coluna];
	}

	public Pe�a pe�a(Posi��o posi��o) {
		if(!posi��oExiste(posi��o)) {
			throw new TabuleiroException("Posi��o inexistente!");
		}
		return pe�as[posi��o.getLinha()][posi��o.getColuna()];
	}

	public void lugarDaPe�a(Pe�a pe�a, Posi��o posi��o) {
		if(temUmaPe�a(posi��o)) {
			throw new TabuleiroException("Tem uma pe�a na posi��o " + posi��o);
		}
		pe�as[posi��o.getLinha()][posi��o.getColuna()] = pe�a;
		pe�a.posi��o = posi��o;
	}

	private boolean posi��oExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posi��oExiste(Posi��o posi��o) {
		return posi��oExiste(posi��o.getLinha(), posi��o.getColuna());
	}

	public boolean temUmaPe�a(Posi��o posi��o) {
		if(!posi��oExiste(posi��o)) {
			throw new TabuleiroException("Posi��o inexistente!");
		}
		return pe�a(posi��o) != null;
	}
}
