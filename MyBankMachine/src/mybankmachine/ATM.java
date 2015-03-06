/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankmachine;

import javax.swing.JOptionPane;

/**
 *
 * @author Steven Biro
 */
public class ATM {

    private String bank;
    private int test;
    private Double balance, money;

    public ATM(String bank2, Double balance2) {
        bank = bank2;
        balance = balance2;
        Double intRate;
        int numDays;
        JOptionPane.showMessageDialog(null,"Hello and welcome to " + bank + " your curren"
                + "t balance is: " + balance);
        //        test=Integer.parseInt(JOptionPane.showInputDialog("What would you like to do today?"))
        String[] buttons = {"Withdraw", "Deposit", "Calculate Dailiy Interest","Show Balance","Exit"};

        int test = JOptionPane.showOptionDialog(null, "What would you like to do?", "ATM",
                JOptionPane.PLAIN_MESSAGE,1, null, buttons, buttons[4]);

        System.out.println(test);
        while (test != 4) {
            if (test==0) {
                money=Double.parseDouble(JOptionPane.showInputDialog("How much would you like to withdraw?",20));
                balance=balance-money;
            } else if (test==1) {
                money=Double.parseDouble(JOptionPane.showInputDialog("How much would you like to deposit?",20));
                balance=balance+money;
            } else if (test==2) {
                intRate=Double.parseDouble(JOptionPane.showInputDialog("Input your interest rate.",10));
                numDays=Integer.parseInt(JOptionPane.showInputDialog("Input the amount of days",1));
                addDailyInterest(intRate,numDays);
            }

        }
System.exit(0);
    }
    
    public void addDailyInterest(double intRate, int numDays) {
    if (intRate >= 0 && numDays >= 0) {
        double i = (intRate/100) / 365;
        double A = balance * Math.pow((1.0 + i), numDays);
        System.out.println("The interest earned in " + numDays + " = " + (A - balance));
        balance = A;
    }
    else {
        System.out.println("There is a problem with your interest rate or the number of days");
        System.out.println("Negative amounts are not allowed.");
    }
}
}
