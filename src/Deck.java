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
    public String head() {
        Card card = cards.get(0);
        cards.remove(0);
        String output = String.format("%s,%s\n", card.getSuit(), card.getColor());
        output += String.format("Quedan %d cartas en el Deck\n", cards.size());
        return output;
    }

    public String pick() {
        int randomIndex = (int) (Math.random() * cards.size());
        Card card = cards.get(randomIndex);
        cards.remove(randomIndex);
        String output = String.format("%s,%s\n", card.getSuit(), card.getColor());
        output += String.format("Quedan %d cartas en el Deck\n", cards.size());
        return output;
    }

    public String hand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            Card card = cards.get(0);
            cards.remove(0);
            sb.append(String.format("%s,%s\n", card.getSuit(), card.getColor()));
        }
        sb.append(String.format("Quedan %d cartas en el Deck\n", cards.size()));
        return sb.toString();
    }
    public String deal(int numCards) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCards && i < cards.size(); i++) {
            Card card = cards.get(i);
            sb.append(String.format("%s,%s\n", card.getSuit(), card.getColor()));
        }
        cards.subList(0, numCards).clear();
        sb.append(String.format("Quedan %d cartas en el Deck\n", cards.size()));
        return sb.toString();
    }
}
