import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJack extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton stand;
    private JButton hit;
    private JButton startGame;
    private JTextField bet;
    private JLabel cards;
    private JLabel action;
    private JLabel results;
    public int cardCount;
    public int firstCard;
    public int secondCard;
    public int dcardCount;
    public int dfirstCard;
    public int dsecondCard;

    public static void main(String[] args) {
        JFrame frame = new BlackJack();
        frame.setPreferredSize(new Dimension(800,800));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    BlackJack() {
        super("Black Jack");

        stand = new JButton("Stand");
        hit = new JButton("Hit");
        startGame = new JButton("Start Game");
        bet = new JTextField(30);
        cards = new JLabel("Your hand: ");
        action = new JLabel("Your move: ");
        results = new JLabel();

        panel = new JPanel();
        panel.add(stand);
        panel.add(hit);
        panel.add(bet);
        panel.add(startGame);
        panel.add(cards);
        panel.add(action);
        panel.add(results);

        setContentPane(panel);

        startGame.addActionListener(this);
        stand.addActionListener(this);
        hit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startGame) {
            //player
            cardCount = 0;
            dcardCount = 0;
            cards.setText("Your hand: ");
        action.setText("Your move: ");
        results.setText("");
            firstCard = (int) (Math.random() * 13) + 1;
            if (firstCard == 1) {
                cardCount += 11;
            }
            else if (firstCard > 9) {
                cardCount += 10;
            }
            else {
                cardCount += firstCard;
            }

            secondCard = (int) (Math.random() * 13) + 1;
            if (secondCard == 1) {
                if (cardCount <= 10) {
                    cardCount += 11;
                }
                else {
                    cardCount++;
                }
            }
            else if (secondCard > 9) {
                cardCount += 10;
            }
            else {
                cardCount += secondCard;
            }
            //dealer
            dfirstCard = (int) (Math.random() * 13) + 1;
            if (dfirstCard == 1) {
                dcardCount += 11;
            }
            else if (dfirstCard > 9) {
                dcardCount += 10;
            }
            else {
                dcardCount += dfirstCard;
            }

            dsecondCard = (int) (Math.random() * 13) + 1;
            if (dsecondCard == 1) {
                if (dcardCount <= 10) {
                    dcardCount += 11;
                }
                else {
                    dcardCount++;
                }
            }
            else if (dsecondCard > 9) {
                dcardCount += 10;
            }
            else {
                dcardCount += dsecondCard;
            }
            cards.setText("Your hand total: " + cardCount);
        }
        if (e.getSource() == stand) {

            //dealer
            while (dcardCount < 17) {
                int dcard = 0;
                dcard = (int) (Math.random() * 13) + 1;
                if (dcard > 9) {
                    dcard = 10;
                } 
            dcardCount += dcard;
            }
            action.setText("You stood");

            if ((dcardCount < cardCount && cardCount <= 21) || (dcardCount > 21 && cardCount <= 21)) {
                results.setText("You Won! The Dealer's total was " + dcardCount);
            }
            else if (dcardCount == cardCount && dcardCount <= 21) {
                results.setText("You Tied! The Dealer's total was " + dcardCount);
            }
            else {
                results.setText("You Lost! The Dealer's total was " + dcardCount);
            }
        }

        if(e.getSource() == hit) {
            //player
            int card = 0;
            card = (int) (Math.random() * 13) + 1;
            if (card > 9) {
                card = 10;
            } 
            cardCount += card;
            //dealer
            while (dcardCount < 17) {
                int dcard = 0;
                dcard = (int) (Math.random() * 13) + 1;
                if (dcard > 9) {
                    dcard = 10;
                } 
            dcardCount += dcard;
            }
            cards.setText("Your hand total: " + cardCount);
            action.setText("You hit");
        }
        if (e.getSource() == bet) {}
    }
}