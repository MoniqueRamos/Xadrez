package Xadrez;

import java.util.ArrayList;
import java.util.List;

import Tabuleiro.Peça;
import Tabuleiro.Posição;
import Tabuleiro.Tabuleiro;
import Xadrez.Peças.Rei;
import Xadrez.Peças.Torre;

public class PartidaDeXadrez {

	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;

	private List<Peça> peçasNoTabuleiro = new ArrayList<>();
	private List<Peça> peçasCapturadas = new ArrayList<>();

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.WHITE;
		inicialização();
	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}

	public PeçaDeXadrez[][] getPeças() {
		PeçaDeXadrez[][] mat = new PeçaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PeçaDeXadrez) tabuleiro.peça(i, j);
			}
		}
		return mat;
	}

	public boolean[][] movimentosPossiveis(PosiçãoDeXadrez posiçãoDeOrigem) {
		Posição posição = posiçãoDeOrigem.paraPosição();
		validarPosiçãoDeOrigem(posição);
		return tabuleiro.peça(posição).movimentosPossiveis();
	}

	public PeçaDeXadrez executarMovimentoDeXadrez(PosiçãoDeXadrez posiçãoDeOrigem, PosiçãoDeXadrez posiçãoDeDestino) {
		Posição origem = posiçãoDeOrigem.paraPosição();
		Posição destino = posiçãoDeDestino.paraPosição();
		validarPosiçãoDeOrigem(origem);
		validarPosiçãoDeDestino(origem, destino);
		Peça peçaCapturada = realizarMovimento(origem, destino);
		proximoTurno();
		return (PeçaDeXadrez) peçaCapturada;
	}

	private Peça realizarMovimento(Posição origem, Posição destino) {
		Peça p = tabuleiro.removerPeça(origem);
		Peça peçaCapturada = tabuleiro.removerPeça(destino);
		tabuleiro.lugarDaPeça(p, destino);

		if (peçaCapturada != null) {
			peçasNoTabuleiro.remove(peçaCapturada);
			peçasCapturadas.add(peçaCapturada);
		}

		return peçaCapturada;
	}

	private void validarPosiçãoDeOrigem(Posição posição) {
		if (!tabuleiro.temUmaPeça(posição)) {
			throw new XadrezException("Não existe peça na posição de origem");
		}
		if (jogadorAtual != ((PeçaDeXadrez) tabuleiro.peça(posição)).getCor()) {
			throw new XadrezException("A peça escolhida não é sua!");
		}
		if (!tabuleiro.peça(posição).temMovimentoPossivel()) {
			throw new XadrezException("Não existem movimentos possiveis para a peça escolhida!");
		}
	}

	private void validarPosiçãoDeDestino(Posição origem, Posição destino) {
		if (!tabuleiro.peça(origem).movimentoPossivel(destino)) {
			throw new XadrezException("A peça escolhida não pode ser movida para a posição escolhida");
		}
	}

	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}

	private void lugarDaNovaPeça(char coluna, int linha, PeçaDeXadrez peça) {
		tabuleiro.lugarDaPeça(peça, new PosiçãoDeXadrez(coluna, linha).paraPosição());
		peçasNoTabuleiro.add(peça);
	}

	private void inicialização() {

		lugarDaNovaPeça('c', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('c', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('d', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('e', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('e', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPeça('d', 1, new Rei(tabuleiro, Cor.WHITE));

		lugarDaNovaPeça('c', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('c', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('d', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('e', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('e', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPeça('d', 8, new Rei(tabuleiro, Cor.BLACK));
	}
}
