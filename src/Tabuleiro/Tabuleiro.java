package Tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peça[][] peças;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro criando o tabuleiro! É necessário que haja pelo menos uma linha e uma coluna.");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		peças = new Peça[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peça peça(int linha, int coluna) {
		if(!posiçãoExiste(linha, coluna)) {
			throw new TabuleiroException("Posição inexistente!");
		}
		return peças[linha][coluna];
	}

	public Peça peça(Posição posição) {
		if(!posiçãoExiste(posição)) {
			throw new TabuleiroException("Posição inexistente!");
		}
		return peças[posição.getLinha()][posição.getColuna()];
	}

	public void lugarDaPeça(Peça peça, Posição posição) {
		if(temUmaPeça(posição)) {
			throw new TabuleiroException("Tem uma peça na posição " + posição);
		}
		peças[posição.getLinha()][posição.getColuna()] = peça;
		peça.posição = posição;
	}

	private boolean posiçãoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posiçãoExiste(Posição posição) {
		return posiçãoExiste(posição.getLinha(), posição.getColuna());
	}

	public boolean temUmaPeça(Posição posição) {
		if(!posiçãoExiste(posição)) {
			throw new TabuleiroException("Posição inexistente!");
		}
		return peça(posição) != null;
	}
}
