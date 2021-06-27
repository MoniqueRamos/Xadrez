package Aplica��o;

import java.util.Scanner;

import Xadrez.PartidaDeXadrez;
import Xadrez.Pe�aDeXadrez;
import Xadrez.Posi��oDeXadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

		while (true) {
			UI.printTabuleiro(partidaDeXadrez.getPe�as());
			System.out.println();
			System.out.print("Origem: ");
			Posi��oDeXadrez origem = UI.lerPosi��oDeXadrez(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			Posi��oDeXadrez destino = UI.lerPosi��oDeXadrez(sc);
			
			Pe�aDeXadrez pe�aCapturada = partidaDeXadrez.executarMovimentoDeXadrez(origem, destino);
		}
	}
}
