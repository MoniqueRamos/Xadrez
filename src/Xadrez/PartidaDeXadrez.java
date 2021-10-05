package Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Tabuleiro.Pe�a;
import Tabuleiro.Posi��o;
import Tabuleiro.Tabuleiro;
import Xadrez.Pe�as.Rei;
import Xadrez.Pe�as.Torre;

public class PartidaDeXadrez {

	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean cheque;

	private List<Pe�a> pe�asNoTabuleiro = new ArrayList<>();
	private List<Pe�a> pe�asCapturadas = new ArrayList<>();

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.WHITE;
		inicializa��o();
	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}

	public boolean getCheque() {
		return cheque;
	}

	public Pe�aDeXadrez[][] getPe�as() {
		Pe�aDeXadrez[][] mat = new Pe�aDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (Pe�aDeXadrez) tabuleiro.pe�a(i, j);
			}
		}
		return mat;
	}

	public boolean[][] movimentosPossiveis(Posi��oDeXadrez posi��oDeOrigem) {
		Posi��o posi��o = posi��oDeOrigem.paraPosi��o();
		validarPosi��oDeOrigem(posi��o);
		return tabuleiro.pe�a(posi��o).movimentosPossiveis();
	}

	public Pe�aDeXadrez executarMovimentoDeXadrez(Posi��oDeXadrez posi��oDeOrigem, Posi��oDeXadrez posi��oDeDestino) {
		Posi��o origem = posi��oDeOrigem.paraPosi��o();
		Posi��o destino = posi��oDeDestino.paraPosi��o();
		validarPosi��oDeOrigem(origem);
		validarPosi��oDeDestino(origem, destino);
		Pe�a pe�aCapturada = realizarMovimento(origem, destino);

		if (testeCheque(jogadorAtual)) {
			desfazerMovimento(origem, destino, pe�aCapturada);
			throw new XadrezException("Voc� n�o pode se colocar em cheque");
		}

		cheque = (testeCheque(oponente(jogadorAtual))) ? true : false;

		proximoTurno();
		return (Pe�aDeXadrez) pe�aCapturada;
	}

	private Pe�a realizarMovimento(Posi��o origem, Posi��o destino) {
		Pe�a p = tabuleiro.removerPe�a(origem);
		Pe�a pe�aCapturada = tabuleiro.removerPe�a(destino);
		tabuleiro.lugarDaPe�a(p, destino);

		if (pe�aCapturada != null) {
			pe�asNoTabuleiro.remove(pe�aCapturada);
			pe�asCapturadas.add(pe�aCapturada);
		}

		return pe�aCapturada;
	}

	private void desfazerMovimento(Posi��o origem, Posi��o destino, Pe�a pe�aCapturada) {
		Pe�a p = tabuleiro.removerPe�a(destino);
		tabuleiro.lugarDaPe�a(p, origem);

		if (pe�aCapturada != null) {
			tabuleiro.lugarDaPe�a(pe�aCapturada, destino);
			pe�asCapturadas.remove(pe�aCapturada);
			pe�asNoTabuleiro.add(pe�aCapturada);
		}
	}

	private void validarPosi��oDeOrigem(Posi��o posi��o) {
		if (!tabuleiro.temUmaPe�a(posi��o)) {
			throw new XadrezException("N�o existe pe�a na posi��o de origem");
		}
		if (jogadorAtual != ((Pe�aDeXadrez) tabuleiro.pe�a(posi��o)).getCor()) {
			throw new XadrezException("A pe�a escolhida n�o � sua!");
		}
		if (!tabuleiro.pe�a(posi��o).temMovimentoPossivel()) {
			throw new XadrezException("N�o existem movimentos possiveis para a pe�a escolhida!");
		}
	}

	private void validarPosi��oDeDestino(Posi��o origem, Posi��o destino) {
		if (!tabuleiro.pe�a(origem).movimentoPossivel(destino)) {
			throw new XadrezException("A pe�a escolhida n�o pode ser movida para a posi��o escolhida");
		}
	}

	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}

	private Cor oponente(Cor cor) {
		return (cor == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}

	private Pe�aDeXadrez rei(Cor cor) {
		List<Pe�a> lista = pe�asNoTabuleiro.stream().filter(x -> ((Pe�aDeXadrez) x).getCor() == cor)
				.collect(Collectors.toList());
		for (Pe�a p : lista) {
			if (p instanceof Rei) {
				return (Pe�aDeXadrez) p;
			}
		}
		throw new IllegalStateException("N�o existe o rei da cor " + cor + " no tabuleiro");
	}

	private boolean testeCheque(Cor cor) {
		Posi��o posi��oDoRei = rei(cor).getPosi��oDeXadrez().paraPosi��o();
		List<Pe�a> pe�asDoOponente = pe�asNoTabuleiro.stream().filter(x -> ((Pe�aDeXadrez) x).getCor() == oponente(cor))
				.collect(Collectors.toList());
		for (Pe�a p : pe�asDoOponente) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[posi��oDoRei.getLinha()][posi��oDoRei.getColuna()]) {
				return true;
			}
		}
		return false;

	}

	private void lugarDaNovaPe�a(char coluna, int linha, Pe�aDeXadrez pe�a) {
		tabuleiro.lugarDaPe�a(pe�a, new Posi��oDeXadrez(coluna, linha).paraPosi��o());
		pe�asNoTabuleiro.add(pe�a);
	}

	private void inicializa��o() {

		lugarDaNovaPe�a('c', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPe�a('c', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPe�a('d', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPe�a('e', 2, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPe�a('e', 1, new Torre(tabuleiro, Cor.WHITE));
		lugarDaNovaPe�a('d', 1, new Rei(tabuleiro, Cor.WHITE));

		lugarDaNovaPe�a('c', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPe�a('c', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPe�a('d', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPe�a('e', 7, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPe�a('e', 8, new Torre(tabuleiro, Cor.BLACK));
		lugarDaNovaPe�a('d', 8, new Rei(tabuleiro, Cor.BLACK));
	}
}
