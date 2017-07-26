// Exercise 12.9 Calculator.java
// Create a calculator GUI, does not need to have functionality
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame
{
  private JTextField calcTF;
  private JButton jbtAdd, jbtSubtract, jbtDivide, jbtMultiply;
  private JButton jbtDecimal, jbtEquals;
  private JButton jbt1, jbt2, jbt3, jbt4, jbt5, jbt6, jbt7, jbt8, jbt9, jbt0;

  public static void main(String[] args)
  {
    Calculator frame = new Calculator();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // Constructor
  public Calculator()
  {
    setTitle("Calculator");

    // Use panel p1 for the text field
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1, 1, 2, 2));
    p1.add(calcTF = new JTextField());

    // Use panel p2 for the buttons
    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(4, 4, 2, 2));
    p2.add(jbt7 = new JButton("7"));
    p2.add(jbt8 = new JButton("8"));
    p2.add(jbt9 = new JButton("9"));
    p2.add(jbtDivide = new JButton("/"));

    p2.add(jbt4 = new JButton("4"));
    p2.add(jbt5 = new JButton("5"));
    p2.add(jbt6 = new JButton("6"));
    p2.add(jbtMultiply = new JButton("*"));

    p2.add(jbt1 = new JButton("1"));
    p2.add(jbt2 = new JButton("2"));
    p2.add(jbt3 = new JButton("3"));
    p2.add(jbtSubtract = new JButton("-"));

    p2.add(jbt0 = new JButton("0"));
    p2.add(jbtDecimal = new JButton("."));
    p2.add(jbtEquals = new JButton("="));
    p2.add(jbtAdd = new JButton("+"));


    // Set FlowLayout for the frame and add panels to the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.NORTH);
    getContentPane().add(p2, BorderLayout.SOUTH);


  }
}
