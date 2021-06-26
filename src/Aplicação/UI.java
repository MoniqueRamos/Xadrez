package Aplica��o;

import Xadrez.Pe�aDeXadrez;

public class UI {

	public static void printTabuleiro(Pe�aDeXadrez[][] pe�as) {
		for (int i = 0; i < pe�as.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pe�as.length; j++) {
				printPe�a(pe�as[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	private static void printPe�a(Pe�aDeXadrez pe�a) {
		if (pe�a == null) {
			System.out.print("- ");
		} else {
			System.out.print("pe�a");
		}
		System.out.print("");
	}
}
