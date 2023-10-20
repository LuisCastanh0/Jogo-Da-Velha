package Classes;
import java.util.Scanner;

public class TicTacToe {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opc;
		
		System.out.print("1. Um jogador\n2. Dois jogadores\nDigite sua escolha:");   
		
		opc = scan.nextInt();
		scan.nextLine();
		
		if (opc == 1) { 
			String name;
			char symbol;
			
			// Cria Jogador 
			System.out.print("\nJogador 1, digite seu nome: ");
			name = scan.nextLine();
			System.out.print(name + " Escolha seu símbolo (X/O): ");
			symbol = scan.next().charAt(0);
			symbol = Character.toUpperCase(symbol);
			scan.nextLine();
			
			Player Jogador = new Player(symbol,name);
			
			// Cria a CPU para jogar contra o adversário
			IAplayer_Random CPU;
			
			if (symbol == 'X') { 
				CPU = new IAplayer_Random('O');
			}
			else { 
				CPU = new IAplayer_Random('X');
			}
			
			// Lógica para a execução do jogo
			Board board = new Board();
			boolean status = false;
			Player jogadorAtual = Jogador;
			int i, j;
			
			board.printBoard();
			
			while(!status) {
				System.out.println("\nVez de " + jogadorAtual.getName());
				if(jogadorAtual.getName() == "Computador") { 
					CPU.makeRandomDecision(board);// IA faz jogada aleatória
					board.printBoard();
					// Verifica se IA venceu
					if(board.checkWinner(CPU.getSymbol())) { 
						System.out.print("Você perdeu!");
						break;
					}
					// Verifica se o jogo empatou
					else if(board.isDraw()) { 
						System.out.print("Empate!");
						break;
					}
					else { 
						// Caso a jogada não leve a vitória ou empate, passa o turno para o jogador
						jogadorAtual = Jogador;
					}
				}
				else { 
					System.out.print("Digite a linha onde deseja jogar: ");
					i = scan.nextInt();
					scan.nextLine();
					System.out.print("Digite a coluna onde deseja jogar: ");
					j = scan.nextInt();
					scan.nextLine();
					
					// Realiza a jogada
					if (board.play(jogadorAtual,i-1,j-1)){ 
						// Verifica se o jogador que fez a jogada venceu
						if (board.checkWinner(jogadorAtual.getSymbol())){ 
							board.printBoard();
							System.out.print("Parabéns! " + jogadorAtual.getName() + " venceu!");
							break;
						}
						// Verifica se o jogo empatou
						else if (board.isDraw()) {
							System.out.print("Jogo empatado!");
							break;
						} 
						else { 
							// Caso a jogada não leve a vitória ou empate, passa o turno para o computador
							board.printBoard();
							jogadorAtual = CPU;
						}
					}
				}
			}
		}
			
		else if (opc == 2) {
			String name;
			char symbol;
			
			// Cria Jogador 1
			System.out.print("\nJogador 1, digite seu nome: ");
			name = scan.nextLine();
			System.out.print(name + " Escolha seu símbolo (X/O): ");
			symbol = scan.next().charAt(0);
			symbol = Character.toUpperCase(symbol);
			scan.nextLine();
			
			Player Jogador1 = new Player(symbol,name);
			
			// Cria Jogador 2
			Player Jogador2;
			System.out.print("\nJogador 2, digite seu nome: ");
			name = scan.nextLine();
			if (symbol == 'X') { 
				Jogador2 = new Player('O',name);
			}
			else { 
				Jogador2 = new Player('X',name);
			}
			
			//Inicia o Jogo
			Board board = new Board();
			boolean status = false; // Controla se há vencedores ou empate
			Player jogadorAtual = Jogador1;
			int i,j;
			
			board.printBoard();
			while (!status) {
					System.out.println("\nVez de " + jogadorAtual.getName());
					System.out.print("Digite a linha onde deseja jogar: ");
					i = scan.nextInt();
					scan.nextLine();
					System.out.print("Digite a coluna onde deseja jogar: ");
					j = scan.nextInt();
					scan.nextLine();
					
					// Realiza a jogada
					if (board.play(jogadorAtual,i-1,j-1)){ 
						// Verifica se há um vencedor
						if (board.checkWinner(jogadorAtual.getSymbol())){ 
							// Se alguém venceu, encerra o looping
							board.printBoard();
							System.out.print("Parabéns! " + jogadorAtual.getName() + " venceu!");
							break;
						}
						else if (board.isDraw()) {
							System.out.print("Jogo empatado!");
							break;
						} 
						else { 
							// Caso a jogada não leve a vitória ou empate, passa o turno para o próximo jogador
							board.printBoard();
							jogadorAtual = (jogadorAtual == Jogador1) ? Jogador2 : Jogador1;
						}
					}
				}
			}
					
		
		else {System.out.print("Opção inválida");} 
		scan.close();
	}
}
