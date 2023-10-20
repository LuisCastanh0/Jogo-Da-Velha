package Classes;
import java.util.Random;

public class IAplayer_Random extends Player {
	private Random random;
	
	public IAplayer_Random(char symbol) {
		super(symbol);
		random = new Random();
	}
	
	public void makeRandomDecision(Board board) {
		while (true) { 
			int i = random.nextInt(3);
			int j = random.nextInt(3);
			if (board.IsEmpty(i, j)) {
				board.play(this, i, j);
				break;
			}
		}
	}
}
