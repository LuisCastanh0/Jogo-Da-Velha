package Classes;
// Classe para representar o jogador
public class Player {
	private char symbol;
	private String name;
	
	// Método Construtor
	public Player(char symbol) {
		this.symbol = symbol;
		this.name = "Computador";
	}
	
	public Player(char symbol, String name) { 
		this.symbol = symbol;
		this.name = name;
	}
	
	//Getters e Setters
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return name + "->" + symbol;
	}
}

