package Classes;
// Classe para representar o tabuleiro
public class Board {
	private char[][] board;
	
	// Cria tabuleiro 3x3
	public Board() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	// Imprime o tabuleiro
	public void printBoard() {
		for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            System.out.print(" " + board[i][j] + " ");
	            if (j < 2) {
	                System.out.print("|"); // Barra vertical entre as colunas
	            }
	        }
	        System.out.println(); // Quebra de linha no final de cada linha
	        if (i < 2) {
	            System.out.println("---+---+---"); // Linha horizontal entre as linhas
	        }
	    }
	}
	
	// Verifica se uma posição [i][j] do tabuleiro está vazia
	public boolean IsEmpty(int i, int j) {
		if (board[i][j] == ' ') { return true; }
		else {return false; }
	}
	
	// Realiza a jogada
	public boolean play(Player player,int i, int j) { 
		if (IsEmpty(i,j)) {
			board[i][j] = player.getSymbol();
			return true;}
		else {
			System.out.print("Posição inválida, tente novamente.");
			return false;
		}
	}
	
	// Verifica se o jogo empatou
	public boolean isDraw() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkWinner(char symbol) {
		// Verifica se há um vencedor em alguma linha
		for (int i = 0;i < 3; i++) {
			if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
				return true; }
		}
		
		// Verifica se há um vencedor em alguma coluna
		for (int i = 0;i < 3; i++) {
			if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
				return true; }
		}
		
		// Verifica se há um vencedor na Diagonal principal
		if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
			return true;
		}
		
		// Verifica se há um vencedor na Diagonal Secundaria
		if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
			return true;
		}
		
		return false;
	}
}
