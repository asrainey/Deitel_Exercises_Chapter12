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

public class CrapsGUI.java extends JFrame
{
  // create secure random number generator for use in method rollDice
  private static final SecureRandom randomNumbers = new SecureRandom();

  // enum type with constants that represent the game status
  private enum Status {CONTINUE, WON, LOST};

  // constants that represent common rolls of the dice
  private static final int SNAKE_EYES = 2;
  private static final int TREY = 3;
  private static final int SEVEN = 7;
  private static final int YO_LEVEN = 11;
  private static final int BOX_CARS = 12;

  // GUI fields
  private JLabel jlabel1, jlabel2, jlabel3, jlabel4;
  private JTextField jtext1, jtext2, jtext3, jtext4;
  private JButton roll, playAgain;

  public CrapsGUI()
  {
    JPanel p1 = new JPanel();
    p1.setLayout = (new GridLayout(1,1, 2, 2));
    p1.add(roll = new JButton("Roll Dice"));

    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(2, 2, 2, 2));
    p2.add(jlabel1 = new JLabel("Dice 1"));
    p2.add(jtext1 = new JTextField(2));
    p2.add(jlabel2 = new JLabel("Dice 2"));
    p2.add(jtext2 = new JTextField(2));
    p2.add(jlabel3 = new JLabel("Sum of Dice"));
    p2.add(jtext3 = new JTextField(2));
    p2.add(jlabel4 = new JLabel("Points"));
    p2.add(jtext4 = new JTextField(2));

    JPanel p3 = new JPanel();
    p3.add(playAgain = new JButton("Play Again"));

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.NORTH);
    getContentPane().add(p2, BorderLayout.CENTER);
    getContentPane().add(p3, BorderLayout.SOUTH);

    roll.addActionListener(this);
    playAgain.addActionListener(this);

    TextFieldHandler handler = new TextFieldHandler();
    jtext1.addActionListener(handler);
    jtext2.addActionListener(handler);
    jtext3.addActionListener(handler);
    jtext4.addActionListener(handler);
  }

  private class TextFieldHandler implements ActionListener
  {
    @Override
    public void actionPerformed(Action Event e)
    {
      
    }
  }


  public static void main(String[] args)
  {

  }
}


  // plays one game of craps
  public static void main(String[] args)
  {
    int myPoint = 0;   // point if no win or loss on first roll
    Status gameStatus;  // can contain CONTINUE, WON or LOST

    int sumOfDice = rollDice();  // first roll of the dice

    // determine game status and point based on first roll
    switch(sumOfDice)
    {
      case SEVEN:    // win with 7 on the first roll
      case YO_LEVEN: // win with 11 on the first roll
      gameStatus = Status.WON;
      break;
      case SNAKE_EYES:  // lose with 2 on first roll
      case TREY:        // lose with 3 on first roll
      case BOX_CARS:    // lose with 12 on first roll
      gameStatus = Status.LOST;
      break;
      default:     // did not win or lose so remember point
      gameStatus = Status.CONTINUE;   // game is not over
      myPoint = sumOfDice;     // remember the point
      System.out.printf("Point is %d\n", myPoint);
      break;
    }
    // while game is not complete
    while(gameStatus == Status.CONTINUE)  // not WON or LOST
    {
      sumOfDice = rollDice();   // roll dice again

      // determine game status
      if(sumOfDice == myPoint) // win by making point
        gameStatus = Status.WON;
      else
      if(sumOfDice == SEVEN)   // lose by rolling 7 before point
        gameStatus = Status.LOST;
    }

    // display won or lost message
    if(gameStatus == Status.WON)
      System.out.println("Player wins");
    else
      System.out.println("Player loses");
  }

  // roll dice, calculate sum and display results
  public static int rollDice()
  {
    // pick random die values
    int die1 = 1 + randomNumbers.nextInt(6); // first die roll
    int die2 = 1 + randomNumbers.nextInt(6); // second die roll

    int sum = die1 + die2; // sum of die values

    // display the results of this roll
    System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);

    return sum;
  }
}
