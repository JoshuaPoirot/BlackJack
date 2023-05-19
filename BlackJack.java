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
    private JLabel cards;
    private JLabel action;
    private JLabel results;
    public int cardCount;
    public int firstCard;
    public int secondCard;
    public int dcardCount;
    public int dfirstCard;
    public int dsecondCard;
    public boolean gS;

    public static void main(String[] args) {
        JFrame frame = new BlackJack();
        frame.setPreferredSize(new Dimension(400,150));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    BlackJack() {
        super("Black Jack");

        stand = new JButton("Stand");
        stand.setBackground(Color.BLACK);
        stand.setForeground(Color.RED);
        stand.setFont(new Font("Century Gothic", 1, 16));

        hit = new JButton("Hit");
        hit.setBackground(Color.BLACK);
        hit.setForeground(Color.RED);
        hit.setFont(new Font("Century Gothic", 1, 16));

        startGame = new JButton("Start New Game");
        startGame.setBackground(Color.BLACK);
        startGame.setForeground(Color.RED);
        startGame.setFont(new Font("Century Gothic", 1, 16));

        cards = new JLabel("Your hand: ");
        cards.setForeground(Color.WHITE);
        cards.setFont(new Font("Century Gothic", 1, 16));

        action = new JLabel("Your move: ");
        action.setForeground(Color.WHITE);
        action.setFont(new Font("Century Gothic", 1, 16));

        results = new JLabel();
        results.setForeground(Color.WHITE);
        results.setFont(new Font("Century Gothic", 1, 16));
        gS = false;

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(startGame);
        panel.add(hit);
        panel.add(stand);        
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
            if (!gS) {
                gS = true;
                startGame.setText("Game Started");
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
        }
        if (e.getSource() == stand) {
            if (gS) {
            //dealer
            while (dcardCount < 17) {
                int dcard = 0;
                dcard = (int) (Math.random() * 13) + 1;
                if (dcardCount < 10 && dcard == 1) {
                dcardCount += 11;
            }
            else if (dcard > 9) {
                dcardCount += 10;
            }
            else {
                dcardCount += dcard;
            }
            }
            action.setText("You stood");

            if ((dcardCount < cardCount && cardCount <= 21) || (dcardCount > 21 && cardCount <= 21)) {
                results.setText("You Won! The Dealer's total was " + dcardCount);
                gS = false;
                startGame.setText("Start Game");

            }
            else if (dcardCount == cardCount && dcardCount <= 21) {
                results.setText("You Tied! The Dealer's total was " + dcardCount);
                gS = false;
                startGame.setText("Start Game");
            }
            else {
                results.setText("You Lost! The Dealer's total was " + dcardCount);
                gS = false;
                startGame.setText("Start Game");
            }
        }
        }

        if(e.getSource() == hit) {
            if (gS) {
            //player
            int card = 0;
            card = (int) (Math.random() * 13) + 1;
            if (cardCount < 10 && card == 1) {
                cardCount += 11;
            }
            else if (card > 9) {
                cardCount += 10;
            }
            else {
                cardCount += card;
            }
            //dealer
            while (dcardCount < 17) {
                int dcard = 0;
                dcard = (int) (Math.random() * 13) + 1;
            if (dcardCount < 10 && dcard == 1) {
                dcardCount += 11;
            }
            else if (dcard > 9) {
                dcardCount += 10;
            }
            else {
                dcardCount += dcard;
            }
            }
            cards.setText("Your hand total: " + cardCount);
            action.setText("You hit");
            if (cardCount > 21) {
                results.setText("You Bust! Your total was " + cardCount);
                gS = false;
                startGame.setText("Start Game");
            }
        }
        }
    }
}