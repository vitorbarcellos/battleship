package com.battleship;

public class Mundo {

	private int[][] mapa;
	
	public Mundo() {
		this.mapa = new int[10][15];
		this.init();
	}
	
	private int random(int limite) {
		return (int)(Math.random() * limite);
	}
	
	private void init() {
		for (int i = 0; i < 7; i++) {
			boolean plota = true;
			do {
				if (i <= 2)
					plota = this.plota(3);
				else if (i <= 5)
					plota = this.plota(4);
				else if (i <= 7)
					plota = this.plota(5);
				
			} while (plota);
		}
	}
	
	private boolean plota(int tamanho) {
		
		int y = this.random(15 - tamanho);
		int x = this.random(10);
		
		if (!this.verifica(tamanho, x, y))
			return true;
		
		this.adiciona(tamanho, x, y);
		return false;
	}
	
	private void adiciona(int tamanho, int x, int y) {
		
		for (int i = 0; i < tamanho; i++)
			this.mapa[x][y + i] = tamanho; 
	}
	
	private boolean verifica(int tamanho, int x, int y) {
		
		for (int i = 0; i < tamanho; i++)
			if (this.mapa[x][y + i] > 0)
				return false;
		
		return true;
	}
	
	public void exibe() {

		for (int[] is : mapa) {
			System.out.print("| ");
			for (int i : is) {
				System.out.print(i + " | ");
			}
			System.out.println();
		}
	}

	public boolean atack(Jogador j, int x, int y) {

		if (this.mapa[x - 1][y - 1] > 0) {
			j.ganha();
			this.mapa[x - 1][y - 1] = 9;
			return true;
		}
		return false;
	}

	public boolean atackRandom(Jogador j) {

		int y = this.random(15);
		int x = this.random(10);

		if (this.mapa[x][y] > 0) {
			j.ganha();
			this.mapa[x][y] = 9;
			return true;
		}
		return false;
	}

	public void exibeOculto() {
		
		for (int i = 0; i < mapa.length; i++) {
			System.out.print("| . |");
			for (int j = 0; j < mapa[i].length - 1; j++) {
				if (this.mapa[i][j] == 9)
					System.out.print(" x |");
				else
					System.out.print(" . |");
			}
			System.out.println();
		}
		
		
	}
}
