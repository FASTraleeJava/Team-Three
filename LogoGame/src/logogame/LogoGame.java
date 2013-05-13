package logogame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogoGame extends JFrame {
	String[] picArray = { "batman-logo-big.gif", "British Petroleum.jpg",
			"GI.jpg", "chrome.jpg", "irish-embassy.jpg", "iTunes.jpg",
			"lidl-logo.jpg", "Motorolla.jpg", "Starbucks.jpg" };
	String[] ansArray = { "Batman", "British Petroleum", "Guaranteed Irish",
			"Google Chrome", "Irish Embassy", "iTunes", "Lidl", "Motorolla",
			"Starbucks" };

	JPanel main;
	ImageIcon icon;
	JLabel label;
	JTextField answer;
	JButton check;

	int correctGuesses = 0;
	int randomPick = 0;

	public LogoGame() {

		this.setLayout(new BorderLayout());
		main = new JPanel();
		main.setLayout(new BorderLayout());

		// randomPick = (int)(Math.random() * picArray.length);

		icon = new ImageIcon(picArray[randomPick]); // Load image
		label = new JLabel(icon); // place image on label
		main.add(label, BorderLayout.CENTER);

		Font myFont = new Font("Arial", Font.BOLD, 14); // Create Font for
														// JTextField

		answer = new JTextField();
		answer.setFont(myFont);
		answer.setHorizontalAlignment(JTextField.CENTER);

		ListenForKeys lForKeys = new ListenForKeys(); // Listen for enter
		answer.addKeyListener(lForKeys);

		main.add(answer, BorderLayout.SOUTH);

		ListenForButton lForButton = new ListenForButton(); // Listen for click

		check = new JButton("check Answer");
		check.addActionListener(lForButton);
		add(check, BorderLayout.SOUTH);

		add(main);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400); // Set location of window
		this.setLocation(400, 400);
		this.setLocation(400, 350); // set location of window
		setVisible(true);

	}

	public static void main(String[] args) {
		new LogoGame();

	}

	// Super class used to share checkAnswer method
	class SuperClass {

		void checkAnswer() {
			if (answer.getText().equalsIgnoreCase(ansArray[randomPick])) {
				correctGuesses++;
				JOptionPane.showMessageDialog(null, "You Guessed Righ\n"
						+ correctGuesses + " correct guesses");
				// randomPick = (int) (Math.random() * picArray.length);
				randomPick++;
				if (randomPick >= picArray.length)// Gone through all the picks
													// so start again
					randomPick = 0;
				icon = new ImageIcon(picArray[randomPick]);
				label.setIcon(icon);
				answer.setText("");

			} else
				JOptionPane.showMessageDialog(null, "Incorrect Guess");

		}
	}

	// For JButton Click
	private class ListenForButton extends SuperClass implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			checkAnswer();

		}
	}

	// For key presses
	private class ListenForKeys extends SuperClass implements KeyListener {
		public void keyTyped(KeyEvent ke) {
		}

		public void keyPressed(KeyEvent ke) {
			if (ke.getKeyCode() == KeyEvent.VK_ENTER)
				checkAnswer();
		}

		public void keyReleased(KeyEvent ke) {
		}
	}
}
