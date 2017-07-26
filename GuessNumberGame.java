// Exercise 12.14 GuessNumberGame.java
// Write an application that plays a "guess the number game" as follows:
// The application should choose a random number between 1-1000.
// A JTextField should be used to input the guess. As each guess is input,
// the background color should change to red or blue to indicate if the user
// is getting warmer or colder and a JLabel should display "TOO HIGH" or
// "TOO LOW" to help the user narrow in. When the user gets the correct number,
// "Correct!" should be displayed and the JTextField should change to
// uneditable. A JButton should be provided to let the user play the game again.
// When JButton is clicked, a new number is generated and JTextField is editable again.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessNumberGame extends JFrame implements ActionListener
{
  private JTextField userGuess;
  private JButton playAgain;
  private JLabel jlabel1;
  private int answer;
  private int previousGuess = 0;

  public GuessNumberGame()
  {
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(jlabel1 = new JLabel(
      "I have a number between 1 and 1000. Can you guess my number? Enter your first guess."));

    JPanel p2 = new JPanel();
    p2.add(userGuess = new JTextField(5));

    JPanel p3 = new JPanel();
    p3.add(playAgain = new JButton("Play Again"));

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.NORTH);
    getContentPane().add(p2, BorderLayout.CENTER);
    getContentPane().add(p3, BorderLayout.SOUTH);

    userGuess.addActionListener(this);
    playAgain.addActionListener(this);

    answer = GuessNumberGame.generateNumber();
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == userGuess)
    {
      int guess = (Integer.parseInt(userGuess.getText().trim()));

      if(guess == answer)
      {
        jlabel1.setText("Correct!");
        userGuess.setEditable(false);
      }
      if(guess > answer)
      {
        jlabel1.setText("Too High");
        userGuess.setText("");
      }
      if(guess < answer)
      {
        jlabel1.setText("Too Low");
        userGuess.setText("");
      }

      int difference1 = Math.abs(answer - previousGuess);
      int difference2 = Math.abs(answer - guess);

      if(difference2 < difference1)
      {
        userGuess.setBackground(Color.red);
      }
      else
      {
        userGuess.setBackground(Color.blue);
      }
      previousGuess = guess;
    }

    if(e.getSource() == playAgain)
    {
      userGuess.setEditable(true);
      answer = GuessNumberGame.generateNumber();
      userGuess.setText("");
      userGuess.setBackground(Color.white);
      jlabel1.setText("I have selected a new number between 1 and 1000. Please enter your first guess.");
    }
  }

  public static int generateNumber()
  {
    Random randomNumber = new Random();
    int answer = 1 + randomNumber.nextInt(1000);
    return answer;
  }

  public static void main(String[] args)
  {
    GuessNumberGame frame = new GuessNumberGame();
    frame.setTitle("Guess the Number");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 200);
    frame.setVisible(true);
  }

}
