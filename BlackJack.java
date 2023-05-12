import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJack extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton fold;
    private JButton hit;
    private JButton startGame;
    private JTextField bet;
    private JLabel cards;
    private JLabel action;
    public int cardCount;
    public int firstCard;
    public int secondCard;

    public static void main(String[] args) {
        JFrame frame = new BlackJack();
        frame.setPreferredSize(new Dimension(800,800));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    BlackJack() {
        super("Black Jack");

        fold = new JButton("Fold");
        hit = new JButton("Hit");
        startGame = new JButton("Start Game");
        bet = new JTextField(30);

        panel = new JPanel();
        panel.add(fold);
        panel.add(hit);
        panel.add(bet);
        panel.add(startGame);


        setContentPane(panel);

        startGame.addActionListener(this);
        fold.addActionListener(this);
        hit.addActionListener(this);
        one.addActionListener(this);
        eleven.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startGame) {
            
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

        }

        if(e.getSource() == hit) {
            int card = 0;

        }
    }
}