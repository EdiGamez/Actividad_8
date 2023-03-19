import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private ArrayList<Card> cards;
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private String[] suits = {"Tréboles", "Corazones", "Picas", "Diamantes"};

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        cards = new ArrayList<Card>();

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        Card card = cards.get(0);
        cards.remove(0);
        System.out.printf("%s,%s\n", card.getSuit(), card.getColor());
        System.out.printf("Quedan %d cartas en el Deck\n", cards.size());
    }

    public void pick() {
        int randomIndex = (int) (Math.random() * cards.size());
        Card card = cards.get(randomIndex);
        cards.remove(randomIndex);
        System.out.printf("%s,%s\n", card.getSuit(), card.getColor());
        System.out.printf("Quedan %d cartas en el Deck\n", cards.size());
    }

    public void hand() {
        for (int i = 0; i < 5; i++) {
            Card card = cards.get(0);
            cards.remove(0);
            System.out.printf("%s,%s\n", card.getSuit(), card.getColor());
        }
        System.out.printf("Quedan %d cartas en el Deck\n", cards.size());
    }

}
