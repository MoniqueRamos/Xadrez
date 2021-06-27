package Aplicação;

import java.util.InputMismatchException;
import java.util.Scanner;

import Xadrez.PartidaDeXadrez;
import Xadrez.PeçaDeXadrez;
import Xadrez.PosiçãoDeXadrez;
import Xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

		while (true) {
			try {
				UI.limparTela();
				UI.printTabuleiro(partidaDeXadrez.getPeças());
				System.out.println();
				System.out.print("Origem: ");
				PosiçãoDeXadrez origem = UI.lerPosiçãoDeXadrez(sc);
				
				boolean[][] movimentosPossiveis = partidaDeXadrez.movimentosPossiveis(origem);
				UI.limparTela();
				UI.printTabuleiro(partidaDeXadrez.getPeças(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Destino: ");
				PosiçãoDeXadrez destino = UI.lerPosiçãoDeXadrez(sc);

				PeçaDeXadrez peçaCapturada = partidaDeXadrez.executarMovimentoDeXadrez(origem, destino);
			} catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
