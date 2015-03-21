package mybankmachine;

import javax.swing.*;

/**
 * @title MyBankMachine
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 6-Mar-2015 11:56:19 AM
 * @purpose The purpose of this program is to start a program that models a bank
 * machine
 */
public class MyBankMachine {

    public static void main(String[] args) {
        String bank;
        Double balance;
        //get basic info for bank machine
        bank = JOptionPane.showInputDialog("Input your bank's name.", "TD");
        balance = Double.parseDouble(JOptionPane.showInputDialog("Input your current balance.", 0));
        //start the bank machine
        ATM atm1 = new ATM(bank, balance);
    }

}
