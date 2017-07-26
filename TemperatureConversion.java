// Exercise 12.12: TemperatureConversion.java
// Write a temperature conversion application that converts from Fahrenheit
// to Celsius. The Fahrenheit temperature should be entered from the
// keyboard (via a JTextField) and a JLabel should be used to display the
// converted temperature
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConversion extends JFrame implements ActionListener
{
  private JTextField myFahrenheit, celsiusResult;

  public static void main(String[] args)
  {
    TemperatureConversion frame = new TemperatureConversion();
    frame.setTitle("Temperature Converter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }

  public TemperatureConversion()
  {
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new Label("Farenheit"));
    p1.add(myFahrenheit = new JTextField(3));
    p1.add(new Label("Celsius"));
    p1.add(celsiusResult = new JTextField(4));
    celsiusResult.setEditable(false);

    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(p1);

    //TextFieldHandler handler = new TextFieldHandler();
    myFahrenheit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == myFahrenheit)
    {
      int enteredTemp = (Integer.parseInt(myFahrenheit.getText().trim()));
      int celsius = enteredTemp - 32;
      double celsius2 = (double) (celsius * 5) / 9;
      //double celsius = (5/9) * (enteredTemp - 32);

      String s = String.format("%,.2f", celsius2);
      celsiusResult.setText(s);
    }
  }
}
