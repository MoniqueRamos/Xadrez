package Aplicação;

import java.util.Scanner;

import Xadrez.PartidaDeXadrez;
import Xadrez.PeçaDeXadrez;
import Xadrez.PosiçãoDeXadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

		while (true) {
			UI.printTabuleiro(partidaDeXadrez.getPeças());
			System.out.println();
			System.out.print("Origem: ");
			PosiçãoDeXadrez origem = UI.lerPosiçãoDeXadrez(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			PosiçãoDeXadrez destino = UI.lerPosiçãoDeXadrez(sc);
			
			PeçaDeXadrez peçaCapturada = partidaDeXadrez.executarMovimentoDeXadrez(origem, destino);
		}
	}
}
