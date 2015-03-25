package mybankmachine;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * @title MyBankMachine
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 6-Mar-2015 11:56:19 AM
 * @purpose The purpose of this program is to model a bank machine
 */
public class ATM {

    private final String bank;
    private int test;
    private Double balance, money;

    public ATM(String bank2, Double balance2) {
        //format the decimals
        DecimalFormat df = new DecimalFormat("#,##0.00");
        bank = bank2;
        balance = balance2;
        Double intRate;
        int numDays;
        //output erlcome message 
        JOptionPane.showMessageDialog(null, "Hello and welcome to " + bank + " your curren"
                + "t balance is: $" + df.format(balance));
        //different buttons
        String[] buttons = {"Withdraw", "Deposit", "Calculate Dailiy Interest", "Show Balance", "Exit"};
        //make joptionpane with buttons
        test = JOptionPane.showOptionDialog(null, "What would you like to do?", "ATM",
                JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[4]);

        //while exit is not selected, continue
        while (test != 4) {
            if (test == 0) {//model withdrawing from a bank
                money = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to withdraw?", 20));
                balance = balance - money;
                JOptionPane.showMessageDialog(null, "Your new current balance is: $" + df.format(balance));

            } else if (test == 1) {//model depositing from a bank
                money = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to deposit?", 20));
                balance = balance + money;
                JOptionPane.showMessageDialog(null, "Your new current balance is: $" + df.format(balance));

            } else if (test == 2) {//model dailiy calculating interest 
                intRate = Double.parseDouble(JOptionPane.showInputDialog("Input your interest rate. \nEx. .1% is 10", 10));
                numDays = Integer.parseInt(JOptionPane.showInputDialog("Input the amount of days", 1));
                addDailyInterest(intRate, numDays);
                JOptionPane.showMessageDialog(null, "Your new current balance is: $" + df.format(balance));

            } else if (test == 3) {//output currect balance
                JOptionPane.showMessageDialog(null, "Your new current balance is: $" + df.format(balance));
            }
            //reask what the user would like to do with joptionpane
            test = JOptionPane.showOptionDialog(null, "Would you like to do anything else?", "ATM",
                    JOptionPane.PLAIN_MESSAGE, 3, null, buttons, buttons[4]);
        }
        //exit when the exit button is selected
        System.exit(0);
    }

    public void addDailyInterest(double intRate, int numDays) { //daily interest method as given by the teacher
        DecimalFormat df = new DecimalFormat("#,##0.00");
        if (intRate >= 0 && numDays >= 0) {
            double i = (intRate / 100) / 365;
            double A = balance * Math.pow((1.0 + i), numDays);
            JOptionPane.showMessageDialog(null, "The interest earned in " + numDays + " days is: $" + df.format(A - balance));
            balance = A;
        } else {
            JOptionPane.showMessageDialog(null, "There is a problem with your interest rate or the number of days");
            JOptionPane.showMessageDialog(null, "Negative amounts are not allowed.");
        }
    }
}
