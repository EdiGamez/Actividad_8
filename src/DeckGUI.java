import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeckGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton shuffleButton, headButton, pickButton, handButton, drawButton;
    private JLabel inputLabel;
    private JTextField inputTextField;
    private JTextArea outputTextArea;
    private Deck deck;

    public DeckGUI() {
        setTitle("Mazo de Cartas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 250);

        JPanel buttonPanel = new JPanel();
        shuffleButton = new JButton("Barajar");
        headButton = new JButton("Carta en la cabeza");
        pickButton = new JButton("Carta al azar");
        handButton = new JButton("Mano de 5 cartas");
        drawButton = new JButton("Robar cartas");
        inputLabel = new JLabel("Número de cartas a pedir:");
        inputTextField = new JTextField(5);
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        buttonPanel.add(shuffleButton);
        buttonPanel.add(headButton);
        buttonPanel.add(pickButton);
        buttonPanel.add(handButton);
        buttonPanel.add(inputLabel);
        buttonPanel.add(inputTextField);
        buttonPanel.add(drawButton);

        add(buttonPanel, "North");
        add(new JScrollPane(outputTextArea), "Center");

        shuffleButton.addActionListener(this);
        headButton.addActionListener(this);
        pickButton.addActionListener(this);
        handButton.addActionListener(this);
        drawButton.addActionListener(this);

        deck = new Deck();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == shuffleButton) {
                deck.shuffle();
                outputTextArea.setText("El mazo ha sido barajado.\n");
            } else if (e.getSource() == headButton) {
                outputTextArea.setText("Carta en la cabeza: " + deck.head() + "\n");
            } else if (e.getSource() == pickButton) {
                outputTextArea.setText("Carta al azar: " + deck.pick() + "\n");
            } else if (e.getSource() == handButton) {
                outputTextArea.setText("Mano de 5 cartas:\n" + deck.hand() + "\n");
            } else if (e.getSource() == drawButton) {
                int numCards = Integer.parseInt(inputTextField.getText());
                if (numCards <= 5) {
                    String cards = deck.deal(numCards);
                    outputTextArea.setText("Cartas robadas:\n" + cards + "\n");
                } else {
                    throw new Exception("No puedes robar más de 5 cartas.");
                }
            }
        } catch (NumberFormatException ex) {
            outputTextArea.setText("Por favor ingresa un número válido.\n");
        } catch (Exception ex) {
            outputTextArea.setText(ex.getMessage() + "\n");
        }
    }
}

