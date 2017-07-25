// Exercise 12.16: CrapsGUI.java
// Modify the application of Section 5.10 to provide a GUI that enables the
// user to click a JButton to role the dice. The application should also display
// four JLabels and four JTextFields (one JLabel per text field). The text fields
// should be uses to display the values of each die and the sum of the dice after
// each roll. The point should be displayed in the 4th text field when the user
// doesn't win or lose on the first roll and should continue to be displayed
// until the game is lost.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.security.SecureRandom;

public class CrapsGUI extends JFrame
{
  // create secure random number generator for use in method rollDice
  private static final SecureRandom randomNumbers = new SecureRandom();

  // GUI fields
  private JLabel jlabel1, jlabel2, jlabel3, jlabel4, gameStatusLabel;
  private JTextField jtext1, jtext2, jtext3, jtext4;
  private JButton roll, playAgain;

  public CrapsGUI()
  {
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1,1, 2, 2));
    p1.add(roll = new JButton("Roll Dice"));

    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(2, 2, 2, 2));
    p2.add(jlabel1 = new JLabel("Dice 1"));
    p2.add(jtext1 = new JTextField(2));
    jtext1.setEditable(false);
    p2.add(jlabel2 = new JLabel("Dice 2"));
    p2.add(jtext2 = new JTextField(2));
    jtext2.setEditable(false);
    p2.add(jlabel3 = new JLabel("Sum of Dice"));
    p2.add(jtext3 = new JTextField(2));
    jtext3.setEditable(false);
    p2.add(jlabel4 = new JLabel("Points"));
    p2.add(jtext4 = new JTextField(2));
    jtext4.setEditable(false);

    JPanel p3 = new JPanel();
    p3.setLayout(new GridLayout(2, 1, 2, 2));
    p3.add(gameStatusLabel = new JLabel(""));
    p3.add(playAgain = new JButton("Play Again"));

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.NORTH);
    getContentPane().add(p2, BorderLayout.CENTER);
    getContentPane().add(p3, BorderLayout.SOUTH);

    ButtonHandler bHandler = new ButtonHandler();
    roll.addActionListener(bHandler);
    playAgain.addActionListener(bHandler);

  }

  private class ButtonHandler implements ActionListener
  {
    private int myPoint = 0;   // point if no win or loss on first roll
    private int sumOfDice = 0;

    @Override
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource() == roll)
      {
        ButtonHandler game = new ButtonHandler();
        myPoint = game.playCraps(myPoint);
      }

      if(e.getSource() == playAgain)
      {
        jtext1.setText("");
        jtext2.setText("");
        jtext3.setText("");
        jtext4.setText("");
        myPoint = 0;
        sumOfDice = 0;
        gameStatusLabel.setText("");

      }
    }

    public int playCraps(int myPoint)
    {
      int die1 = 1 + randomNumbers.nextInt(6); // first die roll
      int die2 = 1 + randomNumbers.nextInt(6); // second die roll

      sumOfDice = die1 + die2; // sum of die values

      // display the results of this roll
      jtext1.setText(String.valueOf(die1));
      jtext2.setText(String.valueOf(die2));
      jtext3.setText(String.valueOf(sumOfDice));

      if(myPoint == 0)
      {
        if(sumOfDice == 7 || sumOfDice == 11)
        {
          gameStatusLabel.setText("Player wins!");
        }
        else if(sumOfDice == 2 || sumOfDice == 3 || sumOfDice == 12)
        {
          gameStatusLabel.setText("Player loses!");
        }
        else     // did not win or lose so remember point
        {
          myPoint = sumOfDice;
          jtext4.setText(String.valueOf(myPoint));
          gameStatusLabel.setText("Roll Again");
        }
      }
      else
      {
        if(sumOfDice == myPoint) // win by making point
        {
          gameStatusLabel.setText("Player wins!");
        }
        else if(sumOfDice == 7)   // lose by rolling 7 before point
        {
          gameStatusLabel.setText("Player loses!");
        }
        else
        {
          gameStatusLabel.setText("Roll Again");
        }
      }
      return myPoint;
    }
  }
  
  public static void main(String[] args)
  {
    CrapsGUI frame = new CrapsGUI();
    frame.setTitle("Craps");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 400);
    frame.setVisible(true);
  }

}
