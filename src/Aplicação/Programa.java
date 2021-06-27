package Aplica��o;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Xadrez.PartidaDeXadrez;
import Xadrez.Pe�aDeXadrez;
import Xadrez.Posi��oDeXadrez;
import Xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		List<Pe�aDeXadrez> capturada = new ArrayList<>();

		while (true) {
			try {
				UI.limparTela();
				UI.printPartida(partidaDeXadrez, capturada);
				System.out.println();
				System.out.print("Origem: ");
				Posi��oDeXadrez origem = UI.lerPosi��oDeXadrez(sc);
				
				boolean[][] movimentosPossiveis = partidaDeXadrez.movimentosPossiveis(origem);
				UI.limparTela();
				UI.printTabuleiro(partidaDeXadrez.getPe�as(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Destino: ");
				Posi��oDeXadrez destino = UI.lerPosi��oDeXadrez(sc);

				Pe�aDeXadrez pe�aCapturada = partidaDeXadrez.executarMovimentoDeXadrez(origem, destino);
				
				if(pe�aCapturada!= null) {
					capturada.add(pe�aCapturada);
				}
				
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
