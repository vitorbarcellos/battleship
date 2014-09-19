package com.battleship;

import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Mundo mj = new Mundo();
		Mundo mi = new Mundo();

		Jogador j = new Jogador();
		Jogador i = new Jogador();

		System.out.println("Jogador : ");
		mj.exibe();
		System.out.println("Computador : ");
		mi.exibeOculto();
		
		Scanner sc = new Scanner(System.in);

		do {

			mi.atack(j, sc.nextInt(), sc.nextInt());
			mj.atackRandom(i);

			System.out.println("Jogador : ");
			mj.exibe();
			System.out.println("Computador : ");
			mi.exibeOculto();

		} while(i.getPontos() < 8 || j.getPontos() < 8);
		sc.close();

		if (i.getPontos() > j.getPontos())
			System.out.println("Inimigo ganhou!");
		else
			System.out.println("Você ganhou!");
		
	}

}
