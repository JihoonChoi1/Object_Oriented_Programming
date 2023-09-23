import java.util.Random;

public class Exercise2 {

	public static void main(String[] args) {
		final int KING = 0, QUEEN = 1, JACK = 2, ACE = 3;

		Random generator = new Random();
		int numOfCards = generator.nextInt(5) + 1;
		System.out.println("You drew " + numOfCards + " cards from the deck:");

		for (int i = 0; i < numOfCards; i++) {
			switch (generator.nextInt(4)) {
			case KING:
				System.out.println("You drew a King.");
				break;
			case QUEEN:
				System.out.println("You drew a Queen.");
				break;
			case JACK:
				System.out.println("You drew a Jack.");
			case ACE:
				System.out.println("You drew an Ace.");
			}
		}
	}

}
